package com.lorenzofonseca.gitpub

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.lorenzofonseca.gitpub.ui.Theme.GitPubTheme
import com.lorenzofonseca.home.HomeUiState
import com.lorenzofonseca.home.HomeViewModel
import com.lorenzofonseca.home.ShowLoginActivity
import com.lorenzofonseca.home.ShowUserDashBoard


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            GitPubTheme {
                Scaffold() {
                    Surface(color = MaterialTheme.colors.background) {

                        HomeScreen(
                            context = applicationContext ?: baseContext,
                            homeViewModel = HomeViewModel()
                        )
                    }
                }
            }

        }
    }




}

@Composable
fun HomeScreen(context: Context, homeViewModel: HomeViewModel) {
    when (val state = homeViewModel.homeUiState.collectAsState().value) {
        is HomeUiState.LoggedIn -> ShowUserDashBoard(userId = state.userId)
        is HomeUiState.LoggedOut -> ShowLoginActivity(context = context)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitPubTheme {

    }
}

fun Context.getActivity(): AppCompatActivity? = when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}