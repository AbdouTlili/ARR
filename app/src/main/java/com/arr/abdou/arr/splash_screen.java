package com.arr.abdou.arr;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final int dly = 7000;

        // setting animation speed

        LottieAnimationView animate = (LottieAnimationView) findViewById(R.id.animation);
        animate.setSpeed((float) 1.7);

        // creating a handler to make some delay off 'dly' seconds

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),log_in.class);
                startActivity(intent);
            }
        },dly);

    }
}
