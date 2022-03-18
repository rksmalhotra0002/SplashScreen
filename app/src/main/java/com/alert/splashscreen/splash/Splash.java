package com.alert.splashscreen.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.alert.splashscreen.R;
import com.alert.splashscreen.databinding.ActivityMainBinding;
import com.alert.splashscreen.walkthrough.Walkthrough;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        view = activityMainBinding.getRoot();
        setContentView(view);

        setAnimation();
        setFullScreenCode();
        setTimerForSplashScreen();
    }

    private void setAnimation() {

        try {
            //Animation
            Animation updown = AnimationUtils.loadAnimation(Splash.this, R.anim.updown);
            activityMainBinding.ivSplash.setAnimation(updown);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void setFullScreenCode()
    {
        try {
            //fullscreen
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTimerForSplashScreen() {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                try {

                    Intent intent = new Intent(Splash.this, Walkthrough.class);
                    startActivity(intent);
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }, 3500);
    }
}
