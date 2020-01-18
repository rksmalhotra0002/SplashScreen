package com.alert.splashscreen.splashkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.alert.splashscreen.R
import com.alert.splashscreen.Walkthrough
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {
@BindView(R.id.iv_splash)
var iv_splashimage: ImageView? = null

private lateinit var timer: Timer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ButterKnife.bind(this)
       getids()
    }

    private fun getids()
    {
        timer=Timer()
        timer.schedule(timerTask {

            val intent=Intent(this@SplashActivity,Walkthrough::class.java)
            startActivity(intent)
            finish()

        },3200)
    }
}
