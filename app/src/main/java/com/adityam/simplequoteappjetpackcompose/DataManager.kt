package com.adityam.simplequoteappjetpackcompose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.adityam.simplequoteappjetpackcompose.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()

    var currentQuote: Quote? = null
    var currentPage = mutableStateOf(Screens.Listing)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetFromFile(context: Context) {

        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchScreens(quote: Quote?) {
        if(currentPage.value == Screens.Listing) {
            currentQuote = quote
            currentPage.value = Screens.Details
        } else {
            currentPage.value = Screens.Listing
        }
    }

}