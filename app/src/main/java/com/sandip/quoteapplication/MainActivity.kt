package com.sandip.quoteapplication


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.sandip.quoteapplication.util.bgcolor

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    private val bg: View get() = findViewById(R.id.backgrond)

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    private val previmage:ImageView get() = findViewById(R.id.nextview)

    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(application)).get(MainViewModel::class.java)
        val quote: Quote = mainViewModel.getQuote()
        setQuote(quote)

//        imgbtn = findViewById(R.id.screenshot)
    }

    private fun setQuote(quote: Quote){
        bg.setBackgroundResource(bgcolor.getIcon())
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }

    fun onPrevious(view: View) {
        if (count != 0) {
            setQuote(mainViewModel.previousQuote())
            count--
            if (count == 0){
                previmage.visibility = View.GONE
            }
        }

    }

    fun onNext(view: View) {
        count++
        setQuote(mainViewModel.nextQuote())
        previmage.visibility = View.VISIBLE
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, "${quoteText.text} \n\n ~ ${quoteAuthor.text}")
        startActivity(intent)
    }

//    fun imageshare(view: View) {
//        val bitmap = getScreenShotFromView(bg)
//        if (bitmap != null) {
//            Log.d("bit", bitmap.toString())
//    }
//    }


//    private fun getScreenShotFromView(v: View): Bitmap? {
//        // create a bitmap object
//        var screenshot: Bitmap? = null
//        try {
//            // inflate screenshot object with Bitmap.createBitmap it requires three parameters
//            // width and height of the view and the background color
//            screenshot = Bitmap.createBitmap(v.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_8888)
//            // Now draw this bitmap on a canvas
//            val canvas = Canvas(screenshot)
//            v.draw(canvas)
//        } catch (e: Exception) {
//            Log.e("GFG", "Failed to capture screenshot because:" + e.message)
//        }
//        // return the bitmap
//        return screenshot
//    }
}



