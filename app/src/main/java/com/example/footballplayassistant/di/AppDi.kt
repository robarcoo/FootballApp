package com.example.footballplayassistant.di

import com.example.footballplayassistant.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel>{
        MainViewModel(
            checkCodeUseCase = get(),
            checkUniqueNicknameUseCase = get(),
            checkUserForAuthorizationUseCase = get(),
            saveUserToDBUseCase = get(),
            sendCodeToEmailUseCase = get(),
            sendCodeToPhoneUseCase = get(),
            sendEmailAfterRegistrationUseCase = get())
    }
}