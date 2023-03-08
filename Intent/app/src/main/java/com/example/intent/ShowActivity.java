package com.example.intent;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    TextView showFirstName, showLastName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        getSupportActionBar().hide();

        LinearLayout linearLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        Bundle extras = getIntent().getExtras();
        String inputFirstName = extras.getString("firstNameString");
        String inputLastName = extras.getString("lastNameString");
        TextView showFirstName = (TextView) findViewById(R.id.show_first_name);
        TextView showLastName = (TextView) findViewById(R.id.show_last_name);
        showFirstName.setText(inputFirstName);
        showLastName.setText(inputLastName);
    }
}