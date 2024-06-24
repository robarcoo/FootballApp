package com.example.footballplayassistant.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.field.interfaces.DeleteFieldUseCase
import com.example.domain.usecases.field.interfaces.GetAllFieldsUseCase
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import com.example.domain.usecases.field.interfaces.PostFieldUseCase
import com.example.domain.usecases.field.interfaces.PutFieldUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FieldViewModel(
    private val deleteFieldUseCase: DeleteFieldUseCase,
    private val getAllFieldsUseCase: GetAllFieldsUseCase,
    private val getFieldUseCase: GetFieldUseCase,
    private val postFieldUseCase: PostFieldUseCase,
    private val putFieldUseCase: PutFieldUseCase) : ViewModel() {

    private var _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    fun updateEmail(value: String) {
        _email.update { value }
    }

}