package com.greymatter.goldpluscustomerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InvoiceActivity extends AppCompatActivity {

    Button btnViewoders;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        btnViewoders = findViewById(R.id.btnViewoders);
        btnViewoders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvoiceActivity.this,OdersActivity.class);
                startActivity(intent);
            }
        });



    }
}