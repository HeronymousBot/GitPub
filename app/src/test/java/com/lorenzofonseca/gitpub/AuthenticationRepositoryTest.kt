package com.lorenzofonseca.gitpub

import com.lorenzofonseca.domain.model.AuthModel
import com.lorenzofonseca.domain.repository.AuthenticationRepository
import com.lorenzofonseca.domain.repository.GithubApiRepository
import com.lorenzofonseca.gitpub.di.serviceModules
import com.lorenzofonseca.gitpub.di.viewModules
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock

class AuthenticationRepositoryTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(serviceModules, viewModules)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mockkClass(clazz)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `If getAccessToken is called, it should be executed only once with correct parameters`() = runTest {

        val accessTokenSlot = slot<String>()
        val service = declareMock<AuthenticationRepository> {
            coEvery {
                this@declareMock.getAccessToken(
                    capture(accessTokenSlot),
                    any(),
                    any(),
                    any()
                )
            } returns AuthModel("3490830948049", 9, "", 2)
        }

        service.getAccessToken("kodsa09sdj03089374", "", "", "")
        coVerify(exactly = 1) { service.getAccessToken("kodsa09sdj03089374", any(), any(), any()) }
    }
}