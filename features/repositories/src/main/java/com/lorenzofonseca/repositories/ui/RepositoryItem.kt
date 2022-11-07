package com.lorenzofonseca.repositories.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.domain.model.RepositoryModel
import com.lorenzofonseca.repositories.R
import com.lorenzofonseca.resources.ui.Color
import com.lorenzofonseca.resources.ui.Theme.GitPubTheme
import com.lorenzofonseca.resources.ui.Type

@Composable
fun RepositoryItemCard(repository: RepositoryModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }, elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = repository.name, style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).h6
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = repository.description ?: stringResource(id = R.string.no_description),
                style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).subtitle1
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Number of forks: ${repository.forkCounts}",
                style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).body1
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Created: ${repository.created_at}",
                style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).body1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Last update: ${repository.updated_at}",
                style = Type.Typography(
                    Color.contrastColor(
                        isSystemInDarkTheme()
                    )
                ).body1
            )
            Spacer(modifier = Modifier.height(4.dp))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RepostoryItemPreview() {
    GitPubTheme {
        RepositoryItemCard(
            repository = RepositoryModel(
                "GitPub",
                id = 932893,
                description = "App to show your current repos on GitHub!",
                created_at = "August, 2021",
                forkCounts = 5,
                topics = listOf("Kotlin", "Mobile"),
                size = 138,
                updated_at = "November, 2022"


            )
        )
    }
}