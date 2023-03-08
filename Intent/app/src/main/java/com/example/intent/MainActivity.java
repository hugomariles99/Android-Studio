package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button submit_button, browser_button, extra_button;
    EditText firstName, lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final Button submitButton = (Button) findViewById(R.id.submit_button);
        final Button browserButton = (Button) findViewById(R.id.browser_button);
        final Button extraButton = (Button) findViewById(R.id.extra_button);

        LinearLayout linearLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstName = (EditText) findViewById(R.id.first_name_text);
                EditText lastName = (EditText) findViewById(R.id.last_name_text);
                String firstNameString = firstName.getText().toString();
                String lastNameString = lastName.getText().toString();
                Intent submitIntent = new Intent(MainActivity.this, ShowActivity.class);
                submitIntent.putExtra("firstNameString", firstNameString);
                submitIntent.putExtra("lastNameString", lastNameString);
                startActivity(submitIntent);
            }
        });

        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.itcj.edu.mx/"));
                startActivity(intent);
            }
        });

        extraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String random = randomWebsite();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(random));
                startActivity(intent);
            }
        });
    }

    public String randomWebsite() {
        String website = "";
        Random ran = new Random();
        int num = ran.nextInt(6);
        switch (num) {
            case 0:
                website = "http://www.youtube.com/";
                break;
            case 1:
                website = "http://www.google.com/";
                break;
            case 2:
                website = "http://www.facebook.com/";
                break;
            case 3:
                website = "http://www.wikipedia.org/";
                break;
            case 4:
                website = "http://www.amazon.com/";
                break;
            case 5:
                website = "http://www.instagram.com/";
                break;
            default:
                website = "http://www.itcj.edu.mx/";
                break;
        }
        return website;
    }
}