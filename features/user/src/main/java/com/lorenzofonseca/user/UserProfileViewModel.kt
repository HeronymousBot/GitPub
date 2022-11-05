package com.lorenzofonseca.user

import androidx.lifecycle.ViewModel
import com.lorenzofonseca.domain.model.UserModel
import com.lorenzofonseca.domain.repository.GithubApiRepository

class UserProfileViewModel(repository : GithubApiRepository) : ViewModel() {
}

sealed class UserProfileUiState() {
    data class Success(val userModel: UserModel) : UserProfileUiState()
    data class Error(val exception: Exception) : UserProfileUiState()
    data class InProgress(val isLoading: Boolean) : UserProfileUiState()
}