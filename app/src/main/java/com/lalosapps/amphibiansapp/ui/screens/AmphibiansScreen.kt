package com.lalosapps.amphibiansapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lalosapps.amphibiansapp.R
import com.lalosapps.amphibiansapp.data.network.dto.Amphibian
import com.lalosapps.amphibiansapp.ui.components.AmphibianItem

@Composable
fun AmphibiansScreen(
    viewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
) {
    val uiState = viewModel.uiState.collectAsState().value
    AmphibiansScreen(uiState)
}

@Composable
fun AmphibiansScreen(uiState: AmphibiansUiState) {
    when (uiState) {
        AmphibiansUiState.Loading -> LoadingScreen()
        AmphibiansUiState.Error -> ErrorScreen()
        is AmphibiansUiState.Success -> SuccessScreen(uiState.amphibians)
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = stringResource(R.string.error_message))
    }
}

@Composable
fun SuccessScreen(amphibians: List<Amphibian>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = amphibians,
            key = { it.name }
        ) {
            AmphibianItem(amphibian = it)
        }
    }
}