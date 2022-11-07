package com.lorenzofonseca.gitpub.di

import com.lorenzofonseca.gitpub.MainViewModel
import com.lorenzofonseca.login.LoginViewModel
import com.lorenzofonseca.repositories.ui.RepositoriesViewModel
import com.lorenzofonseca.user.UserProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules =
    module {
        viewModel { MainViewModel(get()) }
        viewModel { LoginViewModel(get(), get()) }
        viewModel { RepositoriesViewModel(get(), get()) }
        viewModel { UserProfileViewModel(get(), get()) }

    }