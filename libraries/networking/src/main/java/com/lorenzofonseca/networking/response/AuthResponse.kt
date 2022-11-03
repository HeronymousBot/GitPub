package com.lorenzofonseca.networking.response

import com.lorenzofonseca.networking.AuthData
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse(val code: String, val state: String)

fun AuthResponse.toModel(): AuthData = AuthData(this.code, this.state)
