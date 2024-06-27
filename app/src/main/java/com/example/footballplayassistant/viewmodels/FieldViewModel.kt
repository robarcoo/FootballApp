package com.example.footballplayassistant.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.dto.FieldState
import com.example.domain.models.CommonAnswer
import com.example.domain.models.DataAnswer
import com.example.domain.repositories.CachePolicy
import com.example.domain.usecases.field.interfaces.DeleteFieldUseCase
import com.example.domain.usecases.field.interfaces.GetAllFieldsUseCase
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import com.example.domain.usecases.field.interfaces.PostFieldUseCase
import com.example.domain.usecases.field.interfaces.PutFieldUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.domain.models.Result
import com.example.domain.models.field.FieldClass
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FieldViewModel(
    private val deleteFieldUseCase: DeleteFieldUseCase,
    private val getAllFieldsUseCase: GetAllFieldsUseCase,
    private val getFieldUseCase: GetFieldUseCase,
    private val postFieldUseCase: PostFieldUseCase,
    private val putFieldUseCase: PutFieldUseCase) : ViewModel() {

    private var _state = MutableStateFlow(FieldState())
    val state = _state.asStateFlow()

    private var fields = MutableStateFlow<MutableList<FieldClass>>(mutableListOf())
    fun setField(fieldList : MutableList<FieldClass>) {
        fields.value = fieldList
    }


    private var _isServerError = MutableStateFlow(false)
    val isServerError: StateFlow<Boolean> = _isServerError.asStateFlow()



    init {
        getAllFields()
    }

    fun getAllFields() {
        viewModelScope.launch {
            getAllFieldsUseCase.execute(
                cachePolicy = CachePolicy(CachePolicy.Type.ALWAYS))
                .stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(5_000), Result).collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()

                        val answer = saveIt.value as DataAnswer<*>
                        _state.update { field ->
                            field.copy(fieldList = answer.data.toMutableList() as MutableList<FieldClass>)
                        }
                        if (answer.status) {
                            _isServerError.update { false }
                        } else {
                            _isServerError.update { false }
                        }
                    }
                    is Result.ErrorNetwork -> {
                        println("ERROR NETWORK")
                        _isServerError.update { false }
                    }
                    is Result.Error -> {
                        println("ERROR")
                        _isServerError.update { true }
                    }
                    else -> println("RESULT $it")
                }
            }
        }
    }
}