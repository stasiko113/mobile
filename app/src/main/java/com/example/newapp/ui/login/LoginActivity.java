package com.example.newapp.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapp.R;
import com.example.newapp.model.AuthRequest;
import com.example.newapp.model.LoginResponse;
import com.example.newapp.model.UserModel;
import com.example.newapp.network.ApiClient;
import com.example.newapp.network.ApiService;
import com.example.newapp.ui.profile.ProfileActivity;
import com.example.newapp.utils.SharedPreferencesUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUserName;
    private EditText editTextPassword;

    private static ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiService = ApiClient.getApiService();

        TextView textView = findViewById(R.id.textViewLogin);
        String fullText = "Забыли логин или пароль? Получить помощь со входом в систему.";
        int startIndexSecondPart = fullText.indexOf("Получить помощь");
        int endIndexSecondPart = fullText.length();

        SpannableString spannableString = new SpannableString(fullText);

        spannableString.setSpan(new ForegroundColorSpan(Color.GRAY), 0, startIndexSecondPart, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        int colorBlue = Color.parseColor("#557BFD");
        spannableString.setSpan(new ForegroundColorSpan(colorBlue), startIndexSecondPart, endIndexSecondPart, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);

        editTextUserName = findViewById(R.id.userNameLogin);
        editTextPassword = findViewById(R.id.passwordLogin);
        Button loginButton = findViewById(R.id.buttonNext);

        apiService = ApiClient.getApiService();
        loginButton.setOnClickListener(v -> {
            if (isEditTextEmpty(editTextUserName) || isEditTextEmpty(editTextPassword)) {
                Toast.makeText(LoginActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            } else {
                authenticateUser(editTextUserName.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }

    private boolean isEditTextEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    private void authenticateUser(String username, String password) {
        apiService = ApiClient.getApiService();
        try {
            AuthRequest authRequest = new AuthRequest(username, password);
            Call<LoginResponse> call = apiService.authenticate(authRequest);

            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                    try {
                        if (response.isSuccessful() && response.body() != null) {
                            LoginResponse loginResponse = response.body();

                            UserModel user = loginResponse.getUser();
                            SharedPreferencesUtils.saveInt(LoginActivity.this, "id", user.getId());
                            startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Ошибка при отправке запроса", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Log.e("ApiService", "Request failed: " + e.getMessage());
                        e.printStackTrace();
                        Log.e("YourActivity", "Error during login: " + e.getMessage());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                    Toast.makeText(LoginActivity.this, "Ошибка при отправке запроса", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            Log.e("string", "string");
        }
    }
}