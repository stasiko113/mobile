package com.example.newapp.ui.editProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newapp.MainActivity;
import com.example.newapp.R;
import com.example.newapp.model.RegistrationModelWithEmail;
import com.example.newapp.model.RegistrationModelWithPhone;
import com.example.newapp.model.RegistrationResponse;
import com.example.newapp.model.UserModel;
import com.example.newapp.network.ApiService;
import com.example.newapp.ui.phoneInput.PhoneInputActivity;
import com.example.newapp.ui.profile.ProfileActivity;
import com.example.newapp.utils.SharedPreferencesUtils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileActivity extends AppCompatActivity {

    private static ApiService apiService;

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Spinner spinner = findViewById(R.id.spinner);
        TextInputEditText editUserName = findViewById(R.id.editUserName);
        TextInputEditText editName = findViewById(R.id.editName);
        ImageView imageView5 = findViewById(R.id.imageView5);


        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                name = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.your_values_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedValue = (String) parentView.getItemAtPosition(position);
                SharedPreferencesUtils.saveString(getApplicationContext(), "userType", selectedValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        String user_name = SharedPreferencesUtils.getString(this, "username", "");

        editUserName.setText(user_name);

        imageView5.setOnClickListener(v -> {

            String password = SharedPreferencesUtils.getString(this, "password", "");
            String phone = SharedPreferencesUtils.getString(this, "phoneNumber", "");
            String email = SharedPreferencesUtils.getString(this, "email", "");
            String imageUrl = SharedPreferencesUtils.getString(this, "phoneNumber", "");
            String role = SharedPreferencesUtils.getString(this, "role", "");
            String userType = SharedPreferencesUtils.getString(this, "userType", "");

            /*if (Objects.equals(email, "")) {
                authenticateUserWithPhone(name, user_name, password, phone, imageUrl, role, userType);
            } else {
                authenticateUserWithEmail(name, user_name, password, email, imageUrl, role, userType);
            }*/
            openNextActivity(ProfileActivity.class);
        });
    }

    private void authenticateUserWithPhone(String name, String username, String password, String phone, String imageUrl, String role, String userType) {
        RegistrationModelWithPhone authRequest = new RegistrationModelWithPhone(name, username, password, phone, imageUrl, role, userType);
        Call<RegistrationResponse> call = apiService.authenticate(authRequest);

        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponse> call, @NonNull Response<RegistrationResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegistrationResponse registrationResponse = response.body();

                    if (registrationResponse != null) {
                        UserModel user = registrationResponse.getUser();
                        SharedPreferencesUtils.saveInt(EditProfileActivity.this, "id", user.getId());
                        startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Неверные учетные данные", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Ошибка при отправке запроса", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponse> call, @NonNull Throwable t) {
                Toast.makeText(EditProfileActivity.this, "Ошибка при отправке запроса", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void authenticateUserWithEmail(String name, String username, String password, String email, String imageUrl, String role, String userType) {
        RegistrationModelWithEmail authRequest = new RegistrationModelWithEmail(name, username, password, email, imageUrl, role, userType);
        Call<RegistrationResponse> call = apiService.authenticate(authRequest);

        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(@NonNull Call<RegistrationResponse> call, @NonNull Response<RegistrationResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    RegistrationResponse registrationResponse = response.body();

                    if (registrationResponse != null) {
                        UserModel user = registrationResponse.getUser();
                        SharedPreferencesUtils.saveInt(EditProfileActivity.this, "id", user.getId());
                        startActivity(new Intent(EditProfileActivity.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(EditProfileActivity.this, "Неверные учетные данные", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditProfileActivity.this, "Ошибка при отправке запроса", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RegistrationResponse> call, @NonNull Throwable t) {
                Toast.makeText(EditProfileActivity.this, "Ошибка при отправке запроса", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openNextActivity(Class<?> targetActivity) {
        Intent intent = new Intent(EditProfileActivity.this, targetActivity);
        startActivity(intent);
        finish();
    }
}