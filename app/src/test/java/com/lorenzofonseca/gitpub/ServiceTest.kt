package com.lorenzofonseca.gitpub

import com.lorenzofonseca.gitpub.di.serviceModules
import com.lorenzofonseca.gitpub.di.viewModules
import com.lorenzofonseca.login.LoginViewModel
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.koin.test.mock.declareMock

class ServiceTest : KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(serviceModules, viewModules)
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        mockkClass(clazz)
    }

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }


}