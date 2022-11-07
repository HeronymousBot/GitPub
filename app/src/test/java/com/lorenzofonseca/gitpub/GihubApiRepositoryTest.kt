package com.lorenzofonseca.gitpub

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

class GihubApiRepositoryTest : KoinTest {

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
    fun `If GetRepositoriesList is called, it should be executed only once`() = runTest {
        val service = declareMock<GithubApiRepository> {
            coEvery { this@declareMock.getRepositoriesList("","") } returns mockk()
        }

        service.getRepositoriesList("","")
        coVerify(exactly = 1) { service.getRepositoriesList(any(), any()) }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `If GetUser is called, it should be executed only once`() = runTest {
        val service = declareMock<GithubApiRepository> {
            coEvery { this@declareMock.getUser("") } returns mockk()
        }

        service.getUser("")
        coVerify(exactly = 1) { service.getUser(any()) }
    }
}