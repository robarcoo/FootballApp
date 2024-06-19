package com.example.footballplayassistant.di

import com.example.domain.usecases.auth.impl.CheckRecoveryCodeUseCaseImpl
import com.example.domain.usecases.auth.impl.CheckRegistrationCodeUseCaseImpl
import com.example.domain.usecases.auth.impl.CheckUserForAuthorizationUseCaseImpl
import com.example.domain.usecases.auth.impl.CheckUserRegistrationStepOneUseCaseImpl
import com.example.domain.usecases.auth.impl.SaveUserToDBUseCaseImpl
import com.example.domain.usecases.auth.impl.SendCodeToEmailUseCaseImpl
import com.example.domain.usecases.auth.impl.SendCodeToPhoneUseCaseImpl
import com.example.domain.usecases.auth.interfaces.CheckRecoveryCodeUseCase
import com.example.domain.usecases.auth.interfaces.CheckRegistrationCodeUseCase
import com.example.domain.usecases.auth.interfaces.CheckUserForAuthorizationUseCase
import com.example.domain.usecases.auth.interfaces.CheckUserRegistrationStepOneUseCase
import com.example.domain.usecases.auth.interfaces.SaveUserToDBUseCase
import com.example.domain.usecases.auth.interfaces.SendCodeToEmailUseCase
import com.example.domain.usecases.auth.interfaces.SendCodeToPhoneUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<CheckRegistrationCodeUseCase>{
        CheckRegistrationCodeUseCaseImpl(authenticationRepository = get())
    }

    factory<CheckRecoveryCodeUseCase>{
        CheckRecoveryCodeUseCaseImpl(authenticationRepository = get())
    }

    factory<CheckUserForAuthorizationUseCase>{
        CheckUserForAuthorizationUseCaseImpl(authenticationRepository = get())
    }

    factory<CheckUserRegistrationStepOneUseCase>{
        CheckUserRegistrationStepOneUseCaseImpl(authenticationRepository = get())
    }

    factory<SaveUserToDBUseCase>{
        SaveUserToDBUseCaseImpl(authenticationRepository = get())
    }

    factory<SendCodeToEmailUseCase>{
        SendCodeToEmailUseCaseImpl(authenticationRepository = get())
    }

    factory<SendCodeToPhoneUseCase>{
        SendCodeToPhoneUseCaseImpl(authenticationRepository = get())
    }


}