package com.example.footballplayassistant.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CommonAnswer
import com.example.domain.models.Result
import com.example.domain.models.auth.UserAuthorization
import com.example.domain.models.auth.UserRegistration
import com.example.domain.models.auth.UserRegistrationStepOne
import com.example.domain.usecases.auth.interfaces.CheckRecoveryCodeUseCase
import com.example.domain.usecases.auth.interfaces.CheckRegistrationCodeUseCase
import com.example.domain.usecases.auth.interfaces.CheckUserForAuthorizationUseCase
import com.example.domain.usecases.auth.interfaces.CheckUserRegistrationStepOneUseCase
import com.example.domain.usecases.auth.interfaces.SaveUserToDBUseCase
import com.example.domain.usecases.auth.interfaces.SendCodeToEmailUseCase
import com.example.domain.usecases.auth.interfaces.SendCodeToPhoneUseCase
import com.example.footballplayassistant.presentation.enums.FilterPhoneEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class AuthenticationViewModel(
    private val checkRegistrationCodeUseCase: CheckRegistrationCodeUseCase,
    private val checkRecoveryCodeUseCase: CheckRecoveryCodeUseCase,
    private val checkUserForAuthorizationUseCase: CheckUserForAuthorizationUseCase,
    private val checkUserRegistrationStepOneUseCase: CheckUserRegistrationStepOneUseCase,
    private val saveUserToDBUseCase: SaveUserToDBUseCase,
    private val sendCodeToEmailUseCase: SendCodeToEmailUseCase,
    private val sendCodeToPhoneUseCase: SendCodeToPhoneUseCase
) : ViewModel() {

    //signIn
    private var _filterButtonState = MutableStateFlow(FilterPhoneEmail.Phone.ordinal)
    val filterButtonState: StateFlow<Int> = _filterButtonState.asStateFlow()
    fun updateFilterButtonState(value: Int) {
        _filterButtonState.update { value }
    }

    private var _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError.asStateFlow()
    fun updateError(value: Boolean) {
        _isError.update { value }
    }

    private var _phone = MutableStateFlow("")
    val phone: StateFlow<String> = _phone.asStateFlow()
    fun updatePhone(value: String) {
        _phone.update { value }
    }

    private var _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    fun updateEmail(value: String) {
        _email.update { value }
    }

    private var _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()
    fun updatePassword(value: String) {
        _password.update { value }
    }

    private var _isButtonEnable = MutableStateFlow(false)
    val isButtonEnable: StateFlow<Boolean> = _isButtonEnable.asStateFlow()
    fun updateButtonEnable(value: Boolean) {
        _isButtonEnable.update { value }
    }


    private var _isAuthorization = MutableStateFlow(false)
    val isAuthorization: StateFlow<Boolean> = _isAuthorization.asStateFlow()

    private var _isServerError = MutableStateFlow(false)
    val isServerError: StateFlow<Boolean> = _isServerError.asStateFlow()

    //signUpEnterPhone
    private var _isUnique = MutableStateFlow(false)
    val isUnique: StateFlow<Boolean> = _isUnique.asStateFlow()

    private var _isSendRequest = MutableStateFlow(false)
    val isSendRequest: StateFlow<Boolean> = _isSendRequest.asStateFlow()

    //signUpCode
    private var _isCodeCorrect = MutableStateFlow(false)
    val isCodeCorrect: StateFlow<Boolean> = _isCodeCorrect.asStateFlow()

    //signUpStepOne
    private var _nickname = MutableStateFlow("")
    val nickname: StateFlow<String> = _nickname.asStateFlow()
    fun updateNickname(value: String) {
        _nickname.update { value }
    }

    private var _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()
    fun updateName(value: String) {
        _name.update { value }
    }

    private var _surname = MutableStateFlow("")
    val surname: StateFlow<String> = _surname.asStateFlow()
    fun updateSurname(value: String) {
        _surname.update { value }
    }

    private var _isAllUnique = MutableStateFlow(false)
    val isAllUnique: StateFlow<Boolean> = _isAllUnique.asStateFlow()

    //signUpStepTwo
    private var _confirmPassword = MutableStateFlow("")
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()
    fun updateConfirmPassword(value: String) {
        _confirmPassword.update { value }
    }
    private var _isAllCorrect = MutableStateFlow(false)
    val isAllCorrect: StateFlow<Boolean> = _isAllCorrect.asStateFlow()


    fun signIn(user: UserAuthorization) {
        val res = checkUserForAuthorizationUseCase.execute(user = user)
        viewModelScope.launch {
            res.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as CommonAnswer
                        if (answer.status) {
                            _isAuthorization.update { true }
                            _isError.update { false }
                            _isServerError.update { false }
                        } else {
                            _isAuthorization.update { false }
                            _isError.update { true }
                            _isServerError.update { false }
                        }
                    }

                    is Result.ErrorNetwork -> {
                        _isAuthorization.update { false }
                        _isError.update { true }
                        _isServerError.update { false }
                    }

                    else -> {
                        _isServerError.update { true }
                    }
                }
            }
        }
    }

    fun signUpStepOne(user: UserRegistrationStepOne) {
        val res = checkUserRegistrationStepOneUseCase.execute(user = user)
        viewModelScope.launch {
            res.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as CommonAnswer
                        if (answer.status) {
                            Log.d("MyLog", "isAllUnique success!")
                            _isAllUnique.update { true }
                            _isSendRequest.update { true }
                            _isServerError.update { false }
                        } else {
                            Log.d("MyLog", "isAllUnique fail!")
                            _isAllUnique.update { false }
                            _isServerError.update { false }
                        }
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork!")
                        _isServerError.update { false }
                    }

                    is Result.Error -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value
                        Log.d("MyLog", "_isServerError: ${answer.localizedMessage}")
                        _isServerError.update { true }
                    }
                }
            }
        }
    }

    fun signUp(user: UserRegistration) {
        val res = saveUserToDBUseCase.execute(user = user)
        viewModelScope.launch {
            res.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as CommonAnswer
                        if (answer.status) {
                            _isAllCorrect.update { true }
                            _isServerError.update { false }
                        } else {
                            _isAllCorrect.update { false }
                            _isServerError.update { false }
                        }
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork!")
                        _isServerError.update { false }
                    }

                    is Result.Error -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value
                        Log.d("MyLog", "_isServerError: ${answer.localizedMessage}")
                        _isServerError.update { true }
                    }
                }
            }
        }
    }

    //    fun sendCodeToEmail(email: String) {
//        viewModelScope.launch { sendCodeToEmailUseCase.execute(email = email)}
//    }
//
    fun sendCodeToPhone(phone: String) {
        val res = sendCodeToPhoneUseCase.execute(phone = phone)
        viewModelScope.launch {
            res.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as CommonAnswer
                        if (answer.status) {
                            Log.d("MyLog", "phone number is unique!")
                            _isUnique.update { true }
                            _isSendRequest.update { true }
                            _isServerError.update { false }
                        } else {
                            Log.d("MyLog", "phone number is NOT unique!")
                            _isUnique.update { false }
                            _isServerError.update { false }
                        }
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork!")
                        _isServerError.update { false }
                    }

                    is Result.Error -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value
                        Log.d("MyLog", "_isServerError: ${answer.message}")
                        _isServerError.update { true }
                    }
                }
            }
        }
    }

    fun checkRegistrationCode(code: String) {
        val res = checkRegistrationCodeUseCase.execute(code = code)
        viewModelScope.launch {
            res.collect {
                when (it) {
                    is Result.Success<*> -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value as CommonAnswer
                        if (answer.status) {
                            Log.d("MyLog", "_isCodeCorrect success!")
                            _isCodeCorrect.update { true }
                            _isServerError.update { false }
                        } else {
                            Log.d("MyLog", "_isCodeCorrect fail!")
                            _isCodeCorrect.update { false }
                            _isServerError.update { false }
                        }
                    }

                    is Result.ErrorNetwork -> {
                        Log.d("MyLog", "ErrorNetwork!")
                        _isServerError.update { false }
                    }

                    is Result.Error -> {
                        val saveIt = it.copy()
                        val answer = saveIt.value
                        Log.d("MyLog", "_isServerError: ${answer.localizedMessage}")
                        _isServerError.update { true }
                    }
                }
            }
        }
    }
//
//    fun checkRecoveryCode(code: Int) {
//        viewModelScope.launch { checkRecoveryCodeUseCase.execute(code = code)}
//    }


}

//
//class AuthenticationViewModelFactory(
//    private val checkRegistrationCodeUseCase: CheckRegistrationCodeUseCase,
//    private val checkRecoveryCodeUseCase: CheckRecoveryCodeUseCase,
//    private val checkUserForAuthorizationUseCase: CheckUserForAuthorizationUseCase,
//    private val checkUserRegistrationStepOneUseCase: CheckUserRegistrationStepOneUseCase,
//    private val saveUserToDBUseCase: SaveUserToDBUseCase,
//    private val sendCodeToEmailUseCase: SendCodeToEmailUseCase,
//    private val sendCodeToPhoneUseCase: SendCodeToPhoneUseCase
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(AuthenticationViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return AuthenticationViewModel(
//                checkRegistrationCodeUseCase,
//                checkRecoveryCodeUseCase,
//                checkUserForAuthorizationUseCase,
//                checkUserRegistrationStepOneUseCase,
//                saveUserToDBUseCase,
//                sendCodeToEmailUseCase,
//                sendCodeToPhoneUseCase
//            ) as T
//        }
//        throw IllegalArgumentException("Unable to construct viewmodel")
//    }
//}