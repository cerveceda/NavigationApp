package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sonidos extends AppCompatActivity {

    ImageButton btnAbeja, btnGato, btnElefante, btnKoala, btnLeon, btnPajaro, btnVaca, btnZorro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos);

        btnAbeja = findViewById(R.id.btnAbeja);
        btnGato =findViewById(R.id.btnGato);
        btnLeon = findViewById(R.id.btnLeon);

        btnGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Maullar();
            }
        });

        btnLeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rugido();
            }
        });
    }

    public void Maullar(){
        MediaPlayer mpGato = MediaPlayer.create(Sonidos.this, R.raw.miau);
        mpGato.start();
    }
    public void Rugido(){
        MediaPlayer mpLeon = MediaPlayer.create(Sonidos.this, R.raw.leon);
        mpLeon.start();
    }
}