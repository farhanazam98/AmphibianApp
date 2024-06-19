package com.example.amphibians.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AmphibianViewModel : ViewModel() {
    data class AmphibianUiState(
        val amphibians: List<Amphibian> = listOf()
    )

    class Amphibian(
        val name: String,
        val type: String,
        val description: String,
        val drawable: Int,
    )

    private val _uiState = MutableStateFlow(AmphibianUiState())
    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()

}
