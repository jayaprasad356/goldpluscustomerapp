package com.greymatter.goldpluscustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.greymatter.goldpluscustomerapp.adapter.QuotationAdapter;
import com.greymatter.goldpluscustomerapp.helper.Session;

public class FinalActivity extends AppCompatActivity {


    RecyclerView recyclerview;
    QuotationAdapter quotationAdapter;
    Activity activity;
    Session session;
    Button btnDigitalSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);



    }
}