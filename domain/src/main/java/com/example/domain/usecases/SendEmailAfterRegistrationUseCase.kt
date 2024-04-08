package com.example.domain.usecases

import com.example.domain.repositories.AuthenticationRepository

class SendEmailAfterRegistrationUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(email: String){
        authenticationRepository.sendEmailAfterRegistration(email = email)
    }
}