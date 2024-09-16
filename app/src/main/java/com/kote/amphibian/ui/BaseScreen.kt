package com.kote.amphibian.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kote.amphibian.model.Amphibian

@Composable
fun BaseScreen(
    amphibianUiState: AmphibianUiState,
    modifier: Modifier = Modifier
) {
    when (amphibianUiState) {
        is AmphibianUiState.Success -> ShowAmphibiansGrid(
            amphibians = amphibianUiState.amphibians
        )
        is AmphibianUiState.Error -> {
            Text(text = "ErrorScreen")
        }
        is AmphibianUiState.Loading -> {
            Text(text = "LoadingScreen")
        }
    }
}

@Composable
fun ShowAmphibiansGrid(
    amphibians: List<Amphibian>,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(amphibians) { amphibian ->
            AmphibianCard(
                amphibian = amphibian,
                modifier = modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun AmphibianCard(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    var isLoading by remember { mutableStateOf(true) }
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "${amphibian.name} (${amphibian.type})",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(2.dp))
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = amphibian.name,
                contentScale = ContentScale.Crop,
                onLoading = { isLoading = true },
                onError = { isLoading = false },
                onSuccess = { isLoading = false },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AmphibianCardPreview() {
    AmphibianCard(
        amphibian =  Amphibian(
            "mockName",
            "mockType",
            "mockDesc",
            "https://developer.android.com/codelabs/basic-android-kotlin-compose-amphibians-app/img/great-basin-spadefoot.pn")
    )
}