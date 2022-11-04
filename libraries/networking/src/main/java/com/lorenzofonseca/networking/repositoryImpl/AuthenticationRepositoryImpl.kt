package com.lorenzofonseca.networking.repositoryImpl

import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.domain.repository.AuthenticationRepository
import com.lorenzofonseca.networking.response.toModel
import com.lorenzofonseca.networking.service.AuthenticationService

class AuthenticationRepositoryImpl(val service: AuthenticationService) :
    AuthenticationRepository {
    override suspend fun getAccessToken(
        clientId: String,
        clientSecret: String,
        code: String,
        state: String
    ): AuthModel {
        val result = service.getAccessToken(clientId, clientSecret, code, state)
        return result.toModel()
    }
}