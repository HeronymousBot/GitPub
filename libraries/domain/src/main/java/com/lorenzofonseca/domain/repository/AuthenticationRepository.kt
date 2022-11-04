package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.AuthModel

interface AuthenticationRepository {
    suspend fun getAccessToken(
        clientId: String,
        clientSecret: String,
        code: String,
        state: String
    ): AuthModel
}
