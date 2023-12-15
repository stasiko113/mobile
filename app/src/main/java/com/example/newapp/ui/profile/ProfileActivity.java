package com.example.newapp.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.R;
import com.example.newapp.model.ChildModel;
import com.example.newapp.model.LoginResponse;
import com.example.newapp.model.UserModel;
import com.example.newapp.model.VisitToDoctorModel;
import com.example.newapp.network.ApiClient;
import com.example.newapp.network.ApiService;
import com.example.newapp.ui.home.HomeActivity;
import com.example.newapp.utils.SharedPreferencesUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewNameStr;

    private RecyclerView recyclerViewChildren;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textViewName = findViewById(R.id.textViewName);
        textViewNameStr = findViewById(R.id.textViewNameStr);
        ImageView imageViewProfile = findViewById(R.id.imageViewProfile);


        ApiService apiService = ApiClient.getApiService();


        recyclerViewChildren = findViewById(R.id.recyclerViewChildren);
        recyclerViewChildren.setLayoutManager(new LinearLayoutManager(this));

        int userId = SharedPreferencesUtils.getInt(ProfileActivity.this, "id");

        Call<UserModel> call = apiService.getUserData(userId);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NonNull Call<UserModel> call, @NonNull Response<UserModel> response) {
                if (response.isSuccessful()) {
                    UserModel userModel = response.body();
                    if (userModel != null) {
                        String imageUrl = userModel.getImageUrl();
                        Picasso.get().load(imageUrl).into(imageViewProfile);
                        String name = userModel.getName();
                        textViewName.setText(name);
                        String username = userModel.getUsername();
                        String phone = userModel.getPhone();
                        String strToText = phone + " " + "@" + username;
                        textViewNameStr.setText(strToText);

                        List<ChildModel> childList = userModel.getChilds();
                        if (childList != null && !childList.isEmpty()) {
                            List<VisitToDoctorModel> visitList = userModel.getChilds().get(0).getVisitToDoctors();
                            if (visitList != null && !visitList.isEmpty()) {
                                // Есть визиты к врачу
                                ChildVisitAdapter childVisitAdapter = new ChildVisitAdapter(
                                        visitList,
                                        visit -> {
                                            Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                                            intent.putExtra("visit", (CharSequence) visit);
                                            startActivity(intent);
                                        });
                                recyclerViewChildren.setAdapter(childVisitAdapter);
                            } else {
                                // Нет визитов к врачу для первого ребенка
                                TextView noChildrenMessage = findViewById(R.id.noChildrenMessage);
                                noChildrenMessage.setVisibility(View.VISIBLE);
                                noChildrenMessage.setText("У вашего ребенка нет визитов к врачу");
                                recyclerViewChildren.setVisibility(View.GONE);
                            }
                        } else {
                            // Нет детей вообще
                            TextView noChildrenMessage = findViewById(R.id.noChildrenMessage);
                            noChildrenMessage.setVisibility(View.VISIBLE);
                            noChildrenMessage.setText("У вас нет детей");
                            recyclerViewChildren.setVisibility(View.GONE);
                        }

                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserModel> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
