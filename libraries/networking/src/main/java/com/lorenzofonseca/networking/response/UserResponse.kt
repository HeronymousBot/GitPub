package com.lorenzofonseca.networking.response

import com.lorenzofonseca.domain.model.UserModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String,
    val location: String,
    val email: String? = "",
    val bio: String? = "",
    val followers: Int,
    val following: Int,
    val created_at: String,
    val total_private_repos: Int? = 0
)

fun UserResponse.toModel() = UserModel(
    login,
    id,
    avatar_url,
    name,
    location,
    email,
    bio,
    followers,
    following,
    created_at,
    total_private_repos
)
