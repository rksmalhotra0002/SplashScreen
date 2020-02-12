package com.alert.splashscreen.splashkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.alert.splashscreen.R
import com.alert.splashscreen.walkthrough.Walkthrough
import java.util.*
import kotlin.concurrent.timerTask


class SplashActivity : AppCompatActivity() {

@BindView(R.id.iv_splash)
val iv_splash:ImageView?=null

private lateinit var timer: Timer
private lateinit var decorview:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       ButterKnife.bind(this)

        setTimerforsplashscreen()
    }

    private fun setTimerforsplashscreen()
    {
        decorview=window.decorView
       val uioption=View.SYSTEM_UI_FLAG_FULLSCREEN
        decorview.systemUiVisibility=uioption


        timer=Timer()
        timer.schedule(timerTask {

            val intent=Intent(this@SplashActivity, Walkthrough::class.java)
            startActivity(intent)
            finish()

        },2500)
    }
}

