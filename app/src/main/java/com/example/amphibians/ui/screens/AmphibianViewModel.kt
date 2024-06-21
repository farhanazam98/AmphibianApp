package com.example.amphibians.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.AmphibianRepository
import com.example.amphibians.data.NetworkAmphibianRepository
import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AmphibianViewModel : ViewModel() {
    data class AmphibianUiState(
        val amphibians: List<Amphibian> = listOf(),
    )

    private val _uiState = MutableStateFlow(AmphibianUiState())
    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()

    private val amphibianRepository = NetworkAmphibianRepository()

   init {
       getAmphibians()
   }

    private fun getAmphibians(){
        viewModelScope.launch {
            val amphibians = amphibianRepository.getAmphibians()
            _uiState.update { it.copy(amphibians = amphibians) }
        }

    }

}
