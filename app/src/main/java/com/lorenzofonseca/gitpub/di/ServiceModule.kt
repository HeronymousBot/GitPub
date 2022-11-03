package com.lorenzofonseca.gitpub.di

import com.lorenzofonseca.domain.repository.AuthenticationRepository
import com.lorenzofonseca.domain.repository.RepositoriesRepository
import com.lorenzofonseca.networking.repositoryImpl.AuthenticationRepositoryImpl
import com.lorenzofonseca.networking.repositoryImpl.RepositoriesRepositoryImpl
import org.koin.dsl.module

val serviceModules = module {
    single<AuthenticationRepository> { AuthenticationRepositoryImpl(get()) }
    single<RepositoriesRepository> { RepositoriesRepositoryImpl(get()) }
}