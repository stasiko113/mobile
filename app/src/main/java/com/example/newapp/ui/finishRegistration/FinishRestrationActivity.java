package com.example.newapp.ui.finishRegistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.newapp.R;
import com.example.newapp.ui.editProfile.EditProfileActivity;
import com.example.newapp.utils.SharedPreferencesUtils;

public class FinishRestrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_restration);

        TextView textViewFinishRegistration = findViewById(R.id.finishRegistration);

        String user_name = SharedPreferencesUtils.getString(this, "username", "");
        String textFinished = user_name + ", добро пожаловать в ТОТ!";

        Button buttonFinishedRegistration = findViewById(R.id.buttonFinishedRegistration);

        textViewFinishRegistration.setText(textFinished.toUpperCase());

        buttonFinishedRegistration.setOnClickListener(v -> openNextActivity());

    }
    private void openNextActivity() {
        Intent intent = new Intent(FinishRestrationActivity.this, EditProfileActivity.class);
        startActivity(intent);
        finish();
    }
}