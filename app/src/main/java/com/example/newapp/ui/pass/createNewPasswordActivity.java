package com.example.newapp.ui.pass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.newapp.MainActivity;
import com.example.newapp.R;
import com.example.newapp.ui.phoneInput.PhoneInputActivity;
import com.example.newapp.utils.SharedPreferencesUtils;

public class createNewPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password);
        EditText editText = findViewById(R.id.passwordInput);
        CheckBox checkBoxRememberPassword = findViewById(R.id.checkBoxRememberPassword);
        Button button = findViewById(R.id.buttonSendPassword);

        button.setClickable(false);
        button.setBackgroundColor(getResources().getColor(R.color.button_disabled_color));

        checkBoxRememberPassword.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                String password = editText.getText().toString();
                SharedPreferencesUtils.saveString(createNewPasswordActivity.this, "password", password);
            }
        });

        button.setOnClickListener(v -> {
            String password = editText.getText().toString();
            openNextActivity();
            SharedPreferencesUtils.saveString(createNewPasswordActivity.this, "password", password);
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 6) {
                    button.setClickable(true);
                    button.setBackgroundColor(getResources().getColor(R.color.purple_500));
                } else {
                    button.setClickable(false);
                    button.setBackgroundColor(getResources().getColor(R.color.button_disabled_color));
                }
                SharedPreferencesUtils.saveString(createNewPasswordActivity.this, "password", editable.toString());
            }
        });
    }

    private void openNextActivity() {
        Intent intent = new Intent(createNewPasswordActivity.this, PhoneInputActivity.class);
        startActivity(intent);
        finish();
    }
}
