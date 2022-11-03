package com.lorenzofonseca.networking.service


import com.lorenzofonseca.networking.response.AuthResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationService {

    @POST("launcher/0.1/auth")
    suspend fun auth(
        @Query("clientId") clientId: String,
        @Query("clientSecret") clientSecret: String
    ): AuthResponse
}