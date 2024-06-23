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
import io.ktor.http.ContentType
import io.ktor.http.contentType


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
    private val START = "https://football.requestbitrix.ru/api/v1/"
    private val AUTHORIZATION = "auth/login/"
    private val REGISTRATION_STEP_ONE = "auth/registerUserStep1/"
    private val REGISTRATION = "auth/register/"
    private val SEND_REGISTRATION_CODE = "auth/sendRegistrationCode/"
    private val SEND_RECOVERY_CODE = "auth/sendRecoveryCode/"
    private val CHECK_REGISTRATION_CODE = "auth/checkRegistrationCode/"
    private val CHECK_RECOVERY_CODE = "auth/checkRecoveryCode/"
    private val UPDATE_PASSWORD = "auth/updatePassword/"

    override suspend fun authorization(userData: UserAuthorization): HttpResponse {
        return client.post("$START$AUTHORIZATION") {
            contentType(ContentType.Application.Json)
            setBody(userData)
        }.body()
    }

    override suspend fun registrationStepOne(userData: UserRegistrationStepOne): HttpResponse {
        return client.post("$START$REGISTRATION_STEP_ONE") {
            contentType(ContentType.Application.Json)
            setBody(userData)
        }.body()
    }

    override suspend fun registration(userData: UserRegistration): HttpResponse {
        return client.post("$START$REGISTRATION") {
            contentType(ContentType.Application.Json)
            setBody(userData)
        }.body()
    }

    override suspend fun sendRegistrationCode(phone: String): HttpResponse {
        return client.post("$START$SEND_REGISTRATION_CODE") {
            contentType(ContentType.Application.Json)
            setBody(phone)
        }.body()
    }

    override suspend fun sendRecoveryCode(email: String): HttpResponse {
        return client.post("$START$SEND_RECOVERY_CODE") {
            contentType(ContentType.Application.Json)
            setBody(email)
        }.body()
    }

    override suspend fun checkRegistrationCode(code: String): HttpResponse {
        return client.post("$START$CHECK_REGISTRATION_CODE") {
            contentType(ContentType.Application.Json)
            setBody(code)
        }.body()
    }

    override suspend fun checkRecoveryCode(code: String): HttpResponse {
        return client.post("$START$CHECK_RECOVERY_CODE") {
            contentType(ContentType.Application.Json)
            setBody(code)
        }.body()
    }

    override suspend fun updatePassword(userData: UserRecoveryPassword): HttpResponse {
        return client.post("$START$UPDATE_PASSWORD") {
            contentType(ContentType.Application.Json)
            setBody(userData)
        }.body()
    }
}