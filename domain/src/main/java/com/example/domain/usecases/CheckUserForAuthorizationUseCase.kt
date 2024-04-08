package com.example.domain.usecases

import com.example.domain.models.UserDataAuthorization
import com.example.domain.repositories.AuthenticationRepository

class CheckUserForAuthorizationUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(user: UserDataAuthorization): Boolean{
        return authenticationRepository.checkUserForAuthorization(user = user)
    }
}