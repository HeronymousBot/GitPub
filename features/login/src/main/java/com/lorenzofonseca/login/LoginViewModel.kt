package com.lorenzofonseca.login

import androidx.lifecycle.ViewModel
import com.lorenzofonseca.networking.repositoryImpl.AuthenticationRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel(repository: AuthenticationRepositoryImpl) : ViewModel() {
    private val _loginUiState = MutableStateFlow(LoginUiState.SignedOut)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState
}

sealed class LoginUiState {
    object SignedIn : LoginUiState()
    object InProgress : LoginUiState()
    object Error : LoginUiState()
    object SignedOut : LoginUiState()
}