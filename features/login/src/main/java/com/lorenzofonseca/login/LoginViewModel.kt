package com.lorenzofonseca.login

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
}

sealed class LoginUiState{
    object SignedIn : LoginUiState()
    object InProgress : LoginUiState()
    object Error : LoginUiState()
    object SignedOut : LoginUiState()
}