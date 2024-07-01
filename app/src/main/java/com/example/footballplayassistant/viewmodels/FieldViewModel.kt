package com.example.footballplayassistant.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.field.FieldDto
import com.example.data.dto.FieldState
import com.example.domain.models.DataAnswer
import com.example.domain.models.PostDataAnswer
import com.example.domain.repositories.CachePolicy
import com.example.domain.usecases.field.interfaces.DeleteFieldUseCase
import com.example.domain.usecases.field.interfaces.GetAllFieldsUseCase
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import com.example.domain.usecases.field.interfaces.PostFieldUseCase
import com.example.domain.usecases.field.interfaces.PutFieldUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.domain.models.Result
import com.example.domain.models.field.AreaTypeClass
import com.example.domain.models.field.FieldClass
import com.example.domain.models.field.MetroClass
import com.example.domain.models.field.UfImage
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.collect
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

    private fun mapFieldDtoToFieldClass(fieldDto: FieldDto, id : Int, time : String, ufUser : Long): FieldClass {
        return FieldClass(
            id = id.toString(),
            ufCreated = time,
            ufStatus = AreaTypeClass(id = 0, value = ""),
            ufName = fieldDto.ufName,
            ufTown = MetroClass(id = fieldDto.ufTown.toLong(), ufName = ""),
            ufAddress = fieldDto.ufAddress,
            ufOpening = fieldDto.ufOpening,
            ufClosing = fieldDto.ufClosing,
            ufPhone = fieldDto.ufPhone,
            ufNearMetro = fieldDto.ufNearMetro?.let { MetroClass(id = it.toLong(), ufName = "") },
            ufSite = fieldDto.ufSite,
            ufDescription = fieldDto.ufDescription,
            ufPlayerCapacity = fieldDto.ufPlayerCapacity,
            ufLength = fieldDto.ufLength,
            ufWidth = fieldDto.ufWidth,
            ufAreaType = AreaTypeClass(id = fieldDto.ufAreaType.toLong(), value = ""),
            ufLighting = AreaTypeClass(id = fieldDto.ufLighting.toLong(), value = ""),
            ufShower = fieldDto.ufShower,
            ufImages = fieldDto.ufImages.map { UfImage(src = it) },
            ufCover = AreaTypeClass(id = fieldDto.ufCover.toLong(), value = ""),
            ufDressingRooms = AreaTypeClass(id = fieldDto.ufDressingRooms.toLong(), value = ""),
            ufStands = fieldDto.ufStands,
            ufUser = ufUser,
            ufRating = 0.0f,
            ufTags = emptyList(),
            favorite = false
        )
    }
    private fun updateField(field : FieldClass) {
        _state.update {
            it.copy(
                id = field.id,
                ufCreated = field.ufCreated,
                ufStatus = field.ufStatus,
                ufName = field.ufName,
                ufTown = field.ufTown,
                ufAddress = field.ufAddress,
                ufOpening = field.ufOpening,
                ufClosing = field.ufClosing,
                ufPhone = field.ufPhone,
                ufNearMetro = field.ufNearMetro,
                ufSite = field.ufSite,
                ufDescription = field.ufDescription,
                ufPlayerCapacity = field.ufPlayerCapacity,
                ufLength = field.ufLength,
                ufWidth = field.ufWidth,
                ufAreaType = field.ufAreaType,
                ufLighting = field.ufLighting,
                ufShower = field.ufShower,
                ufImages = field.ufImages.toMutableList(),
                ufCover = field.ufCover,
                ufDressingRooms = field.ufDressingRooms,
                ufStands = field.ufStands,
                ufUser = field.ufUser,
                ufRating = field.ufRating,
                ufTags = field.ufTags.toMutableList(),
                favorite = field.favorite
            )
        }
    }

    private var _isServerError = MutableStateFlow(false)
    val isServerError: StateFlow<Boolean> = _isServerError.asStateFlow()



    init {
        getAllFields()
    }


    fun postField(data: FieldDto, ufUser: Long, cachePolicy: CachePolicy = CachePolicy(CachePolicy.Type.NEVER)) {
        viewModelScope.launch {
            postFieldUseCase.execute(data, cachePolicy).
                    stateIn(viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000),
                        Result.Loading(Unit)).collect {
                            when (it) {
                                is Result.Success<*> -> {
                                    val saveIt = it.copy()
                                    val answer = saveIt.value as PostDataAnswer
                                    val saveField = mapFieldDtoToFieldClass(data, answer.data.id,
                                        answer.time, ufUser)
                                    _state.value.fieldList.add(saveField)

                                    if (answer.status) {
                                        _isServerError.update { false }
                                    } else {
                                        _isServerError.update { false }
                                    }
                                }
                                is Result.ErrorNetwork -> {
                                    _isServerError.update { false }
                                }
                                is Result.Error -> {
                                    _isServerError.update { true }
                                }
                                else -> println("RESULT $it")
                            }
            }
        }

    }

    fun deleteField(id : Int) {
        viewModelScope.launch {
            deleteFieldUseCase.execute(id).stateIn(viewModelScope, started = SharingStarted.WhileSubscribed(5_000),
                Result.Loading(Unit)).collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as DataAnswer<*>
                        updateField(answer.data.map { result -> result as FieldClass }.first())
                        if (answer.status) {
                            _isServerError.update { false }
                        } else {
                            _isServerError.update { false }
                        }
                    }
                    is Result.ErrorNetwork -> {
                        _isServerError.update { false }
                    }
                    is Result.Error -> {
                        _isServerError.update { true }
                    }
                    else -> println("RESULT $it")
                }
            }
            }
        }

    fun getField(id : Int, cachePolicy: CachePolicy = CachePolicy(CachePolicy.Type.NEVER)) {
        viewModelScope.launch {
            getFieldUseCase.execute(id, cachePolicy = cachePolicy)
                .stateIn(viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000),
                    Result.Loading(Unit)).collect {
                    when (it) {
                        is Result.Success<*> -> {
                            val saveIt = it.copy()
                            val answer = saveIt.value as DataAnswer<*>
                            updateField(answer.data.map { result -> result as FieldClass }.first())
                            if (answer.status) {
                                _isServerError.update { false }
                            } else {
                                _isServerError.update { false }
                            }
                        }
                        is Result.ErrorNetwork -> {
                            _isServerError.update { false }
                        }
                        is Result.Error -> {
                            _isServerError.update { true }
                        }
                        else -> println("RESULT $it")
                    }
                    }

        }
    }

    fun getAllFields(cachePolicy: CachePolicy = CachePolicy(CachePolicy.Type.NEVER)) {
        viewModelScope.launch {
            getAllFieldsUseCase.execute(
                cachePolicy = cachePolicy)
                .stateIn(viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000),
                    Result.Loading(Unit)).collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as DataAnswer<*>
                        _state.update { field ->
                            field.copy(fieldList = answer.data.map { result ->
                                result as FieldClass
                            }.toMutableList())
                        }
                        if (answer.status) {
                            _isServerError.update { false }
                        } else {
                            _isServerError.update { false }
                        }
                    }
                    is Result.ErrorNetwork -> {
                        _isServerError.update { false }
                    }
                    is Result.Error -> {
                        _isServerError.update { true }
                    }
                    else -> println("RESULT $it")
                }
            }
        }
    }
}