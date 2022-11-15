package com.lalosapps.amphibiansapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.lalosapps.amphibiansapp.AmphibiansApp
import com.lalosapps.amphibiansapp.data.repository.AmphibiansRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AmphibiansViewModel(
    private val repository: AmphibiansRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibiansUiState>(AmphibiansUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = AmphibiansUiState.Loading
            val list = repository.getAmphibians()
            if (list != null) {
                _uiState.value = AmphibiansUiState.Success(amphibians = list)
            } else {
                _uiState.value = AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApp)
                val amphibiansRepository = application.appContainer.amphibiansRepository
                AmphibiansViewModel(repository = amphibiansRepository)
            }
        }
    }
}