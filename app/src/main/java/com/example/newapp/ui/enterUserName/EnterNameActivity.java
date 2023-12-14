package com.example.newapp.ui.enterUserName;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newapp.R;
import com.example.newapp.network.ApiService;
import com.example.newapp.ui.pass.createNewPasswordActivity;
import com.example.newapp.utils.SharedPreferencesUtils;

public class EnterNameActivity extends AppCompatActivity {

    private EditText enterUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        enterUserName = findViewById(R.id.userNameInput);
        Button buttonDoctor = findViewById(R.id.buttonDoc);
        Button buttonParent = findViewById(R.id.buttonParent);

        buttonDoctor.setEnabled(false);
        buttonParent.setEnabled(false);

        enterUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonDoctor.setEnabled(charSequence.length() >= 3);
                buttonParent.setEnabled(charSequence.length() >= 3);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        buttonParent.setOnClickListener(v -> {
            String username = enterUserName.getText().toString();
            if (validateUsername(username)) {
                SharedPreferencesUtils.saveString(this, "username", enterUserName.getText().toString());
                SharedPreferencesUtils.saveString(this, "role", "parent");
                checkUserExistenceAndShowMessage();
                openNextActivity();
            } else {
                Toast.makeText(EnterNameActivity.this, "Введите корректное имя пользователя (минимум 3 символа)", Toast.LENGTH_SHORT).show();
            }
        });

        buttonDoctor.setOnClickListener(v -> {
            String username = enterUserName.getText().toString();
            if (validateUsername(username)) {
                SharedPreferencesUtils.saveString(this, "username", enterUserName.getText().toString());
                SharedPreferencesUtils.saveString(this, "role", "doctor");
                checkUserExistenceAndShowMessage();
                openNextActivity();
            } else {
                Toast.makeText(EnterNameActivity.this, "Введите корректное имя пользователя (минимум 3 символа)", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void checkUserExistenceAndShowMessage() {
        final String username = enterUserName.getText().toString();

        if (username.isEmpty()) {
            Toast.makeText(EnterNameActivity.this, "Введите имя пользователя", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!validateUsername(username)) {
            Toast.makeText(EnterNameActivity.this, "Введите корректное имя пользователя (минимум 3 символа)", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private void openNextActivity() {
        Intent intent = new Intent(EnterNameActivity.this, createNewPasswordActivity.class);
        startActivity(intent);
        finish();
    }

    private boolean validateUsername(String username) {
        return username.length() >= 3;
    }
}