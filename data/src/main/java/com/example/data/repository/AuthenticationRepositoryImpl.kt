package com.example.data.repository

import com.example.domain.models.UserDataAuthorization
import com.example.domain.models.UserDataRegistration
import com.example.domain.repositories.AuthenticationRepository

class AuthenticationRepositoryImpl: AuthenticationRepository {
    override fun checkUniqueNickname(nickname: String): Boolean {
        return !nickname.isEmpty()
    }

    override fun checkCode(code: Int): Boolean {
        return code == 11111
    }

    override fun checkUserForAuthorization(user: UserDataAuthorization): Boolean {
        return user.password == "11111111"
    }

    override fun saveUserToDB(user: UserDataRegistration) {
        TODO("Not yet implemented")
    }

    override fun sendCodeToEmail(email: String) {
        TODO("Not yet implemented")
    }

    override fun sendCodeToPhone(phone: String) {
        TODO("Not yet implemented")
    }

    override fun sendEmailAfterRegistration(email: String) {
        TODO("Not yet implemented")
    }
}