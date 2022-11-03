package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.RepositoriesModel

interface IRepositoriesRepository {

    suspend fun getRepositoriesList() : RepositoriesModel
}