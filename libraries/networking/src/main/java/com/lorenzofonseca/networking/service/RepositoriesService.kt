package com.lorenzofonseca.networking.service

import com.lorenzofonseca.networking.response.RepositoriesResponse
import retrofit2.http.GET

interface RepositoriesService {
    @GET
    suspend fun getRepositories() : RepositoriesResponse
}