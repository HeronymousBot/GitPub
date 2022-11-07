package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.RepositoryModel
import com.lorenzofonseca.domain.model.UserModel

interface GithubApiRepository {

    suspend fun getRepositoriesList(username: String, accessToken: String): List<RepositoryModel>
    suspend fun getUser(accessToken: String): UserModel
}