package com.greymatter.goldpluscustomerapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.greymatter.goldpluscustomerapp.R;
import com.greymatter.goldpluscustomerapp.model.QuotationList;
import com.greymatter.goldpluscustomerapp.model.SelectedRingList;

import java.util.ArrayList;

public class SelectedRingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<SelectedRingList> selectedRingLists;

    public SelectedRingsAdapter(Activity activity, ArrayList<SelectedRingList> selectedRingLists) {
        this.activity = activity;
        this.selectedRingLists = selectedRingLists;
    }





    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rings_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, @SuppressLint("RecyclerView") int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final SelectedRingList selectedRingList = selectedRingLists.get(position);


       holder.tvWeight.setText(selectedRingList.getWeight());
       holder.tvSize.setText(selectedRingList.getSize());
       Glide.with(activity).load(selectedRingList.getRing_img()).placeholder(R.drawable.ring_pic).into(holder.imgRing);




    }


    @Override
    public int getItemCount() {
        return selectedRingLists.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        private TextView tvWeight,tvSize;
        private ImageView imgRing;
        private MaterialCardView cardView;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            imgRing = itemView.findViewById(R.id.imgRing);
            tvSize = itemView.findViewById(R.id.tvSize);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
