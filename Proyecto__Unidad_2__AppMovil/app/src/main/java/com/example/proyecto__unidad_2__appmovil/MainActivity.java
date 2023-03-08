package com.example.proyecto__unidad_2__appmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.proyecto__unidad_2__appmovil.menu_3_barras.menu_3_barras_activity;

public class MainActivity extends AppCompatActivity {

    public ImageButton btn_menu_3_barras;

    MediaPlayer sound_menu_3_barras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Log.i("Proyecto-App_Movil", "Unidad 4");
        Log.w("Proyecto-App_Movil", "WARNING");

        btn_menu_3_barras = findViewById(R.id.button_menu_3_barras);

        //sound_menu_3_barras = MediaPlayer.create(this, R.raw.notification);

        btn_menu_3_barras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(), menu_3_barras_activity.class);
                //view.getContext().startActivity(intent);

                Intent submitIntent = new Intent(MainActivity.this, menu_3_barras_activity.class);
                startActivity(submitIntent);

                sound_menu_3_barras.seekTo(0);
                sound_menu_3_barras.start();
            }
        });
    }

    @Override
    protected void onPause () {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_LONG).show();
    }
}