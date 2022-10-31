package com.greymatter.goldpluscustomerapp.adapter;

import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greymatter.goldpluscustomerapp.R;
import com.greymatter.goldpluscustomerapp.model.RingCategory;

import java.util.ArrayList;

public class RingsCategoryAdapter extends RecyclerView.Adapter<RingsCategoryAdapter.SingleViewHolder> {

    private Context context;
    private ArrayList<RingCategory> employees;
    // if checkedPosition = -1, there is no default selection
    // if checkedPosition = 0, 1st item is selected by default
    private int checkedPosition = 0;

    public RingsCategoryAdapter(Context context, ArrayList<RingCategory> employees) {
        this.context = context;
        this.employees = employees;
    }

    public void setEmployees(ArrayList<RingCategory> employees) {
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rings_category_layout, viewGroup, false);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder singleViewHolder, int position) {
        singleViewHolder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class SingleViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;
        private RelativeLayout rlCategory;

        SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            rlCategory = itemView.findViewById(R.id.rlCategory);
        }

        void bind(final RingCategory employee) {
            if (checkedPosition == -1) {
                imageView.setVisibility(View.GONE);
                rlCategory.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.category_bg));
                textView.setTextColor(Color.BLACK);
            } else {
                if (checkedPosition == getAdapterPosition()) {
                    imageView.setVisibility(View.VISIBLE);
                    textView.setTextColor(Color.WHITE);
                    rlCategory.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.category_onclick_bg));

                } else {
                    imageView.setVisibility(View.GONE);
                    textView.setTextColor(Color.BLACK);
                    rlCategory.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.category_bg));

                }
            }
            textView.setText(employee.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rlCategory.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.category_onclick_bg));
                    textView.setTextColor(Color.WHITE);
                    imageView.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()) {
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }
                }
            });
        }
    }

    public RingCategory getSelected() {
        if (checkedPosition != -1) {
            return employees.get(checkedPosition);
        }
        return null;
    }
}