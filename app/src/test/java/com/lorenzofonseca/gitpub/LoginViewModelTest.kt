package com.lorenzofonseca.gitpub

import com.lorenzofonseca.gitpub.di.serviceModules
import com.lorenzofonseca.gitpub.di.viewModules
import com.lorenzofonseca.login.LoginViewModel
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

class LoginViewModelTest : KoinTest {

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
    fun `If getAccessToken is called, it should be executed only once and with correct parameters`() =
        runTest {
            val codeSlot = slot<String>()
            val stateSlot = slot<String>()
            val mock = declareMock<LoginViewModel> {
                coEvery {
                    this@declareMock.getAccessToken(
                        capture(codeSlot),
                        capture(stateSlot)
                    )
                } returns mockk()
            }

            mock.getAccessToken("1234", "state")
            coVerify(exactly = 1) { mock.getAccessToken("1234", "state") }
        }
}