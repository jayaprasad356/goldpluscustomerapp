package com.greymatter.goldpluscustomerapp.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.greymatter.goldpluscustomerapp.R;
import com.greymatter.goldpluscustomerapp.model.Rings;
import com.greymatter.goldpluscustomerapp.model.RingsCategory;

import java.util.ArrayList;


public class RingCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final Activity activity;
    final ArrayList<RingsCategory> ringsCategories;
    boolean check = false;



    public RingCategoryAdapter(Activity activity, ArrayList<RingsCategory> ringsCategories) {
        this.activity = activity;
        this.ringsCategories = ringsCategories;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rings_category_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final RingsCategory ringsCategory = ringsCategories.get(position);

        holder.tvCat_name.setText(ringsCategory.getCategory_name());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check){
                    check = false;

                    holder.rlCategory.setBackgroundResource(R.drawable.category_bg);
                    holder.tvCat_name.setTextColor(Color.BLACK);

                }

                else {
                    check = true;

                    holder.rlCategory.setBackgroundResource(R.drawable.category_onclick_bg);
                    holder.tvCat_name.setTextColor(Color.WHITE);




                }




            }
        });

    }

    @Override
    public int getItemCount() {
        return ringsCategories.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final TextView tvCat_name;
        final RelativeLayout rlCategory;


        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvCat_name = itemView.findViewById(R.id.tvCat_name);
            rlCategory = itemView.findViewById(R.id.rlCategory);


        }
    }
}

