package com.example.amphibians.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.ui.screens.AmphibianViewModel.Amphibian
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun MainScreen(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier,
) {
    Column {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(amphibians) { it: Amphibian ->
                AmphibianCard(
                    name = it.name,
                    type = it.type,
                    drawable = it.drawable,
                    description = it.description
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun MainScreenPreview() {
    val amphibians: ArrayList<Amphibian> = arrayListOf()
    val amphibian = Amphibian(
        name = stringResource(id = R.string.placeholder_name),
        type = stringResource(id = R.string.placeholder_type),
        description = stringResource(id = R.string.placeholder_description),
        drawable = R.drawable.great_basin_spadefoot
    )
    for (num in 1..5) {
        amphibians.add(amphibian)
    }
    AmphibiansTheme {
        MainScreen(amphibians)
    }
}

@Composable
fun AmphibianCard(
    name: String,
    type: String,
    @DrawableRes drawable: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    val paddingModifier = Modifier.padding(8.dp)
    Card(
        modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(
            text = "$name ($type)",
            style = MaterialTheme.typography.labelMedium,
            modifier = paddingModifier
        )
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = description, modifier = paddingModifier
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AmphibianCardPreview() {
    AmphibianCard(
        name = "Great Basin Spadefoot",
        type = "Toad",
        drawable = R.drawable.great_basin_spadefoot,
        description = "This toad spends most of its life underground due to the arid desert conditions in which it lives. Spadefoot toads earn the name because of their hind legs which are wedged to aid in digging. They are typically grey, green, or brown with dark spots."
    )
}

