package com.rulo.themoviedbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.rulo.themoviedbapp.login.view.LoginView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSplashScreen();
    }

    private void initSplashScreen() {
        final Handler handler = new Handler();
        handler.postDelayed(() -> { Intent navegar = new Intent(
                            getBaseContext(), LoginView.class);
                    startActivity(navegar);
                    finish();
                }
                , 3000
        );
    }

}