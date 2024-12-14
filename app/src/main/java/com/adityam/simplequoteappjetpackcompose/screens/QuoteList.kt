package com.adityam.simplequoteappjetpackcompose.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adityam.simplequoteappjetpackcompose.models.Quote

@Composable
fun QuoteList(quoteList: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    LazyColumn {
        items(quoteList) { quotes ->
            QuotesListItem(quotes = quotes, onClick)
        }
    }
    
}