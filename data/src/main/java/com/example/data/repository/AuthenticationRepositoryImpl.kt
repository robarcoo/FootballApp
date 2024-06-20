package com.example.data.repository

import android.util.Log
import com.example.data.services.ApiServiceAuthentication
import com.example.domain.models.CommonAnswer
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
import com.example.domain.models.Result

class AuthenticationRepositoryImpl(private val apiService: ApiServiceAuthentication) :
    AuthenticationRepository {
    override fun checkUserForAuthorization(user: UserAuthorization): Flow<Result> {
       return flow {
           val response = apiService.authorization(userData = user)
           emit (
               try{
                   when (response.status) {
                       HttpStatusCode.OK -> {
                           try {
                               Result.Success(
                                   value = response.body<CommonAnswer>().toCommonAnswerUi()
                               )
                           } catch (e: SerializationException) {
                               Result.ErrorNetwork(value = response.body<CommonAnswer>().toCommonAnswerUi())/*class error*/
                           }

                       }
                       else -> Result.Error(
                           value = Exception("error")//response.body<Throwable>()/*class error*/
                       )
                   }
               }catch (e: Exception){
                   Result.Error(
                       value = e
                   )
               }
           )
       }
    }

    override fun checkUserForRegistrationStepOne(user: UserRegistrationStepOne): Flow<Result> {
        return flow {
            apiService.registrationStepOne(userData = user)
        }

    }

    override fun saveUserToDB(user: UserRegistration): Flow<Result> {
        return flow {apiService.registration(userData = user)}
    }

    override fun sendCodeToPhone(phone: String): Flow<Result> {
        return flow {apiService.sendRegistrationCode(phone = phone)}
    }

    override fun sendCodeToEmail(email: String): Flow<Result> {
        return flow {apiService.sendRecoveryCode(email = email)}
    }

    override fun checkRegistrationCode(code: String): Flow<Result> {
        return flow {apiService.checkRegistrationCode(code = code)}
    }

    override fun checkRecoveryCode(code: String): Flow<Result> {
        return flow {apiService.checkRecoveryCode(code = code)}
    }

    override fun recoveryPassword(user: UserRecoveryPassword): Flow<Result> {
        return flow {apiService.updatePassword(userData = user)}
    }


}