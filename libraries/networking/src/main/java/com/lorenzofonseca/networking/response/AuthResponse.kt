package com.lorenzofonseca.networking.response

import com.lorenzofonseca.domain.model.AuthModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse(val code: String, val state: String)

fun AuthResponse.toModel(): AuthModel = AuthModel(this.code, this.state)
