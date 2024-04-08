package com.example.domain.repositories

import com.example.domain.models.UserDataAuthorization
import com.example.domain.models.UserDataRegistration

interface AuthenticationRepository {

    fun checkUniqueNickname(nickname: String): Boolean

    fun checkCode(code: Int): Boolean

    fun checkUserForAuthorization(user: UserDataAuthorization): Boolean

    fun saveUserToDB(user: UserDataRegistration)

    fun sendCodeToEmail(email: String)

    fun sendCodeToPhone(phone: String)

    fun sendEmailAfterRegistration(email: String)
}