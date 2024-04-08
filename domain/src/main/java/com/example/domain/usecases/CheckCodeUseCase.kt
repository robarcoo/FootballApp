package com.example.domain.usecases

import com.example.domain.repositories.AuthenticationRepository

class CheckCodeUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(code: Int): Boolean{
        return authenticationRepository.checkCode(code = code)
    }
}