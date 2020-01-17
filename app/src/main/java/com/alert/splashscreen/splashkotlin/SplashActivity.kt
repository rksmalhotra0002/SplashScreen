package com.alert.splashscreen.splashkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.alert.splashscreen.R
import com.alert.splashscreen.Walkthrough
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
private lateinit var iv_splash:ImageView
private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       getids() //calling a function
    }

    private fun getids()
    {
        iv_splash=findViewById(R.id.iv_splash)
        timer=Timer()
        timer.schedule(timerTask {

            val intent=Intent(this@SplashActivity,Walkthrough::class.java)
            startActivity(intent)
            finish()

        },3200)
    }
}
