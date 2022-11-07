package com.lorenzofonseca.networking.response

import com.lorenzofonseca.domain.model.RepositoryModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoryResponse(
    val name: String,
    val id: Int,
    val description: String? = "",
    val forkCounts: Int? = 0,
    val size: Int,
    val created_at: String,
    val updated_at: String,
    val topics: List<String>
)

fun RepositoryResponse.toModel() =
    RepositoryModel(
        name = name,
        id = id,
        description = description,
        forkCounts = forkCounts,
        size = size,
        created_at = created_at,
        updated_at = updated_at,
        topics = topics
    )

fun List<RepositoryResponse>.toModel() = this.map { it.toModel() }
