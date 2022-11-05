package com.lorenzofonseca.networking.response

import com.lorenzofonseca.domain.model.AuthModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse(
    val access_token: String,
    val expires_in: Long,
    val refresh_token: String,
    val refresh_token_expires_in: Long
)

fun AuthResponse.toModel(): AuthModel =
    AuthModel(access_token, expires_in, refresh_token, refresh_token_expires_in)
