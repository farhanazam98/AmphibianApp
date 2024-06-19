package com.example.amphibians.ui.screens

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.Amphibian
import com.example.amphibians.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AmphibianViewModel : ViewModel() {
    data class AmphibianUiState(
        val amphibians: List<Amphibian> = listOf()
    )

    private val _uiState = MutableStateFlow(AmphibianUiState())
    val uiState: StateFlow<AmphibianUiState> = _uiState.asStateFlow()

   init {
       val amphibians: ArrayList<Amphibian> = arrayListOf()
       val amphibian = Amphibian(
           name = "Great Basin Spadefoot",
           type = "Toad",
           description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots.",
           imageSource = "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.png"
       )
       for (num in 1..5) {
           amphibians.add(amphibian)
       }
       _uiState.update { it.copy(amphibians = amphibians) }
   }

}
