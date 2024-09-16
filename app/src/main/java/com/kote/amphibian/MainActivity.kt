@file:OptIn(ExperimentalMaterial3Api::class)

package com.kote.amphibian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kote.amphibian.ui.AmphibianViewModel
import com.kote.amphibian.ui.BaseScreen
import com.kote.amphibian.ui.theme.AmphibianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibianTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AmphibianApp()
                }
            }
        }
    }
}

@Composable
fun AmphibianApp() {
    val amphibianViewModel: AmphibianViewModel =
        viewModel(factory = AmphibianViewModel.Factory)
    BaseScreen(amphibianUiState = amphibianViewModel.amphibianUIState)
}
