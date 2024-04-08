package com.example.footballplayassistant.di

import com.example.data.repository.AuthenticationRepositoryImpl
import com.example.domain.repositories.AuthenticationRepository
import com.example.footballplayassistant.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<AuthenticationRepository>{
        AuthenticationRepositoryImpl()
    }
}