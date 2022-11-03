package com.lorenzofonseca.networking

import com.lorenzofonseca.networking.response.AuthResponse
import com.lorenzofonseca.networking.service.AuthenticationService

class AuthenticationRepository() : AuthenticationService {

    override suspend fun auth(clientId: String, clientSecret: String): AuthResponse {
        val result = Networking.githubService().auth(clientId, clientSecret)
        return result
    }
}