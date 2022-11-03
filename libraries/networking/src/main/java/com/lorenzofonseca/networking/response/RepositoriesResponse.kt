package com.lorenzofonseca.networking.response

import com.lorenzofonseca.domain.RepositoriesModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoriesResponse(val userId: String)

fun RepositoriesResponse.toModel() = com.lorenzofonseca.domain.RepositoriesModel(this.userId)
