package com.example.footballplayassistant.di

import com.example.domain.usecases.CheckCodeUseCase
import com.example.domain.usecases.CheckUniqueNicknameUseCase
import com.example.domain.usecases.CheckUserForAuthorizationUseCase
import com.example.domain.usecases.SaveUserToDBUseCase
import com.example.domain.usecases.SendCodeToEmailUseCase
import com.example.domain.usecases.SendCodeToPhoneUseCase
import com.example.domain.usecases.SendEmailAfterRegistrationUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<CheckCodeUseCase>{
        CheckCodeUseCase(authenticationRepository = get())
    }

    factory<CheckUniqueNicknameUseCase>{
        CheckUniqueNicknameUseCase(authenticationRepository = get())
    }

    factory<CheckUserForAuthorizationUseCase>{
        CheckUserForAuthorizationUseCase(authenticationRepository = get())
    }

    factory<SaveUserToDBUseCase>{
        SaveUserToDBUseCase(authenticationRepository = get())
    }

    factory<SendCodeToEmailUseCase>{
        SendCodeToEmailUseCase(authenticationRepository = get())
    }

    factory<SendCodeToPhoneUseCase>{
        SendCodeToPhoneUseCase(authenticationRepository = get())
    }

    factory<SendEmailAfterRegistrationUseCase>{
        SendEmailAfterRegistrationUseCase(authenticationRepository = get())
    }
}