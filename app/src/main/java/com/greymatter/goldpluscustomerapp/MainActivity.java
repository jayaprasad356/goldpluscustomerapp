package com.greymatter.goldpluscustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;

import com.greymatter.goldpluscustomerapp.adapter.RingAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;
import com.greymatter.goldpluscustomerapp.model.Rings;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    RingAdapter ringAdapter;
    Activity activity;
    Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        session = new Session(activity);


        recyclerview = findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3);
        recyclerview.setLayoutManager(gridLayoutManager);


        rings();




    }

    private void rings() {


        ArrayList<Rings> rings = new ArrayList<>();
        Rings rings1 = new Rings("1","","22 g","25");
        Rings rings2 = new Rings("1","","22 g","25");
        Rings rings3 = new Rings("1","","22 g","25");
        Rings rings4 = new Rings("1","","22 g","25");
        Rings rings5 = new Rings("1","","22 g","25");

        rings.add(rings1);
        rings.add(rings2);
        rings.add(rings3);
        rings.add(rings4);
        rings.add(rings5);


        ringAdapter = new RingAdapter(MainActivity.this,rings);
        recyclerview.setAdapter(ringAdapter);




    }
}