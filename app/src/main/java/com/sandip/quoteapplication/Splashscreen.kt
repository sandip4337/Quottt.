package com.sandip.quoteapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //vanish the windomanger
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splashscreen)

        //handle the splashscreen
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Splashscreen,MainActivity::class.java)
            startActivity(intent)
            finish() } , 1700)
    }
}