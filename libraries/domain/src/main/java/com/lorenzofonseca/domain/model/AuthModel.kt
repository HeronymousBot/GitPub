package com.lorenzofonseca.domain.model

data class AuthModel(val access_token: String,
                     val expires_in: Long,
                     val refresh_token: String,
                     val refresh_token_expires_in: Long)
