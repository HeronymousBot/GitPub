package com.lorenzofonseca.networking.service

import com.lorenzofonseca.networking.response.RepositoryResponse
import com.lorenzofonseca.networking.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubApiService {
    @GET("user")
    suspend fun getUser(@Header("Authorization") accessToken: String): UserResponse

    @GET("users/{username}/repos")
    suspend fun getRepositoriesForUser(
        @Path("username") username: String,
        @Header("Authorization") accessToken: String
    ): List<RepositoryResponse>
}