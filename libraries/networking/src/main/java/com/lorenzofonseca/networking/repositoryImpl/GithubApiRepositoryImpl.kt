package com.lorenzofonseca.networking.repositoryImpl

import com.lorenzofonseca.domain.model.RepositoryModel
import com.lorenzofonseca.domain.model.UserModel
import com.lorenzofonseca.domain.repository.GithubApiRepository
import com.lorenzofonseca.networking.response.toModel
import com.lorenzofonseca.networking.service.GithubApiService

class GithubApiRepositoryImpl(val service: GithubApiService) :
    GithubApiRepository {
    override suspend fun getRepositoriesList(
        username: String,
        accessToken: String
    ): List<RepositoryModel> {
        return service.getRepositoriesForUser(username = username, accessToken = accessToken)
            .toModel()
    }

    override suspend fun getUser(accessToken: String): UserModel {
        return service.getUser(accessToken = accessToken).toModel()
    }


}