package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.AuthModel

interface IAuthenticationRepository {
    suspend fun auth(clientId : String, clientSecret : String) : AuthModel
}
