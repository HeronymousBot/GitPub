package com.lorenzofonseca.domain.model

data class UserModel(
    val login: String,
    val id: String,
    val avatar_url: String,
    val name: String,
    val location: String,
    val email: String,
    val bio: String,
    val followers: Int,
    val following: Int,
    val created_at: String,
    val owned_private_repos: Int
)
