package com.lorenzofonseca.gitpub

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel() : ViewModel() {

    private val _homeUiState = MutableStateFlow(HomeUiState.LoggedOut(""))
    val homeUiState : StateFlow<HomeUiState> = _homeUiState
}

sealed class HomeUiState{
    data class LoggedOut(val message : String) : HomeUiState()

    data class LoggedIn(val userId : String) : HomeUiState()
}