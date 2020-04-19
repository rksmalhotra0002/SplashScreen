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
import com.alert.splashscreen.walkthrough.Walkthrough;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends AppCompatActivity {

@BindView(R.id.iv_splash)
ImageView iv_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

       setAnimation();

    }

    private void setAnimation()
    {

        Animation updown=AnimationUtils.loadAnimation(Splash.this,R.anim.updown);
        iv_splash.setAnimation(updown);

        timerforsplashscreen();

    }

    private void timerforsplashscreen()
    {

        View decorview=getWindow().getDecorView();
        int uioption=View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorview.setSystemUiVisibility(uioption);

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
