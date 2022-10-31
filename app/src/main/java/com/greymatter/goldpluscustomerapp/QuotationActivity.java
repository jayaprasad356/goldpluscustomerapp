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

import com.greymatter.goldpluscustomerapp.adapter.QuotationAdapter;
import com.greymatter.goldpluscustomerapp.adapter.RingListAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;
import com.greymatter.goldpluscustomerapp.model.QuotationList;
import com.greymatter.goldpluscustomerapp.model.RingList;

import java.util.ArrayList;

public class QuotationActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    QuotationAdapter quotationAdapter;
    Activity activity;
    Session session;
    Button btnDigitalSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);


        activity = this;
        session = new Session(activity);


        recyclerview = findViewById(R.id.recyclerview);
        btnDigitalSign = findViewById(R.id.btnDigitalSign);

        btnDigitalSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,SignatureActivity.class);
                startActivity(intent);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(linearLayoutManager);



        list();

    }

    private void list() {


        ArrayList<QuotationList> quotationLists = new ArrayList<>();
        QuotationList rings1 = new QuotationList("","3","Sub-name","27.00","96","7.555");
        QuotationList rings2 = new QuotationList("","3","Sub-name","27.00","96","7.555");



        quotationLists.add(rings1);
        quotationLists.add(rings2);




        quotationAdapter = new QuotationAdapter(this,quotationLists);
        recyclerview.setAdapter(quotationAdapter);



    }
}