package com.example.domain.usecases

import com.example.domain.repositories.AuthenticationRepository

class SendCodeToEmailUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(email: String){
        authenticationRepository.sendCodeToEmail(email = email)
    }
}