package com.lorenzofonseca.networking.service


import com.lorenzofonseca.networking.response.AuthResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationService {

    @POST("/access_token")
    suspend fun getAccessToken(
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("code") code: String,
        @Query("state") state: String
    ): AuthResponse
}