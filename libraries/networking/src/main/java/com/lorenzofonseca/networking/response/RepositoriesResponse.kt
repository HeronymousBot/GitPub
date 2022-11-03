package com.lorenzofonseca.networking.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoriesResponse(val userId : String)
