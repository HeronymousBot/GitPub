package com.lorenzofonseca.networking

import com.lorenzofonseca.networking.service.AuthenticationService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Networking {
    val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header(
                            "User-Agent",
                            ""
                        )
                        .build()
                )
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private val githubRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(moshi())
            .client(okHttpClient)
            .build()
    }

    internal val githubService = {githubRetrofit.create(AuthenticationService::class.java)}

    // Moshi Set Up
    private fun moshi() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )

    private val baseUrl = ""

}