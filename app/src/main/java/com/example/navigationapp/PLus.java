package com.example.navigationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PLus extends AppCompatActivity {

    VideoView vdIsrael;
    MediaController mediaController;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_lus);

        vdIsrael = (VideoView) findViewById(R.id.vdIsrael);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.israelcom;
        vdIsrael.setVideoURI(Uri.parse(path));
        vdIsrael.start();

        if(this.mediaController==null){
            this.mediaController = new MediaController(PLus.this);
            this.mediaController.setAnchorView(vdIsrael);
            this.vdIsrael.setMediaController(mediaController);
        }

        this.vdIsrael.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                vdIsrael.seekTo(position);
                if(position==0){
                    vdIsrael.start();
                }
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(vdIsrael);
                    }
                });
            }
        });
    }
}