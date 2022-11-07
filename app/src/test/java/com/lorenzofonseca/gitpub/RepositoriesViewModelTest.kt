package com.lorenzofonseca.gitpub

import com.lorenzofonseca.gitpub.di.serviceModules
import com.lorenzofonseca.gitpub.di.viewModules
import com.lorenzofonseca.repositories.ui.RepositoriesViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock

class RepositoriesViewModelTest
    : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(serviceModules, viewModules)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mockkClass(clazz)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `If GetUser is called, it should be executed only once`() = runTest {
        val mock = declareMock<RepositoriesViewModel> {
            coEvery { this@declareMock.getUser() } returns mockk()
        }

        mock.getUser()
        coVerify(exactly = 1) { mock.getUser() }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `If GetRepositories is called, it should be executed only once and with correct parameter`() =
        runTest {
            val usernameSlot = slot<String>()
            val service = declareMock<RepositoriesViewModel> {
                coEvery { this@declareMock.getRepositoriesList(capture(usernameSlot)) } returns mockk()
            }

            service.getRepositoriesList("heronymousbot")
            coVerify(exactly = 1) { service.getRepositoriesList("heronymousbot") }
        }
}