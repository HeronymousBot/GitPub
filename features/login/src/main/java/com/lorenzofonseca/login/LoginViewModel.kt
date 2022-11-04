package com.lorenzofonseca.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzofonseca.networking.AuthenticationUrl
import com.lorenzofonseca.networking.repositoryImpl.AuthenticationRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(val repository: AuthenticationRepositoryImpl) : ViewModel() {
    private val _loginUiState = MutableStateFlow(LoginUiState.SignedOut)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState
    val code = MutableLiveData("")
    val state = MutableLiveData("")

    fun startAuthentication() = viewModelScope.launch(Dispatchers.IO) {

        repository.getAccessToken(
            clientId = AuthenticationUrl.clientId,
            clientSecret = AuthenticationUrl.clientSecret,
            code = code.value!!,
            state = state.value!!
        )
    }
}

sealed class LoginUiState {
    object SignedIn : LoginUiState()
    object InProgress : LoginUiState()
    object Error : LoginUiState()
    object SignedOut : LoginUiState()
}