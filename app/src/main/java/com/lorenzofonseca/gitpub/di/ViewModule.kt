package com.lorenzofonseca.gitpub.di

import com.lorenzofonseca.home.HomeViewModel
import com.lorenzofonseca.login.LoginViewModel
import com.lorenzofonseca.repositories.ui.RepositoriesViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModules =
    module {
        viewModel{HomeViewModel()}
        viewModel{LoginViewModel()}
        viewModel{RepositoriesViewModel()}

    }