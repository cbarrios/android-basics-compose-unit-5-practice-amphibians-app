package com.lalosapps.amphibiansapp.ui.screens

import com.lalosapps.amphibiansapp.data.network.dto.Amphibian

sealed interface AmphibiansUiState {
    object Loading : AmphibiansUiState
    object Error : AmphibiansUiState
    data class Success(val amphibians: List<Amphibian>) : AmphibiansUiState
}