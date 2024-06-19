package com.example.footballplayassistant.di

import com.example.footballplayassistant.viewmodels.AuthenticationViewModel
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
            sendCodeToPhoneUseCase = get())
    }
//    viewModelOf(::AuthenticationViewModel)
}