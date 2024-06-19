package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.amphibians.ui.screens.AmphibianViewModel
import com.example.amphibians.ui.screens.MainScreen
import com.example.amphibians.ui.theme.AmphibiansTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val amphibians: ArrayList<AmphibianViewModel.Amphibian> = arrayListOf()
            val amphibian = AmphibianViewModel.Amphibian(
                name = stringResource(id = R.string.placeholder_name),
                type = stringResource(id = R.string.placeholder_type),
                description = stringResource(id = R.string.placeholder_description),
                drawable = R.drawable.great_basin_spadefoot
            )
            for (num in 1..5) {
                amphibians.add(amphibian)
            }
            val viewModel: AmphibianViewModel by viewModels()
            viewModel.setAmphibians(amphibians)
                AmphibiansTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        amphibians = viewModel.uiState.collectAsState().value.amphibians,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

