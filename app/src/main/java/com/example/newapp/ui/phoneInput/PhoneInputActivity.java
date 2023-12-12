package com.example.newapp.ui.phoneInput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newapp.R;
import com.example.newapp.ui.emailInput.emailInputActivity;
import com.example.newapp.utils.SharedPreferencesUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

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

        String phoneNumber = Objects.requireNonNull(editTextPhoneNumber.getText()).toString().trim();

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        buttonNextPhone.setOnClickListener(v -> {
            openNextActivity(emailInputActivity.class);
            SharedPreferencesUtils.saveString(this, "email", Objects.requireNonNull(editTextPhoneNumber.getText()).toString());
        });
        try {
            Phonenumber.PhoneNumber parsedPhoneNumber = phoneNumberUtil.parse(phoneNumber, "BEL");
            boolean isValid = phoneNumberUtil.isValidNumber(parsedPhoneNumber);

            if (isValid) {
                String formattedPhoneNumber = phoneNumberUtil.format(parsedPhoneNumber, PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL);
                // Используйте formattedPhoneNumber по вашему усмотрению
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openNextActivity(Class<?> targetActivity) {
        Intent intent = new Intent(PhoneInputActivity.this, targetActivity);
        startActivity(intent);
        finish();
    }
}