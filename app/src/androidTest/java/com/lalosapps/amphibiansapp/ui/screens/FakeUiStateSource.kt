package com.lalosapps.amphibiansapp.ui.screens

import com.lalosapps.amphibiansapp.data.network.dto.Amphibian
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object FakeUiStateSource {

    private val fakeUiState = MutableStateFlow<AmphibiansUiState>(AmphibiansUiState.Loading)
    val uiState = fakeUiState.asStateFlow()

    val amphibians = listOf(
        Amphibian("Amphibian 1", "Toad", "Amphibian 1 is great.", "Url 1"),
        Amphibian("Amphibian 2", "Salamander", "Amphibian 2 is awesome.", "Url 2"),
        Amphibian("Amphibian 3", "Frog", "Amphibian 3 is amazing.", "Url 3")
    )

    fun setLoadingState() {
        fakeUiState.value = AmphibiansUiState.Loading
    }

    fun setSuccessState() {
        fakeUiState.value = AmphibiansUiState.Success(amphibians)
    }

    fun setErrorState() {
        fakeUiState.value = AmphibiansUiState.Error
    }
}