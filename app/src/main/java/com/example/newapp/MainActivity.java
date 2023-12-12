package com.example.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.newapp.ui.authorization.AuthorizationActivity;
import com.example.newapp.ui.enterUserName.EnterNameActivity;
import com.example.newapp.ui.pass.createNewPasswordActivity;
import com.example.newapp.ui.splashScreen.SplashActivity;
import com.example.newapp.utils.SharedPreferencesUtils;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.newapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final long SPLASH_DELAY = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // activity splash


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, AuthorizationActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);

    }
}