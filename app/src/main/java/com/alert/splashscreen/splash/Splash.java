package com.alert.splashscreen.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.alert.splashscreen.R;
import com.alert.splashscreen.Walkthrough;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Splash extends AppCompatActivity {

@BindView(R.id.iv_splashimage)
ImageView iv_splashimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getids();
    }

    private void getids()
    {

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this, Walkthrough.class);
                startActivity(intent);
                finish();
            }
        },3200);
    }
}
