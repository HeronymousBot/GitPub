package com.lorenzofonseca.domain.repository

import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.domain.model.AuthRequestModel
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {

    fun getAuthRequestInformation(): Flow<AuthRequestModel>
    fun getAccessTokenInformation() : Flow<AuthModel>
    fun getUserInformation()
    suspend fun setAccessTokenInformation(authModel: AuthModel)
}