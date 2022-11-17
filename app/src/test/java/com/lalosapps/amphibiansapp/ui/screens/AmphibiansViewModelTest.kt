package com.lalosapps.amphibiansapp.ui.screens

import com.lalosapps.amphibiansapp.fake.repository.FakeDataSource
import com.lalosapps.amphibiansapp.fake.viewmodel.FakeAmphibiansRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AmphibiansViewModelTest {

    private lateinit var viewModel: AmphibiansViewModel
    private lateinit var repository: FakeAmphibiansRepository

    @Before
    fun onBefore() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @Test
    fun init_onApiList_verifyUiStateSuccess() = runTest {
        // Given
        repository = FakeAmphibiansRepository().apply { returnsNull = false }
        viewModel = AmphibiansViewModel(repository)

        // When (init block executes)
        val uiState = viewModel.uiState.value

        // Then
        assertEquals(AmphibiansUiState.Success(FakeDataSource.amphibians), uiState)
    }

    @Test
    fun init_onNullApiList_verifyUiStateError() = runTest {
        // Given
        repository = FakeAmphibiansRepository().apply { returnsNull = true }
        viewModel = AmphibiansViewModel(repository)

        // When (init block executes)
        val uiState = viewModel.uiState.value

        // Then
        assertEquals(AmphibiansUiState.Error, uiState)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }
}