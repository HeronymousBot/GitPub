package com.lorenzofonseca.networking.response

import com.lorenzofonseca.domain.model.RepositoriesModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoriesResponse(val userId: String)

fun RepositoriesResponse.toModel() = RepositoriesModel(this.userId)
