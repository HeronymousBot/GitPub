package com.lorenzofonseca.gitpub.di

import com.lorenzofonseca.domain.repository.AuthenticationRepository
import com.lorenzofonseca.domain.repository.GithubApiRepository
import com.lorenzofonseca.networking.Networking
import com.lorenzofonseca.networking.repositoryImpl.AuthenticationRepositoryImpl
import com.lorenzofonseca.networking.repositoryImpl.GithubApiRepositoryImpl
import com.lorenzofonseca.networking.service.AuthenticationService
import com.lorenzofonseca.networking.service.GithubApiService
import org.koin.dsl.module

val serviceModules = module {
    single<AuthenticationRepository> { AuthenticationRepositoryImpl(get()) }
    single<GithubApiRepository> { GithubApiRepositoryImpl(get()) }

    single<AuthenticationService> { Networking.authenticationService }
    single<GithubApiService> { Networking.githubApiService }
}