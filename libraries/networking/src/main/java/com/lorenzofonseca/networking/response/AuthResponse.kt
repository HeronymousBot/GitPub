package com.lorenzofonseca.networking.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthResponse(val code : String, val state : String)
