package com.example.footballplayassistant.di

import com.example.data.client.httpClientAndroid
import com.example.data.local.LocalDataSource
import com.example.data.local.LocalFieldSource
import com.example.data.repository.AuthenticationRepositoryImpl
import com.example.domain.repositories.AuthenticationRepository
import com.example.footballplayassistant.viewmodels.MainViewModel
import io.ktor.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<AuthenticationRepository>{
        AuthenticationRepositoryImpl()
    }
    single {
        provideHttpClient()
    }
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}



