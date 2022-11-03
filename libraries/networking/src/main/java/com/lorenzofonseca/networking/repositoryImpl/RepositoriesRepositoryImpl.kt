package com.lorenzofonseca.networking.repositoryImpl

import com.lorenzofonseca.domain.model.RepositoriesModel
import com.lorenzofonseca.networking.response.toModel
import com.lorenzofonseca.networking.service.RepositoriesService

class RepositoriesRepositoryImpl(val service : RepositoriesService) :
    com.lorenzofonseca.domain.repository.RepositoriesRepository {
    override suspend fun getRepositoriesList(): RepositoriesModel {
        return service.getRepositories().toModel()
    }
}