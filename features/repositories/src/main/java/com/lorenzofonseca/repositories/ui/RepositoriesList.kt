package com.lorenzofonseca.repositories.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.resources.components.FullScreenProgressIndicator
import com.lorenzofonseca.resources.ui.Color
import com.lorenzofonseca.resources.ui.Type
import org.koin.androidx.compose.koinViewModel

@Composable
fun RepositoriesList() {
    val viewModel: RepositoriesViewModel = koinViewModel()
    val uiState = viewModel.repositoriesUiState.collectAsState().value
    val repositories = viewModel.repositoriesList.collectAsState().value
    val isLoading = when (uiState) {
        is RepositoriesUiState.IsLoading -> true
        is RepositoriesUiState.InProgress -> true
        else -> false
    }
    when (uiState) {
        is RepositoriesUiState.Error -> {} //TODO: Create generic error message
        is RepositoriesUiState.InProgress -> viewModel.getRepositoriesList(uiState.userModel.login)
        is RepositoriesUiState.IsLoading -> viewModel.getUser()
        else -> {}
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = "Your repos",
            style = Type.Typography(Color.contrastColor(isSystemInDarkTheme())).h5
        )

        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp)) {
            items(
                items = repositories,
                itemContent = { RepositoryItemCard(repository = it) }
            )
        }
    }
    FullScreenProgressIndicator(
        modifier = Modifier
            .background(Color.primaryDarkerColor.copy(alpha = if (isLoading) 0.7f else 0f))
            .fillMaxSize()
            .alpha(
                if (isLoading) 1f else 0f
            )
    )
}