package com.greymatter.goldpluscustomerapp.adapter;

import android.app.Activity;
import android.content.Intent;
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
import com.greymatter.goldpluscustomerapp.helper.Constant;
import com.greymatter.goldpluscustomerapp.model.Rings;

import java.util.ArrayList;


public class RingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final Activity activity;
    final ArrayList<Rings> rings;


    public RingAdapter(Activity activity, ArrayList<Rings> rings) {
        this.activity = activity;
        this.rings = rings;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rings_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final Rings rings1 = rings.get(position);

        Glide.with(activity).load(rings1.getRing_img()).placeholder(R.drawable.ring_pic).into(holder.imgRing);
        holder.tvSize.setText(rings1.getSize());
        holder.tvWeight.setText(rings1.getWeight());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.card.setStrokeWidth(15);


                //                  Intent intent = new Intent(activity, MoiReceiveActivity.class);
//                    intent.putExtra(Constant.FUNCTIONID,functions1.getId());
//                    intent.putExtra(Constant.FUNCTIONAME,functions1.getFunction_name());
//                    activity.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return rings.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final ImageView imgRing;
        final TextView tvSize,tvWeight;
        final MaterialCardView card;

        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            imgRing = itemView.findViewById(R.id.imgRing);
            tvSize = itemView.findViewById(R.id.tvSize);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            card = itemView.findViewById(R.id.card);

        }
    }
}

