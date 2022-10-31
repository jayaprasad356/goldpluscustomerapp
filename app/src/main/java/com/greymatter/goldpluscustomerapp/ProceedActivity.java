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

import com.greymatter.goldpluscustomerapp.adapter.RingListAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;
import com.greymatter.goldpluscustomerapp.model.RingList;

import java.util.ArrayList;

public class ProceedActivity extends AppCompatActivity {

    RecyclerView recyclerview, categoryRecyclerview;
    RingListAdapter ringListAdapter;
    Activity activity;
    Session session;
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed);


        activity = this;
        session = new Session(activity);



        btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,QuotationActivity.class);
                startActivity(intent);
            }
        });

        recyclerview = findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3);
        recyclerview.setLayoutManager(gridLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true);



        rings();
    }


    private void rings() {


        ArrayList<RingList> employees = new ArrayList<>();
        RingList rings1 = new RingList("","","1","1");
        RingList rings2 = new RingList("1","","22 g","25");
        RingList rings3 = new RingList("1","","22 g","25");
        RingList rings4 = new RingList("1","","22 g","25");
        RingList rings5 = new RingList("1","","22 g","25");

        employees.add(rings1);
        employees.add(rings2);
        employees.add(rings3);
        employees.add(rings4);
        employees.add(rings5);


        ringListAdapter = new RingListAdapter(this,employees);
        recyclerview.setAdapter(ringListAdapter);




    }

}