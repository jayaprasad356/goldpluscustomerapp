package com.greymatter.goldpluscustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.greymatter.goldpluscustomerapp.adapter.RingListAdapter;
import com.greymatter.goldpluscustomerapp.adapter.RingsCategoryAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;
import com.greymatter.goldpluscustomerapp.model.RingCategory;
import com.greymatter.goldpluscustomerapp.model.RingList;

import java.util.ArrayList;

public class MainActivity<ItemClickListener> extends AppCompatActivity {

    RecyclerView recyclerview, categoryRecyclerview;
    private ArrayList<RingCategory> ringCategories = new ArrayList<>();
    private ArrayList<RingList> ringLists = new ArrayList<>();
    private RingsCategoryAdapter adapter;
    private RingListAdapter ringListAdapter;
    TextView tvItem_count,tvViewOder;

    Activity activity;
    Session session;

    Button btnProceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        session = new Session(activity);




        btnProceed = findViewById(R.id.btnProceed);
        tvItem_count = findViewById(R.id.tvItem_count);
        tvViewOder = findViewById(R.id.tvViewOder);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,ProceedActivity.class);
                startActivity(intent);
            }
        });
        tvViewOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,OdersActivity.class);
                startActivity(intent);
            }
        });


        recyclerview = findViewById(R.id.recyclerview);



        categoryRecyclerview = findViewById(R.id.categoryRecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        // recyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerview.setLayoutManager(linearLayoutManager);
        adapter = new RingsCategoryAdapter(this, ringCategories);
        categoryRecyclerview.setAdapter(adapter);






        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerview.setLayoutManager(gridLayoutManager);
        ringListAdapter = new RingListAdapter(this, ringLists);
        recyclerview.setAdapter(adapter);




        rings();
        categoryRings();







    }

    private void categoryRings() {









        ArrayList<RingCategory> ringsCategories = new ArrayList<>();
        RingCategory rings1 = new RingCategory("Bangles");
        RingCategory rings2 = new RingCategory("Rings");
        RingCategory rings3 = new RingCategory("Bangles");
        RingCategory rings4 = new RingCategory("Bangles");
        RingCategory rings5 = new RingCategory("Bangles");


        ringsCategories.add(rings1);
        ringsCategories.add(rings2);
        ringsCategories.add(rings3);
        ringsCategories.add(rings4);
        ringsCategories.add(rings5);


        adapter = new RingsCategoryAdapter(MainActivity.this,ringsCategories);
        categoryRecyclerview.setAdapter(adapter);

    }


    private void rings() {




        ArrayList<RingList> ringLists = new ArrayList<>();
        RingList rings1 = new RingList("","","1","1");
        RingList rings2 = new RingList("1","","22 g","25");
        RingList rings3 = new RingList("1","","22 g","25");
        RingList rings4 = new RingList("1","","22 g","25");
        RingList rings5 = new RingList("1","","22 g","25");

        ringLists.add(rings1);
        ringLists.add(rings2);
        ringLists.add(rings3);
        ringLists.add(rings4);
        ringLists.add(rings5);


        ringListAdapter = new RingListAdapter(this,ringLists);
        recyclerview.setAdapter(ringListAdapter);




    }






}