package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.AuthModel

interface AuthenticationRepository {
    suspend fun auth(clientId : String, clientSecret : String) : AuthModel
}
