package com.lorenzofonseca.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.domain.model.AuthRequestModel
import com.lorenzofonseca.domain.repository.AuthenticationRepository
import com.lorenzofonseca.domain.repository.DataStoreRepository
import com.lorenzofonseca.networking.AuthenticationUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    val authRepository: AuthenticationRepository,
    val datastoreRepository: DataStoreRepository
) : ViewModel() {
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.SignedOut)
    val loginUiState: StateFlow<LoginUiState> = _loginUiState

    private val _authRequest = MutableStateFlow(AuthRequestModel("", ""))
    val authRequest: StateFlow<AuthRequestModel> = _authRequest

    fun getAccessToken(code: String, state: String) = viewModelScope.launch(Dispatchers.IO) {
        updateAuthRequest(AuthRequestModel(code, state))
        try {
            val result = authRepository.getAccessToken(
                clientId = AuthenticationUrl.clientId,
                clientSecret = AuthenticationUrl.clientSecret,
                code = code,
                state = state
            )

            _loginUiState.value = LoginUiState.SignedIn(result)
            datastoreRepository.setAccessTokenInformation(result)

        } catch (e: Exception) {
            _loginUiState.value = LoginUiState.Error(error = e)
        }

    }

    fun updateUiState(uiState: LoginUiState) {
        _loginUiState.value = uiState
        Log.v("UiState updated to", uiState.toString())
    }

    fun updateAuthRequest(authRequest: AuthRequestModel) {
        _authRequest.value = authRequest
    }
}

sealed class LoginUiState {
    data class SignedIn(val authModel: AuthModel) : LoginUiState()
    object IsLoading : LoginUiState()
    data class InProgress(val code: String, val state: String) : LoginUiState()
    data class Error(val error: Exception) : LoginUiState()
    object SignedOut : LoginUiState()
}