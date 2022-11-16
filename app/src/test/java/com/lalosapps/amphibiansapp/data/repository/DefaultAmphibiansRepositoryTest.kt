package com.lalosapps.amphibiansapp.data.repository

import com.lalosapps.amphibiansapp.fake.repository.FakeAmphibiansApi
import com.lalosapps.amphibiansapp.fake.repository.FakeDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DefaultAmphibiansRepositoryTest {

    private lateinit var repository: AmphibiansRepository
    private lateinit var api: FakeAmphibiansApi

    @Before
    fun onBefore() {
        api = FakeAmphibiansApi()
        repository = DefaultAmphibiansRepository(api)
    }

    @Test
    fun getAmphibians_onSuccess_verifyList() = runTest {
        // When
        val amphibians = repository.getAmphibians()

        // Then
        assertEquals(FakeDataSource.amphibians, amphibians)
    }

    @Test
    fun getAmphibians_onError_verifyListIsNull() = runTest {
        // Given
        api.errorResponse = true

        // When
        val amphibians = repository.getAmphibians()

        // Then
        assertEquals(null, amphibians)
    }

    @Test
    fun getAmphibians_onException_verifyListIsNull() = runTest {
        // Given
        api.throwsException = true

        // When
        val amphibians = repository.getAmphibians()

        // Then
        assertEquals(null, amphibians)
    }
}