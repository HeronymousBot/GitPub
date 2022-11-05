package com.lorenzofonseca.networking

import java.util.*

object AuthenticationUrl{
    val clientSecret = "434b09824d11deb1660eef363107c91bb4daf65c"
    val clientId = "Iv1.b9547fe756d6a088"
    val scope = "read:user,public_repo,gist"
    val state = UUID.randomUUID().toString()
    val authBaseUrl = "https://github.com/login/oauth"

    fun generateAuthUrl() : String{
        return "$authBaseUrl/authorize?client_id=$clientId&scope=$scope&state=$state"
    }
}

object GithubApiUrl{
    const val baseUrl = "https://api.github.com"
}