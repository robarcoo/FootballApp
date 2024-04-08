package com.example.domain.usecases

import com.example.domain.models.UserDataRegistration
import com.example.domain.repositories.AuthenticationRepository

class SaveUserToDBUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(user: UserDataRegistration){
        authenticationRepository.saveUserToDB(user = user)
    }
}