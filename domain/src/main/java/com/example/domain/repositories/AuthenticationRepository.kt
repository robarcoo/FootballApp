package com.example.domain.repositories

import com.example.domain.models.auth.UserAuthorization
import com.example.domain.models.auth.UserRecoveryPassword
import com.example.domain.models.auth.UserRegistration
import com.example.domain.models.auth.UserRegistrationStepOne
import kotlinx.coroutines.flow.Flow
import com.example.domain.models.Result

interface AuthenticationRepository {
     fun checkUserForAuthorization(user: UserAuthorization): Flow<Result>

    fun checkUserForRegistrationStepOne(user: UserRegistrationStepOne): Flow<Result>

    fun saveUserToDB(user: UserRegistration): Flow<Result>

    fun sendCodeToPhone(phone: String): Flow<Result>

    fun sendCodeToEmail(email: String): Flow<Result>

    fun checkRegistrationCode(code: String): Flow<Result>

    fun checkRecoveryCode(code: String): Flow<Result>

    fun recoveryPassword(user: UserRecoveryPassword): Flow<Result>

}