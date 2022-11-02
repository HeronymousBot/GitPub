package com.lorenzofonseca.repositories.ui

import androidx.lifecycle.ViewModel

class RepositoriesViewModel : ViewModel() {
}

sealed class RepositoriesUiState{
    object SignedIn : RepositoriesUiState()
    object InProgress : RepositoriesUiState()
    object Error : RepositoriesUiState()
    object SignedOut : RepositoriesUiState()
}