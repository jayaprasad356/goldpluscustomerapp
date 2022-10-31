package com.greymatter.goldpluscustomerapp.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.greymatter.goldpluscustomerapp.R;
import com.greymatter.goldpluscustomerapp.model.RingList;

import java.util.ArrayList;

public class RingListAdapter extends RecyclerView.Adapter<RingListAdapter.MultiViewHolder> {

    private Context context;
    private ArrayList<RingList> employees;

    public RingListAdapter(Context context, ArrayList<RingList> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<RingList> employees) {
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MultiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rings_layout, viewGroup, false);
        return new MultiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiViewHolder multiViewHolder, int position) {
        multiViewHolder.bind(employees.get(position));

    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class MultiViewHolder extends RecyclerView.ViewHolder {

        private TextView tvWeight,tvSize;
        private ImageView imgRing;
        private MaterialCardView cardView;

        MultiViewHolder(@NonNull View itemView) {
            super(itemView);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            imgRing = itemView.findViewById(R.id.imgRing);
            tvSize = itemView.findViewById(R.id.tvSize);
            cardView = itemView.findViewById(R.id.card);
        }

        void bind(final RingList employee) {
          //  imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
            cardView.setStrokeWidth(employee.isChecked() ? 15 : 4);
            tvWeight.setText(employee.getWeight());
            tvSize.setText(employee.getSize());
            Glide.with(context).load(employee.getRing_img()).placeholder(R.drawable.ring_pic).into(imgRing);






            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    employee.setChecked(!employee.isChecked());
                   // imageView.setVisibility(employee.isChecked() ? View.VISIBLE : View.GONE);
                    cardView.setStrokeWidth(employee.isChecked() ? 15 : 4);

                }
            });
        }
    }

    public ArrayList<RingList> getAll() {
        return employees;
    }

    public ArrayList<RingList> getSelected() {
        ArrayList<RingList> selected = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).isChecked()) {
                selected.add(employees.get(i));
            }
        }
        return selected;
    }
}