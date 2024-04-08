package com.example.domain.usecases

import com.example.domain.repositories.AuthenticationRepository

class CheckUniqueNicknameUseCase(private val authenticationRepository: AuthenticationRepository) {

    fun execute(nickname: String): Boolean{
        return authenticationRepository.checkUniqueNickname(nickname = nickname)
    }
}