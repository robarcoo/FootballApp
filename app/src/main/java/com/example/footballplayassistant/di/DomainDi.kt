package com.example.footballplayassistant.di

import com.example.domain.usecases.auth.impl.CheckRecoveryCodeUseCaseImpl
import com.example.domain.usecases.auth.impl.CheckRegistrationCodeUseCaseImpl
import com.example.domain.usecases.auth.impl.CheckUserForAuthorizationUseCaseImpl
import com.example.domain.usecases.auth.impl.CheckUserRegistrationStepOneUseCaseImpl
import com.example.domain.usecases.auth.impl.RecoveryPasswordUseCaseImpl
import com.example.domain.usecases.auth.impl.SaveUserToDBUseCaseImpl
import com.example.domain.usecases.auth.impl.SendCodeToEmailUseCaseImpl
import com.example.domain.usecases.auth.impl.SendCodeToPhoneUseCaseImpl
import com.example.domain.usecases.auth.interfaces.CheckRecoveryCodeUseCase
import com.example.domain.usecases.auth.interfaces.CheckRegistrationCodeUseCase
import com.example.domain.usecases.auth.interfaces.CheckUserForAuthorizationUseCase
import com.example.domain.usecases.auth.interfaces.CheckUserRegistrationStepOneUseCase
import com.example.domain.usecases.auth.interfaces.RecoveryPasswordUseCase
import com.example.domain.usecases.auth.interfaces.SaveUserToDBUseCase
import com.example.domain.usecases.auth.interfaces.SendCodeToEmailUseCase
import com.example.domain.usecases.auth.interfaces.SendCodeToPhoneUseCase
import com.example.domain.usecases.field.impl.DeleteFieldUseCaseImpl
import com.example.domain.usecases.field.impl.GetAllFieldsUseCaseImpl
import com.example.domain.usecases.field.impl.GetFieldUseCaseImpl
import com.example.domain.usecases.field.impl.PostFieldUseCaseImpl
import com.example.domain.usecases.field.impl.PutFieldUseCaseImpl
import com.example.domain.usecases.field.interfaces.DeleteFieldUseCase
import com.example.domain.usecases.field.interfaces.GetAllFieldsUseCase
import com.example.domain.usecases.field.interfaces.GetFieldUseCase
import com.example.domain.usecases.field.interfaces.PostFieldUseCase
import com.example.domain.usecases.field.interfaces.PutFieldUseCase
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

    factory<RecoveryPasswordUseCase> {
        RecoveryPasswordUseCaseImpl(authenticationRepository = get())
    }

    factory<DeleteFieldUseCase> {
        DeleteFieldUseCaseImpl(repository = get())
    }

    factory<GetFieldUseCase> {
        GetFieldUseCaseImpl(repository = get())
    }

    factory<GetAllFieldsUseCase> {
        GetAllFieldsUseCaseImpl(repository = get())
    }

    factory<PostFieldUseCase> {
        PostFieldUseCaseImpl(repository = get())
    }

    factory<PutFieldUseCase> {
        PutFieldUseCaseImpl(repository = get())
    }

}