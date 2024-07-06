package com.example.footballplayassistant.di

import com.example.footballplayassistant.viewmodels.AuthenticationViewModel
import com.example.footballplayassistant.viewmodels.FieldViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModel<AuthenticationViewModel>{
        AuthenticationViewModel(
            checkRegistrationCodeUseCase = get(),
            checkRecoveryCodeUseCase = get(),
            checkUserForAuthorizationUseCase = get(),
            checkUserRegistrationStepOneUseCase = get(),
            saveUserToDBUseCase = get(),
            sendCodeToEmailUseCase = get(),
            sendCodeToPhoneUseCase = get(),
            recoveryPasswordUseCase = get())
    }
    viewModel<FieldViewModel> {
        FieldViewModel(
            deleteFieldUseCase = get(),
            getAllFieldsUseCase = get(),
            getFieldUseCase = get(),
            postFieldUseCase = get(),
            putFieldUseCase = get()
        )
    }
//    viewModelOf(::AuthenticationViewModel)
}