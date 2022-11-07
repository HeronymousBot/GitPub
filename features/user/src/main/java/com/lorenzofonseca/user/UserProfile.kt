package com.lorenzofonseca.user

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.resources.components.FullScreenProgressIndicator
import com.lorenzofonseca.resources.components.ImageHolder
import com.lorenzofonseca.resources.ui.Color
import com.lorenzofonseca.resources.ui.Type
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserProfile() {
    val viewModel: UserProfileViewModel = koinViewModel()
    val uiState = viewModel.userProfileUiState.collectAsState().value
    val isLoading = when (uiState) {
        is UserProfileUiState.IsLoading, UserProfileUiState.InProgress -> true
        else -> false
    }

    when (uiState) {
        is UserProfileUiState.Success -> viewModel.updateUserProfile(uiState.userModel)
        is UserProfileUiState.InProgress -> viewModel.getUser()
        else -> {}
    }

    Column(modifier = Modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        ImageHolder(urlPath = viewModel.userProfile.value.avatar_url, imageSize = 160.dp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = viewModel.userProfile.value.name, style = Type.Typography(
                Color.contrastColor(
                    isSystemInDarkTheme()
                )
            ).h5
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = viewModel.userProfile.value.location, style = Type.Typography(
                Color.contrastColor(
                    isSystemInDarkTheme()
                )
            ).subtitle1
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = viewModel.userProfile.value.bio ?: stringResource(
                id = R.string.no_bio
            ), style = Type.Typography(
                Color.contrastColor(
                    isSystemInDarkTheme()
                )
            ).caption
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Followers: ${viewModel.userProfile.value.followers}",
                style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).h6
            )

            Text(
                text = "Followers: ${viewModel.userProfile.value.followers}",
                style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).h6
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "On GitHub since: ${viewModel.userProfile.value.created_at}",
            style = Type.Typography(
                Color.contrastColor(
                    isSystemInDarkTheme()
                )
            ).subtitle2
        )

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