package com.example.newapp.ui.emailInput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newapp.R;
import com.example.newapp.ui.phoneInput.PhoneInputActivity;
import com.example.newapp.utils.SharedPreferencesUtils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class emailInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_input);

        TextView textViewNumber = findViewById(R.id.textViewNumber);
        Button buttonNextEmail = findViewById(R.id.buttonNextEmail);
        TextInputEditText editEmail = findViewById(R.id.editEmail);
        ImageView imageViewClear = findViewById(R.id.imageViewClear);


        textViewNumber.setOnClickListener(v -> openNextActivity(PhoneInputActivity.class));
        buttonNextEmail.setOnClickListener(v -> {
            openNextActivity(emailInputActivity.class);
            SharedPreferencesUtils.saveString(this, "email", Objects.requireNonNull(editEmail.getText()).toString());
        });

        imageViewClear.setOnClickListener(view -> Objects.requireNonNull(editEmail.getText()).clear());
    }

    private void openNextActivity(Class<?> targetActivity) {
        Intent intent = new Intent(emailInputActivity.this, targetActivity);
        startActivity(intent);
        finish();
    }
}