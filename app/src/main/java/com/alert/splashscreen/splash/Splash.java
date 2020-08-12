package com.alert.splashscreen.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.alert.splashscreen.R;
import com.alert.splashscreen.databinding.ActivityMainBinding;
import com.alert.splashscreen.walkthrough.Walkthrough;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends AppCompatActivity {

private ActivityMainBinding activityMainBinding;

private  View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        view=activityMainBinding.getRoot();
         setContentView(view);

       setAnimation();

    }

    private void setAnimation()
    {

        Animation updown=AnimationUtils.loadAnimation(Splash.this,R.anim.updown);
        activityMainBinding.ivSplash.setAnimation(updown);

        timerforSplashScreen();

    }

    private void timerforSplashScreen()
    {
     //fullscreen
        view=getWindow().getDecorView();
        int uioption=View.SYSTEM_UI_FLAG_FULLSCREEN;
        view.setSystemUiVisibility(uioption);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

         Intent intent=new Intent(Splash.this,Walkthrough.class);
         startActivity(intent);
          finish();

      }
    },3500);
    }
}
