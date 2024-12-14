package com.adityam.simplequoteappjetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.adityam.simplequoteappjetpackcompose.R
import com.adityam.simplequoteappjetpackcompose.models.Quote

@Composable
fun QuotesListScreen(quoteList: Array<Quote>, onClick: (quote:Quote)-> Unit) {
    Column {
        Text(text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp,24.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = FontFamily(Font((R.font.montserrat_regular)))
        )
        QuoteList(quoteList = quoteList, onClick)
    }
}