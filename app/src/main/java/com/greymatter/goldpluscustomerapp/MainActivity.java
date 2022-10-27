package com.greymatter.goldpluscustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;

import com.greymatter.goldpluscustomerapp.adapter.RingAdapter;
import com.greymatter.goldpluscustomerapp.adapter.RingCategoryAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;
import com.greymatter.goldpluscustomerapp.model.Rings;
import com.greymatter.goldpluscustomerapp.model.RingsCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview, categoryRecyclerview;
    RingAdapter ringAdapter;
    RingCategoryAdapter ringCategoryAdapter;
    Activity activity;
    Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = MainActivity.this;
        session = new Session(activity);


        recyclerview = findViewById(R.id.recyclerview);
        categoryRecyclerview = findViewById(R.id.categoryRecyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity,3);
        recyclerview.setLayoutManager(gridLayoutManager);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,true);
        categoryRecyclerview.setLayoutManager(linearLayoutManager);


        rings();
        categoryRings();




    }

    private void categoryRings() {


        ArrayList<RingsCategory> ringsCategories = new ArrayList<>();
        RingsCategory rings1 = new RingsCategory("","Bangles");
        RingsCategory rings2 = new RingsCategory("","Rings");
        RingsCategory rings3 = new RingsCategory("","Bangles");
        RingsCategory rings4 = new RingsCategory("","Bangles");
        RingsCategory rings5 = new RingsCategory("","Bangles");


        ringsCategories.add(rings1);
        ringsCategories.add(rings2);
        ringsCategories.add(rings3);
        ringsCategories.add(rings4);
        ringsCategories.add(rings5);


        ringCategoryAdapter = new RingCategoryAdapter(MainActivity.this,ringsCategories);
        categoryRecyclerview.setAdapter(ringCategoryAdapter);

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