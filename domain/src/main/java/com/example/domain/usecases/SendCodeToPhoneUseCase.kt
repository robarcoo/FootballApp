package com.example.domain.usecases

import com.example.domain.repositories.AuthenticationRepository

class SendCodeToPhoneUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(phone: String){
        authenticationRepository.sendCodeToPhone(phone = phone)
    }
}