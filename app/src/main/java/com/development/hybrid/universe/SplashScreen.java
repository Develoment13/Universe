package com.development.hybrid.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            Intent i = new Intent(SplashScreen.this, MainOptions.class);
            startActivity(i);
            finish();
        }, 2600);

    }
}