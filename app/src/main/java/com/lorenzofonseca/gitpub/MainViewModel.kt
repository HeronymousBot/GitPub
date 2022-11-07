package com.lorenzofonseca.gitpub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzofonseca.domain.repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(val repository: DataStoreRepository) : ViewModel() {

    private val _mainUiState = MutableStateFlow<MainUiState>(MainUiState.Idle)
    val mainUiState: StateFlow<MainUiState> = _mainUiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAccessTokenInformation().collect {
                val isLoggedIn = it.access_token.isNotBlank()

                updateUiState(if (isLoggedIn) MainUiState.LoggedIn else MainUiState.LoggedOut)
            }
        }
    }

    fun updateUiState(uiState: MainUiState) {
        _mainUiState.value = uiState
    }
}

sealed class MainUiState {
    object Idle : MainUiState()
    object LoggedOut : MainUiState()
    object LoggedIn : MainUiState()
}