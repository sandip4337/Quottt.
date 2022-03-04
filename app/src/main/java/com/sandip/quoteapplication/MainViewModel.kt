package com.sandip.quoteapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.util.*


class MainViewModel(val context: Context): ViewModel() {

    private var quoteList: Array<Quote> = emptyArray()

    init {
        quoteList = loadQuoteFromAssets()
    }

    private fun loadQuoteFromAssets(): Array<Quote> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quote>::class.java)
    }

    //    initialize stack
    private val stack = ArrayDeque<Int>()

    fun getQuote(): Quote {
        val l:Int = (0..(quoteList.size)).random()
        stack.push(l)
        return quoteList[l]
    }

    fun nextQuote(): Quote {
        val r:Int = (0..(quoteList.size)).random()
        stack.push(r)
        return quoteList[r]
    }

    fun previousQuote(): Quote {
        stack.pop()
        return quoteList[stack.peek()]
    }
}