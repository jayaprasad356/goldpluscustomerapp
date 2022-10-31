package com.greymatter.goldpluscustomerapp.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.greymatter.goldpluscustomerapp.QuotationActivity;
import com.greymatter.goldpluscustomerapp.R;
import com.greymatter.goldpluscustomerapp.model.QuotationList;
import com.greymatter.goldpluscustomerapp.model.RingList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuotationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final Activity activity;
    ArrayList<QuotationList> quotationLists;

    public QuotationAdapter(Activity activity, ArrayList<QuotationList> quotationLists) {
        this.activity = activity;
        this.quotationLists = quotationLists;
    }





    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.quotation_layout, parent, false);
        return new ExploreItemHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holderParent, @SuppressLint("RecyclerView") int position) {
        final ExploreItemHolder holder = (ExploreItemHolder) holderParent;
        final QuotationList quotationList = quotationLists.get(position);

     //   Glide.with(activity).load(quotationList.getImage()).placeholder(R.drawable.logo).into(holder.imgProduct);
        holder.tvItem_count.setText(quotationList.getPieces());
        holder.tvSub_category.setText(quotationList.getSub_category());
        holder.tvGrossWeight.setText(quotationList.getGross_weight());
        holder.tvPurity.setText(quotationList.getPurity());
        holder.tvTouch.setText(quotationList.getTouch());


    }


    @Override
    public int getItemCount() {
        return quotationLists.size();
    }

    static class ExploreItemHolder extends RecyclerView.ViewHolder {

        final TextView tvItem_count ,tvSub_category,tvGrossWeight,tvTouch,tvPurity;
        public ExploreItemHolder(@NonNull View itemView) {
            super(itemView);
            tvItem_count = itemView.findViewById(R.id.tvItem_count);
            tvSub_category = itemView.findViewById(R.id.tvSub_category);
            tvGrossWeight = itemView.findViewById(R.id.tvGrossWeight);
            tvTouch = itemView.findViewById(R.id.tvTouch);
            tvPurity = itemView.findViewById(R.id.tvPurity);
        }
    }
}
