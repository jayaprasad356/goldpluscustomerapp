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
import com.greymatter.goldpluscustomerapp.adapter.SelectedRingsAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;
import com.greymatter.goldpluscustomerapp.model.RingList;
import com.greymatter.goldpluscustomerapp.model.SelectedRingList;

import java.util.ArrayList;

public class ProceedActivity extends AppCompatActivity {

    RecyclerView recyclerview, categoryRecyclerview;
    SelectedRingsAdapter selectedRingsAdapter;
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
                Intent intent = new Intent(activity,RateCutActivity.class);
                startActivity(intent);
            }
        });

        recyclerview = findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,5);
        recyclerview.setLayoutManager(gridLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true);



        rings();
    }


    private void rings() {


        ArrayList<SelectedRingList> selectedRingLists = new ArrayList<>();
        SelectedRingList rings1 = new SelectedRingList("","","1","1");
        SelectedRingList rings2 = new SelectedRingList("1","","22 g","25");
        SelectedRingList rings3 = new SelectedRingList("1","","22 g","25");
        SelectedRingList rings4 = new SelectedRingList("1","","22 g","25");
        SelectedRingList rings5 = new SelectedRingList("1","","22 g","25");

        selectedRingLists.add(rings1);
        selectedRingLists.add(rings2);
        selectedRingLists.add(rings3);
        selectedRingLists.add(rings4);
        selectedRingLists.add(rings5);
        selectedRingLists.add(rings1);
        selectedRingLists.add(rings2);
        selectedRingLists.add(rings3);
        selectedRingLists.add(rings4);
        selectedRingLists.add(rings5);


        selectedRingsAdapter = new SelectedRingsAdapter(this,selectedRingLists);
        recyclerview.setAdapter(selectedRingsAdapter);




    }

}