package com.lorenzofonseca.networking

import com.lorenzofonseca.networking.repositoryImpl.AuthenticationRepositoryImpl
import com.lorenzofonseca.networking.repositoryImpl.GithubApiRepositoryImpl
import com.lorenzofonseca.networking.service.AuthenticationService
import com.lorenzofonseca.networking.service.GithubApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header(
                            "Accept",
                            "application/json"
                        )
                        .build()
                )
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val githubAuthRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AuthenticationUrl.authBaseUrl)
            .addConverterFactory(moshi())
            .client(okHttpClient)
            .build()
    }

    private val githubApiRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(GithubApiUrl.baseUrl)
            .addConverterFactory(moshi())
            .client(okHttpClient)
            .build()
    }

    val authenticationService by lazy { githubAuthRetrofit.create(AuthenticationService::class.java) }
    val githubApiService by lazy { githubApiRetrofit.create(GithubApiService::class.java) }

    internal val authenticationRepository by lazy { AuthenticationRepositoryImpl(authenticationService) }
    internal val githubApiRepository by lazy { GithubApiRepositoryImpl(githubApiService) }

    // Moshi Set Up
    private fun moshi() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )

}