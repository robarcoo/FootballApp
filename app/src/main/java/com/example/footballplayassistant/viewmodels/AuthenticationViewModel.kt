package com.example.footballplayassistant.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Result
import com.example.domain.models.auth.UserAuthorization
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

    //sign in
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

    fun signIn(user: UserAuthorization) {
        val res = checkUserForAuthorizationUseCase.execute(user = user)
        viewModelScope.launch {
            res.collect {
                when (it) {
                    is Result.Success<*> -> {
                        _isAuthorization.update { true }
                        _isError.update { false }
                        _isServerError.update { false }
                        Log.d("MyLog", "Answer in VM: ${it.value}")
                    }

                    is Result.ErrorNetwork -> {
                        _isAuthorization.update { false }
                        _isError.update { true }
                        _isServerError.update { false }
                        Log.d("MyLog", "Error network in VM: $it")
                    }

                    else -> {
                        Log.d("MyLog", "unknown error in VM: $it")
                        _isServerError.update { true }
                    }
                }
            }
        }
    }

//    fun signUpStepOne(user: UserRegistrationStepOne) {
//        checkUserRegistrationStepOneUseCase.execute(user = user)
//    }
//
//    fun signUp(user: UserRegistration) {
//       saveUserToDBUseCase.execute(user = user)
//    }

//    fun sendCodeToEmail(email: String) {
//        viewModelScope.launch { sendCodeToEmailUseCase.execute(email = email)}
//    }
//
//    fun sendCodeToPhone(phone: String) {
//        viewModelScope.launch { sendCodeToPhoneUseCase.execute(phone = phone)}
//    }
//
//    fun checkRegistrationCode(code: Int) {
//        viewModelScope.launch { checkRegistrationCodeUseCase.execute(code = code)}
//    }
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