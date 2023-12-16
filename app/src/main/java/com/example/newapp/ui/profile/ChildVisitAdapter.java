package com.example.newapp.ui.profile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newapp.R;
import com.example.newapp.model.VisitToDoctorModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChildVisitAdapter extends RecyclerView.Adapter<ChildVisitAdapter.VisitViewHolder> {

    private List<VisitToDoctorModel> visitList;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
    private OnItemClickListener onItemClickListener;

    public ChildVisitAdapter(List<VisitToDoctorModel> visitList, OnItemClickListener onItemClickListener) {
        this.visitList = visitList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public VisitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visit, parent, false);
        return new VisitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitViewHolder holder, int position) {
        if (visitList != null && !visitList.isEmpty()) {
            VisitToDoctorModel visit = visitList.get(position);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault());
            holder.textViewVisitDate.setText(dateFormat.format(new Date(visit.getDate())));
            holder.textViewDoctorName.setText(visit.getDoctor().getUser().getName());

            holder.itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), VisitDetailsActivity.class);
                intent.putExtra("visitDate", visit.getDate());
                intent.putExtra("doctorName", visit.getDoctor().getUser().getName());
                intent.putExtra("visitAddress", visit.getAddress());
                intent.putExtra("visitReason", visit.getReason());
                view.getContext().startActivity(intent);
            });
        } else {
            holder.textViewVisitDate.setText("У вас нет детей");
        }
    }

    @Override
    public int getItemCount() {
        return visitList != null && !visitList.isEmpty() ? visitList.size() : 1;
    }

    public static class VisitViewHolder extends RecyclerView.ViewHolder {
        TextView textViewVisitDate;
        TextView textViewDoctorName;

        public VisitViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewVisitDate = itemView.findViewById(R.id.textViewVisitDate);
            textViewDoctorName = itemView.findViewById(R.id.textViewDoctorName);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(VisitToDoctorModel visit);
    }
}

