package com.alert.splashscreen.splashkotlin
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
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
        setTimerSplashScreen()
    }

    private fun setAnimation()
    {
        try{

            //Animation
            val animation = AnimationUtils.loadAnimation(this@SplashActivity, R.anim.downtoup)
            activitySplashBinding.ivSplashkotlin.animation=animation

        }catch (e:Exception)
        {
            e.printStackTrace()
        }
    }


    private fun setTimerSplashScreen()
    {
        try {

            //fullscreen
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        }catch (e:Exception)
        {
            e.printStackTrace()
        }

        timer= Timer()
        timer.schedule(timerTask {
            try {

                val intent=Intent(this@SplashActivity,Walkthrough::class.java)
                startActivity(intent)
                finish()

            }catch (e:Exception)
            {
                e.printStackTrace()
            }


        },3500)
    }
}
