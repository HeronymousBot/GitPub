package com.lorenzofonseca.networking

import com.lorenzofonseca.networking.response.toModel
import com.lorenzofonseca.networking.service.RepositoriesService

class RepositoriesRepository(val service : RepositoriesService) :
    com.lorenzofonseca.domain.repository.IRepositoriesRepository {
    override suspend fun getRepositoriesList(): com.lorenzofonseca.domain.RepositoriesModel {
        return service.getRepositories().toModel()
    }
}