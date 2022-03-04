package com.sandip.quoteapplication.util

import com.sandip.quoteapplication.R

object bgcolor{
    private val bg = arrayOf(
            R.drawable.bg_gradient,
            R.drawable.bg_gradient2,
            R.drawable.bg_gradient3,
            R.drawable.bg_gradient4
    )
    var bgindex = 0

    fun getIcon(): Int {
        bgindex = (0..(bg.size)-1).random()
        return bg[bgindex]
    }

}