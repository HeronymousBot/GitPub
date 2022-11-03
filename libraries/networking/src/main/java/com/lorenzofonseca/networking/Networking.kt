package com.lorenzofonseca.networking

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Networking {
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                chain.proceed(
                    chain.request()
                        .newBuilder()
                        .header(
                            "User-Agent",
                            "StarStableOnline/" + "1.999999.1" + " " + "Android"
                        )
                        .build()
                )
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    // Moshi Set Up
    private fun moshi() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )


    // Config Services

    private val configRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://launcher-config.starstable.com/")
            .addConverterFactory(moshi())
            .client(okHttpClient)
            .build()
    }

}