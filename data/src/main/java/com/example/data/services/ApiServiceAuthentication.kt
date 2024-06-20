package com.example.data.services

import com.example.domain.models.auth.UserAuthorization
import com.example.domain.models.auth.UserRecoveryPassword
import com.example.domain.models.auth.UserRegistration
import com.example.domain.models.auth.UserRegistrationStepOne
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse


interface ApiServiceAuthentication {
    suspend fun authorization(userData: UserAuthorization): HttpResponse
    suspend fun registrationStepOne(userData: UserRegistrationStepOne): HttpResponse
    suspend fun registration(userData: UserRegistration): HttpResponse
    suspend fun sendRegistrationCode(phone: String): HttpResponse
    suspend fun sendRecoveryCode(email: String): HttpResponse
    suspend fun checkRegistrationCode(code: String): HttpResponse
    suspend fun checkRecoveryCode(code: String): HttpResponse
    suspend fun updatePassword(userData: UserRecoveryPassword): HttpResponse
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

//    override suspend fun authorization(userData: UserAuthorization): HttpResponse {
//        return client.get("https://football.requestbitrix.ru/api/v1/cities/getCities").body()
//    }

    override suspend fun registrationStepOne(userData: UserRegistrationStepOne): HttpResponse {
        return client.post(REGISTRATION_STEP_ONE) { setBody(userData) }.body()
    }

    override suspend fun registration(userData: UserRegistration): HttpResponse {
        return client.post(REGISTRATION) { setBody(userData) }.body()
    }

    override suspend fun sendRegistrationCode(phone: String): HttpResponse {
        return client.post(SEND_REGISTRATION_CODE) { setBody(phone) }.body()
    }

    override suspend fun sendRecoveryCode(email: String): HttpResponse {
        return client.post(SEND_RECOVERY_CODE) { setBody(email) }.body()
    }

    override suspend fun checkRegistrationCode(code: String): HttpResponse {
        return client.post(CHECK_REGISTRATION_CODE) { setBody(code) }.body()
    }

    override suspend fun checkRecoveryCode(code: String): HttpResponse {
        return client.post(CHECK_RECOVERY_CODE) { setBody(code) }.body()
    }

    override suspend fun updatePassword(userData: UserRecoveryPassword): HttpResponse {
        return client.post(UPDATE_PASSWORD) { setBody(userData) }.body()
    }
}