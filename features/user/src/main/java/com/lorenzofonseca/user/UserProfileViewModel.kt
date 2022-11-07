package com.lorenzofonseca.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzofonseca.domain.model.UserModel
import com.lorenzofonseca.domain.repository.DataStoreRepository
import com.lorenzofonseca.domain.repository.GithubApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel(
    val repository: GithubApiRepository,
    val dataStoreRepository: DataStoreRepository
) : ViewModel() {
    private val _userProfileUiState =
        MutableStateFlow<UserProfileUiState>(UserProfileUiState.IsLoading)
    val userProfileUiState: StateFlow<UserProfileUiState> = _userProfileUiState

    private val _accessToken =
        MutableStateFlow("")
    private val accessToken: StateFlow<String> = _accessToken

    private val _userProfile: MutableStateFlow<UserModel> =
        MutableStateFlow(
            UserModel(
                "",
                0,
                "",
                "",
                "",
                "",
                "",
                1,
                1,
                "",
                1
            )
        )
    val userProfile: StateFlow<UserModel> = _userProfile

    private fun updateUiState(uiState: UserProfileUiState) {
        _userProfileUiState.value = uiState
    }

    fun updateUserProfile(user: UserModel) {
        _userProfile.value = user
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            dataStoreRepository.getAccessTokenInformation().collect {
                _accessToken.value = it.access_token
                updateUiState(UserProfileUiState.InProgress)
            }
        }
    }

    fun getUser() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val userResult = repository.getUser("Bearer ${_accessToken.value}")
            updateUserProfile(userResult)
            updateUiState(UserProfileUiState.Success(userResult))
        } catch (exception: Exception) {
            updateUiState(UserProfileUiState.Error(exception))
        }

    }
}

sealed class UserProfileUiState {
    data class Success(val userModel: UserModel) : UserProfileUiState()
    data class Error(val exception: Exception) : UserProfileUiState()
    object InProgress : UserProfileUiState()
    object IsLoading : UserProfileUiState()
}