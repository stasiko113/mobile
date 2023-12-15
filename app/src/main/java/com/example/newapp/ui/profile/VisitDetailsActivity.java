package com.example.newapp.ui.profile;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapp.R;
import com.example.newapp.model.VisitToDoctorModel;

public class VisitDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setContentView(R.layout.activity_visit_details);

        // Получите данные из Intent
        if (getIntent().hasExtra("visit")) {
            VisitToDoctorModel visit = getIntent().getParcelableExtra("visit");

            if (visit != null) {
                initializeData(visit);
            }
        }
    }

    private void initializeData(VisitToDoctorModel visit) {
        TextView textViewVisitDateDetails = findViewById(R.id.textViewVisitDateDetails);
        TextView textViewDoctorNameDetails = findViewById(R.id.textViewDoctorNameDetails);

        // Пример заполнения данных
        textViewVisitDateDetails.setText("Дата: " + visit.getDate());
        textViewDoctorNameDetails.setText("Врач: " + visit.getDoctor().getUser().getName());
        // Добавьте остальные данные, если необходимо
    }
}
