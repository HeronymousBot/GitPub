package com.lorenzofonseca.datastorage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.domain.model.AuthRequestModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object UserDataStorePreferences {
    private val Context.userPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "user"
    )

    private val USER_FIRST_NAME = stringPreferencesKey("user_first_name")
    private val USER_LAST_NAME = stringPreferencesKey("user_last_name")
    private val USER_BIRTH_DAY = stringPreferencesKey("user_birth_day")

    suspend fun Context.storeUser(userName: String, birthday: String) {
        userPreferencesDataStore.edit { preferences ->
            preferences[USER_FIRST_NAME] = userName
            preferences[USER_BIRTH_DAY] = birthday
        }
    }
}

object AuthInformationDataStorePreferences {
    private val Context.authInformationPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "auth_information"
    )

    private val CODE = stringPreferencesKey("user_auth_code")
    private val STATE = stringPreferencesKey("user_auth_state")

    suspend fun Context.storeAuthRequestInformation(code: String, state: String) {
        authInformationPreferencesDataStore.edit { preferences ->
            preferences[CODE] = code
            preferences[STATE] = state
        }
    }

    fun Context.getAuthRequestInformation() =
        authInformationPreferencesDataStore.data.map { preferences ->
            AuthRequestModel(
                code = preferences[CODE] ?: "",
                state = preferences[STATE] ?: "",
            )
        }

}

object TokenDataStorePreferences {
    private val Context.tokenPreferencesDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "token"
    )

    private val ACCESS_TOKEN = stringPreferencesKey("user_access_token")
    private val TIME_UNTIL_ACCESS_TOKEN_EXPIRATION =
        longPreferencesKey("acess_token_expiration_date")
    private val REFRESH_TOKEN = stringPreferencesKey("user_refresh_token")
    private val TIME_UNTIL_REFRESH_TOKEN_EXPIRATION =
        longPreferencesKey("refresh_token_expiration_date")

    suspend fun Context.storeTokenData(authData: AuthModel) {
        tokenPreferencesDataStore.edit { preferences ->
            preferences[ACCESS_TOKEN] = authData.access_token
            preferences[TIME_UNTIL_ACCESS_TOKEN_EXPIRATION] = authData.expires_in
            preferences[REFRESH_TOKEN] = authData.refresh_token
            preferences[TIME_UNTIL_REFRESH_TOKEN_EXPIRATION] = authData.refresh_token_expires_in

        }
    }

    fun Context.getTokenData(): Flow<AuthModel> =
        tokenPreferencesDataStore.data.map { preferences ->
            AuthModel(
                access_token = preferences[ACCESS_TOKEN] ?: "",
                expires_in = preferences[TIME_UNTIL_ACCESS_TOKEN_EXPIRATION] ?: 0,
                refresh_token = preferences[REFRESH_TOKEN] ?: "",
                refresh_token_expires_in = preferences[TIME_UNTIL_REFRESH_TOKEN_EXPIRATION] ?: 0
            )
        }
}