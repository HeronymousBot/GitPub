package com.lorenzofonseca.networking

import com.lorenzofonseca.networking.response.toModel
import com.lorenzofonseca.networking.service.AuthenticationService

class AuthenticationRepository(val service : AuthenticationService) :
    com.lorenzofonseca.domain.repository.IAuthenticationRepository {

    override suspend fun auth(clientId: String, clientSecret: String): com.lorenzofonseca.domain.AuthModel {
        val result = service.auth(clientId, clientSecret)
        return result.toModel()
    }
}