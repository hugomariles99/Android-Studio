package com.example.musica;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    MediaPlayer mplayer1, mplayer2, mplayer3, mplayer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        mplayer1 = MediaPlayer.create(this, R.raw.risa1);
        mplayer2 = MediaPlayer.create(this, R.raw.risa2);
        mplayer3 = MediaPlayer.create(this, R.raw.aplausos);
        mplayer4 = MediaPlayer.create(this, R.raw.motivacion);

        btn1.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View view){
                mplayer1.seekTo(0);
                mplayer1.start();
        }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mplayer2.seekTo(0);
                mplayer2.start();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mplayer3.seekTo(0);
                mplayer3.start();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                /*
                if(mplayer4 !=null){
                    mplayer4.release();
                }
                */
                mplayer4.seekTo(0);
                mplayer4.start();
            }
        });
    }
}