package com.alert.splashscreen.splashkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.alert.splashscreen.R
import com.alert.splashscreen.databinding.ActivitySplashBinding
import com.alert.splashscreen.walkthrough.Walkthrough
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

private lateinit var activitySplashBinding: ActivitySplashBinding

private lateinit var timer: Timer

private lateinit var decorview:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitySplashBinding= ActivitySplashBinding.inflate(layoutInflater)
        decorview=activitySplashBinding.root
        setContentView(decorview)

        setAnimation()

    }

    private fun setAnimation()
    {
      //Animation
       val animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.downtoup)
        activitySplashBinding.ivSplashkotlin.animation=animation

        settimersplashscreen()

    }

    private fun settimersplashscreen()
    {

   //fullscreen
       decorview=window.decorView
        val uioption=View.SYSTEM_UI_FLAG_FULLSCREEN
        decorview.systemUiVisibility=uioption

        timer= Timer()
        timer.schedule(timerTask {

            val intent=Intent(this@SplashActivity,Walkthrough::class.java)
            startActivity(intent)
            finish()

        },3500)
    }
}
