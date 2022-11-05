package com.lorenzofonseca.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzofonseca.domain.repository.AuthenticationRepository
import com.lorenzofonseca.networking.AuthenticationUrl
import com.lorenzofonseca.networking.repositoryImpl.AuthenticationRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(val repository: AuthenticationRepository) : ViewModel() {
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.SignedOut)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState
    val code = MutableLiveData("")
    val state = MutableLiveData("")

    fun getAccessToken(code: String, state: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val result = repository.getAccessToken(
                clientId = AuthenticationUrl.clientId,
                clientSecret = AuthenticationUrl.clientSecret,
                code = code,
                state = state
            )

            _loginUiState.value = LoginUiState.SignedIn(result.access_token)
        } catch (e: Exception) {
            _loginUiState.value = LoginUiState.Error(error = e)
        }

    }

    fun updateUiState(uiState : LoginUiState){
        _loginUiState.value = uiState
    }
}

sealed class LoginUiState {
    data class SignedIn(val accessToken: String) : LoginUiState()
    object IsLoading : LoginUiState()
    data class InProgress(val code: String, val state: String) : LoginUiState()
    data class Error(val error: Exception) : LoginUiState()
    object SignedOut : LoginUiState()
}