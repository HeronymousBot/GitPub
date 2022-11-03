package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.RepositoriesModel

interface RepositoriesRepository {

    suspend fun getRepositoriesList() : RepositoriesModel
}