package com.example.newapp.ui.profile;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class VisitDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        setContentView(R.layout.activity_visit_details);

        // Получите данные из Intent
        if (!getIntent().hasExtra("visitId")) {
            Bundle extras = getIntent().getExtras();
            String visitDate = String.valueOf(extras.getLong("visitDate"));
            String visitReason = extras.getString("visitReason");
            String visitAddress = extras.getString("visitAddress");
            int doctorId = getIntent().getIntExtra("doctorId", 0);
            String doctorName = extras.getString("doctorName");
            String doctorSpecialization = extras.getString("doctorSpecialization");

            if (visitDate != null) {
                initializeData(visitDate, doctorName, visitReason, visitAddress, doctorSpecialization);
            }
        }
    }

    private void initializeData(String visitDate, String visitDoctorName, String reason, String address, String specialization) {
        try {
            long timestamp = Long.parseLong(visitDate);
            Date date = new Date(timestamp);

            SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault());

            String formattedDate = outputFormat.format(date);

            TextView textViewVisitDateDetails = findViewById(R.id.textViewVisitDateDetails);
            TextView textViewDoctorNameDetails = findViewById(R.id.textViewDoctorNameDetails);
            TextView textViewVisitAddressDetails = findViewById(R.id.textViewAddressDetails);
            TextView textViewReasonDetails = findViewById(R.id.textViewReasonDetails);
            TextView textViewDoctorSpecialization = findViewById(R.id.textViewDoctorSpecialization);

            textViewVisitDateDetails.setText("Дата: " + formattedDate);
            textViewDoctorNameDetails.setText("Врач: " + visitDoctorName);
            textViewVisitAddressDetails.setText("Адресс: " + address);
            textViewReasonDetails.setText("Причина: " + reason);
            textViewDoctorSpecialization.setText("Специализация: " + reason);

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
