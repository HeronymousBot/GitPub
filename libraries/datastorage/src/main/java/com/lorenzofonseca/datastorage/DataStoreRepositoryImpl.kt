package com.lorenzofonseca.datastorage

import android.content.Context
import com.lorenzofonseca.datastorage.AuthInformationDataStorePreferences.getAuthRequestInformation
import com.lorenzofonseca.datastorage.TokenDataStorePreferences.getTokenData
import com.lorenzofonseca.datastorage.TokenDataStorePreferences.storeTokenData
import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.domain.model.AuthRequestModel
import com.lorenzofonseca.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class DataStoreRepositoryImpl(val context: Context) :
    DataStoreRepository {
    override fun getAuthRequestInformation(): Flow<AuthRequestModel> {
        return context.getAuthRequestInformation()
    }

    override fun getAccessTokenInformation(): Flow<AuthModel> {
        return context.getTokenData()
    }

    override fun getUserInformation() {
        TODO("Not yet implemented")
    }

    override suspend fun setAccessTokenInformation(authModel: AuthModel) {
        context.storeTokenData(authModel)
    }


}