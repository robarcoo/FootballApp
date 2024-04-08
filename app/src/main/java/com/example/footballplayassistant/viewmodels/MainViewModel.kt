package com.example.footballplayassistant.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.UserDataAuthorization
import com.example.domain.models.UserDataRegistration
import com.example.domain.usecases.CheckCodeUseCase
import com.example.domain.usecases.CheckUniqueNicknameUseCase
import com.example.domain.usecases.CheckUserForAuthorizationUseCase
import com.example.domain.usecases.SaveUserToDBUseCase
import com.example.domain.usecases.SendCodeToEmailUseCase
import com.example.domain.usecases.SendCodeToPhoneUseCase
import com.example.domain.usecases.SendEmailAfterRegistrationUseCase

class MainViewModel(
    val checkCodeUseCase: CheckCodeUseCase,
    val checkUniqueNicknameUseCase: CheckUniqueNicknameUseCase,
    val checkUserForAuthorizationUseCase: CheckUserForAuthorizationUseCase,
    val saveUserToDBUseCase: SaveUserToDBUseCase,
    val sendCodeToEmailUseCase: SendCodeToEmailUseCase,
    val sendCodeToPhoneUseCase: SendCodeToPhoneUseCase,
    val sendEmailAfterRegistrationUseCase: SendEmailAfterRegistrationUseCase
) : ViewModel() {

    fun signIn(user: UserDataAuthorization){
        checkUserForAuthorizationUseCase.execute(user = user)
    }

    fun signUp(user: UserDataRegistration){
        saveUserToDBUseCase.execute(user = user)
    }

    fun sendCodeToEmail(email: String){
        sendCodeToEmailUseCase.execute(email = email)
    }

    fun sendCodeToPhone(phone: String){
        sendCodeToPhoneUseCase.execute(phone = phone)
    }

    fun checkCode(code: Int){
        checkCodeUseCase.execute(code = code)
    }

    fun checkNickname(nickname: String){
        checkUniqueNicknameUseCase.execute(nickname = nickname)
    }

    fun sendAutoEmail(email: String){
        sendEmailAfterRegistrationUseCase.execute(email = email)
    }

    fun checkTwoPasswords(pass1: String, pass2: String): Boolean {
        return pass1 == pass2
    }

    fun isPasswordCorrect(pass: String): Boolean {
        return !pass.isEmpty()
    }

    fun isNameCorrect(name: String): Boolean{
        return !name.isEmpty()
    }

    fun isNumberCorrect(number: String): Boolean{
        return !number.isEmpty()
    }

    fun isEmailCorrect(email: String): Boolean{
        return !email.isEmpty()
    }


//    private val watchesMutable = MutableLiveData<List<WatchInfo>>()
//    val watchesLive = watchesMutable
//
//    init{
//        loadWatch()
//    }

//    private fun loadWatch(){
//        val watches = getWatchUseCase.execute()
//        watchesMutable.value = watches
//    }
}