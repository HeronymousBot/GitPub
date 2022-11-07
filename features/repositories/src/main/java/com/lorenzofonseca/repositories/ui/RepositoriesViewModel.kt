package com.lorenzofonseca.repositories.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzofonseca.domain.model.RepositoryModel
import com.lorenzofonseca.domain.model.UserModel
import com.lorenzofonseca.domain.repository.DataStoreRepository
import com.lorenzofonseca.domain.repository.GithubApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RepositoriesViewModel(
    val githubRepository: GithubApiRepository,
    val dataStoreRepository: DataStoreRepository
) : ViewModel() {
    private val _repositoriesUiState =
        MutableStateFlow<RepositoriesUiState>(RepositoriesUiState.Idle)
    val repositoriesUiState: StateFlow<RepositoriesUiState> = _repositoriesUiState

    private val _accessToken =
        MutableStateFlow("")
    private val accessToken: StateFlow<String> = _accessToken

    private val _repositoriesList =
        MutableStateFlow(listOf<RepositoryModel>())
    val repositoriesList: StateFlow<List<RepositoryModel>> = _repositoriesList

    private fun updateUiState(uiState: RepositoriesUiState) {
        _repositoriesUiState.value = uiState
    }

    private fun updateRepositoriesList(repositories: List<RepositoryModel>) {
        _repositoriesList.value = repositories
    }

    init {
        viewModelScope.launch(Dispatchers.IO) {

            dataStoreRepository.getAccessTokenInformation().collect {
                _accessToken.value = it.access_token
                updateUiState(RepositoriesUiState.IsLoading(it.access_token))

            }
        }
    }

    fun getUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val user = githubRepository.getUser("Bearer ${_accessToken.value}")
                updateUiState(RepositoriesUiState.InProgress(userModel = user))
            } catch (exception: Exception) {
                updateUiState(RepositoriesUiState.Error(exception))
            }

        }
    }

    fun getRepositoriesList(userLogin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val reposResult = githubRepository.getRepositoriesList(
                    username = userLogin,
                    accessToken = "Bearer ${_accessToken.value}"
                )

                updateUiState(RepositoriesUiState.Success(reposResult))
                updateRepositoriesList(repositories = reposResult)
            } catch (exception: Exception) {
                _repositoriesUiState.value = RepositoriesUiState.Error(exception)
            }
        }
    }
}

sealed class RepositoriesUiState {
    data class Success(val repos: List<RepositoryModel>) :
        RepositoriesUiState()

    object Idle : RepositoriesUiState()
    data class InProgress(val userModel: UserModel) : RepositoriesUiState()
    data class IsLoading(val accessToken: String) : RepositoriesUiState()
    data class Error(val exception: Exception) : RepositoriesUiState()
}