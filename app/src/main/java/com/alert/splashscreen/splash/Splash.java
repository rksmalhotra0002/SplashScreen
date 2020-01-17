package com.alert.splashscreen.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.alert.splashscreen.R;
import com.alert.splashscreen.Walkthrough;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getids(); //calling a method
    }

    private void getids()
    {
        ImageView iv_splashimage=findViewById(R.id.iv_splashimage);
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
