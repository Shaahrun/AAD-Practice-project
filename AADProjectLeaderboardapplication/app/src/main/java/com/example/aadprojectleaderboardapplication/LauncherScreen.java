package com.example.aadprojectleaderboardapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class LauncherScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_screen);
        display();
    }

    private void display() {
        Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherScreen.this, MainActivity.class));
                finish();
            }
        }, 1500);
    }
}