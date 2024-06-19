package com.example.amphibians

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AmphibianViewModel: ViewModel() {
    data class AmphibianUiState(
        val amphibians: List<String> = listOf("Frog", "Snake", "Lizard")
    )

    private val _uiState = MutableStateFlow(AmphibianUiState())
    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()

}
