package com.example.newapp.ui.phoneInput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newapp.R;
import com.example.newapp.ui.finishRegistration.FinishRestrationActivity;
import com.example.newapp.ui.emailInput.emailInputActivity;
import com.example.newapp.utils.SharedPreferencesUtils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class PhoneInputActivity extends AppCompatActivity {

    private TextInputEditText editTextPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_input);
        TextView textViewEmail = findViewById(R.id.textViewNumber);
        Button buttonNextPhone = findViewById(R.id.buttonNextPhone);
        textViewEmail.setOnClickListener(v -> openNextActivity(emailInputActivity.class));

        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        ImageView imageViewClear = findViewById(R.id.imageViewClear);

        imageViewClear.setOnClickListener(view -> Objects.requireNonNull(editTextPhoneNumber.getText()).clear());


        buttonNextPhone.setOnClickListener(v -> {
            String phoneNumber = Objects.requireNonNull(editTextPhoneNumber.getText()).toString().trim();
            SharedPreferencesUtils.saveString(this, "phoneNumber", phoneNumber);
            openNextActivity(FinishRestrationActivity.class);
        });
    }

    private void openNextActivity(Class<?> targetActivity) {
        Intent intent = new Intent(PhoneInputActivity.this, targetActivity);
        startActivity(intent);
        finish();
    }
}