package com.lorenzofonseca.networking.repositoryImpl

import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.networking.response.toModel
import com.lorenzofonseca.networking.service.AuthenticationService

class AuthenticationRepositoryImpl(val service : AuthenticationService) :
    com.lorenzofonseca.domain.repository.AuthenticationRepository {

    override suspend fun auth(clientId: String, clientSecret: String): AuthModel {
        val result = service.auth(clientId, clientSecret)
        return result.toModel()
    }
}