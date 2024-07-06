package com.example.data.repository

import com.example.data.services.ApiServiceAuthentication
import com.example.domain.models.CommonAnswer
import com.example.domain.models.Result
import com.example.domain.models.auth.UserAuthorization
import com.example.domain.models.auth.UserRecoveryPassword
import com.example.domain.models.auth.UserRegistration
import com.example.domain.models.auth.UserRegistrationStepOne
import com.example.domain.repositories.AuthenticationRepository
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.SerializationException

class AuthenticationRepositoryImpl(private val apiService: ApiServiceAuthentication) :
    AuthenticationRepository {
    override fun checkUserForAuthorization(user: UserAuthorization): Flow<Result> {
        return flow {
            val response = apiService.authorization(userData = user)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun checkUserForRegistrationStepOne(user: UserRegistrationStepOne): Flow<Result> {
        return flow {
            val response = apiService.registrationStepOne(userData = user)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun saveUserToDB(user: UserRegistration): Flow<Result> {
        return flow {
            val response = apiService.registration(userData = user)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun sendCodeToPhone(phone: String): Flow<Result> {
        return flow {
            val response = apiService.sendRegistrationCode(phone = phone)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) } }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun sendCodeToEmail(email: String): Flow<Result> {
        return flow {
            val response = apiService.sendRecoveryCode(email = email)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun checkRegistrationCode(code: String): Flow<Result> {
        return flow {
            val response = apiService.checkRegistrationCode(code = code)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun checkRecoveryCode(code: String): Flow<Result> {
        return flow {
            val response = apiService.checkRecoveryCode(code = code)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }

    override fun recoveryPassword(user: UserRecoveryPassword): Flow<Result> {
        return flow {
            val response = apiService.updatePassword(userData = user)
            try {
                when (response.status) {
                    HttpStatusCode.OK -> {
                        try {
                            emit(Result.Success(value = response.body<CommonAnswer>()))
                        } catch (e: SerializationException) {
                            emit(Result.ErrorNetwork(value = response.body<CommonAnswer>()
                                .toCommonAnswerUi()))
                        }
                    }
                    else -> { emit(Result.Error(value = Exception("error"))) }
                }
            } catch (e: Exception) {
                emit(Result.Error(value = e))
            }
        }
    }
}