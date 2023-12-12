package com.example.newapp.ui.authorization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import com.example.newapp.R;
import com.example.newapp.ui.enterUserName.EnterNameActivity;
import com.example.newapp.ui.login.LoginActivity;

public class AuthorizationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        Button buttonRegistration = findViewById(R.id.buttonRegistration);

        buttonRegistration.setOnClickListener(v -> {
            Intent intent = new Intent(this, EnterNameActivity.class);
            startActivity(intent);
        });
        Button buttonEnter = findViewById(R.id.buttonEnter);
        buttonEnter.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });
    }
}