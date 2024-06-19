package com.example.data.services

import com.example.domain.models.auth.UserAuthorization
import com.example.domain.models.auth.UserRecoveryPassword
import com.example.domain.models.auth.UserRegistration
import com.example.domain.models.auth.UserRegistrationStepOne
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse


interface ApiServiceAuthentication {
    suspend fun authorization(userData: UserAuthorization): HttpResponse
    suspend fun registrationStepOne(userData: UserRegistrationStepOne): HttpResponse
    suspend fun registration(userData: UserRegistration): HttpResponse
    suspend fun sendRegistrationCode(): HttpResponse
    suspend fun sendRecoveryCode(): HttpResponse
    suspend fun checkRegistrationCode(): HttpResponse
    suspend fun checkRecoveryCode(): HttpResponse
    suspend fun updatePassword(): HttpResponse
}

class ApiServiceAuthenticationImpl(private val client: HttpClient) : ApiServiceAuthentication {

    private val AUTHORIZATION = "auth/login/"
    private val REGISTRATION_STEP_ONE = "auth/registerUserStep1/"
    private val REGISTRATION = "auth/register/"
    private val SEND_REGISTRATION_CODE = "auth/sendRegistrationCode/"
    private val SEND_RECOVERY_CODE = "auth/sendRecoveryCode/"
    private val CHECK_REGISTRATION_CODE = "auth/checkRegistrationCode/"
    private val CHECK_RECOVERY_CODE = "auth/checkRecoveryCode/"
    private val UPDATE_PASSWORD = "auth/updatePassword/"


    override suspend fun authorization(userData: UserAuthorization): HttpResponse {
        return client.post(AUTHORIZATION) { setBody(userData) }.body()
    }

    override suspend fun registrationStepOne(userData: UserRegistrationStepOne): HttpResponse {
        return client.post(REGISTRATION_STEP_ONE){ setBody(userData) }.body()
    }

    override suspend fun registration(userData: UserRegistration): HttpResponse {
        return client.post(REGISTRATION){ setBody(userData) }.body()
    }
    override suspend fun sendRegistrationCode() = client.post<String>(SEND_REGISTRATION_CODE)
    override suspend fun sendRecoveryCode() = client.post<String>(SEND_RECOVERY_CODE)
    override suspend fun checkRegistrationCode() = client.post<String>(CHECK_REGISTRATION_CODE)
    override suspend fun checkRecoveryCode() = client.post<String>(CHECK_RECOVERY_CODE)
    override suspend fun updatePassword() = client.post<UserRecoveryPassword>(UPDATE_PASSWORD)
}