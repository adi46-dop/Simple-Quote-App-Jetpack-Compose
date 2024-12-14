package com.adityam.simplequoteappjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.adityam.simplequoteappjetpackcompose.screens.QuoteDetail
import com.adityam.simplequoteappjetpackcompose.screens.QuotesListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {

            Scaffold { innerPadding ->

                App(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    if(DataManager.isDataLoaded.value) {

        if(DataManager.currentPage.value == Screens.Listing) {

            QuotesListScreen(DataManager.data) {
                DataManager.switchScreens(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetail(quote = it) { } }
        }

    } else  {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(text = "Loading...")
            CircularProgressIndicator()
        }
    }
}

enum class Screens {
    Listing,Details
}
