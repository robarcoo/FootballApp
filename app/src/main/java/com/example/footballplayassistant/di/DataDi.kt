package com.example.footballplayassistant.di

import com.example.data.client.httpClientAndroid
import com.example.data.local.LocalFieldSource
import com.example.data.repository.AuthenticationRepositoryImpl
import com.example.data.repository.FieldRepository
import com.example.data.services.ApiServiceAuthentication
import com.example.data.services.ApiServiceAuthenticationImpl
import com.example.data.services.FieldService
import com.example.domain.models.datasource.LocalDataSource
import com.example.domain.models.datasource.RemoteDataSource
import com.example.domain.models.field.FieldClass
import com.example.domain.repositories.AuthenticationRepository
import com.example.domain.repositories.CacheEntry
import com.example.domain.repositories.CachePolicyRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module

val dataModule = module {
    single<AuthenticationRepository>{
        AuthenticationRepositoryImpl(apiService = get())
    }
    single<ApiServiceAuthentication>{
        ApiServiceAuthenticationImpl(client = get())
    }

    single<CachePolicyRepository<FieldClass>> {
        FieldRepository(localDataSource = get(), remoteDataSource = get())
    }
    single {
        provideHttpClient()
    }

    single<LocalDataSource<Int, CacheEntry<FieldClass>>> {
        LocalFieldSource()
    }

    single<RemoteDataSource<FieldClass>> {
        FieldService(client = get())
    }
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}



