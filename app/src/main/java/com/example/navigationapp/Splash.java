package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 3000;
    Animation topAni, botonAni;
    ImageView img;
    TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Animacion
        topAni = AnimationUtils.loadAnimation(this, R.anim.top);
        botonAni = AnimationUtils.loadAnimation(this, R.anim.button);

        img = findViewById(R.id.imgLobo);
        logo = findViewById(R.id.textView);

        img.setAnimation(topAni);
        logo.setAnimation(botonAni);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN_DELAY);
    }
}