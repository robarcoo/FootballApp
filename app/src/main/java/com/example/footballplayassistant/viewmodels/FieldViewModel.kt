package com.example.footballplayassistant.viewmodels

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
import kotlinx.coroutines.launch

class FieldViewModel(
    private val deleteFieldUseCase: DeleteFieldUseCase,
    private val getAllFieldsUseCase: GetAllFieldsUseCase,
    private val getFieldUseCase: GetFieldUseCase,
    private val postFieldUseCase: PostFieldUseCase,
    private val putFieldUseCase: PutFieldUseCase) : ViewModel() {

    var _state = MutableStateFlow(FieldState())

    private var _isServerError = MutableStateFlow(false)
    val isServerError: StateFlow<Boolean> = _isServerError.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllFieldsUseCase.execute(
                cachePolicy = CachePolicy(CachePolicy.Type.ALWAYS)
            ).collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as DataAnswer<*>
                        _state.value.fieldList = answer.data.map { field -> field as FieldClass }.toMutableList()
                        if (answer.status) {
                            _isServerError.update { false }
                        } else {
                            _isServerError.update { false }
                        }
                    }
                    is Result.ErrorNetwork -> { _isServerError.update { false } }
                    is Result.Error -> { _isServerError.update { true } }
                }
            }
        }


    }
}