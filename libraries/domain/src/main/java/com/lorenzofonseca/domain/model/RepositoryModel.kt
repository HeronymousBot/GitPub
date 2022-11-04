package com.lorenzofonseca.domain.model

data class RepositoryModel(
    val name: String,
    val id: Int,
    val description: String,
    val forkCounts: Int,
    val size: Int,
    val created_at: String,
    val updated_at: String,
    val topics: List<String>
)
