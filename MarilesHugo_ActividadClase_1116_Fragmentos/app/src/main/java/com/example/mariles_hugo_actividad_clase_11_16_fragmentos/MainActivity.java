package com.example.mariles_hugo_actividad_clase_11_16_fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button buttonA, buttonB;
    public Fragment fragA, fragB;

    public boolean flagA = true, flagB = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                Fragment fragA = manager.findFragmentById(R.id.fragmentA);
                        if (flagA) {
                            ft.hide(fragA);
                            ft.commit();
                            flagA = false;
                        } else {
                            ft.show(fragA);
                            ft.commit();
                            flagA = true;
                        }
                    }
                });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                Fragment fragB = manager.findFragmentById(R.id.fragmentB);
                if (flagB) {
                    ft.hide(fragB);
                    ft.commit();
                    flagB = false;
                } else {
                    ft.show(fragB);
                    ft.commit();
                    flagB = true;
                }
            }
        });
    }
}