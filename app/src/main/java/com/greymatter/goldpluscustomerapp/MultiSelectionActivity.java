package com.greymatter.goldpluscustomerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.greymatter.goldpluscustomerapp.adapter.RingListAdapter;
import com.greymatter.goldpluscustomerapp.model.RingList;

import java.util.ArrayList;

public class MultiSelectionActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RingList> employees = new ArrayList<>();
    private RingListAdapter adapter;
    private Button btnGetSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_selection);


        btnGetSelected = (Button) findViewById(R.id.btnGetSelected);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);




        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RingListAdapter(this, employees);
        recyclerView.setAdapter(adapter);

        // recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//
//
//        adapter = new MultiAdapter(this, employees);
//        recyclerView.setAdapter(adapter);

        createList();

        btnGetSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapter.getSelected().size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < adapter.getSelected().size(); i++) {
                        stringBuilder.append(adapter.getSelected().get(i).getWeight());
                        stringBuilder.append("\n");
                    }
                    showToast(stringBuilder.toString().trim());
                } else {
                    showToast("No Selection");
                }
            }
        });




    }


    private void createList() {



        ArrayList<RingList> employees = new ArrayList<>();
        RingList rings1 = new RingList("","","1","1");
//        Rings rings2 = new Rings("1","","22 g","25");
//        Rings rings3 = new Rings("1","","22 g","25");
//        Rings rings4 = new Rings("1","","22 g","25");
//        Rings rings5 = new Rings("1","","22 g","25");

        employees.add(rings1);
//        rings.add(rings2);
//        rings.add(rings3);
//        rings.add(rings4);
//        rings.add(rings5);


        adapter = new RingListAdapter(this,employees);
        recyclerView.setAdapter(adapter);


//
//        employees = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            Employee employee = new Employee();
//            employee.setName("Employee " + (i + 1));
//            // for example to show at least one selection
//            if (i == 0) {
//                employee.setChecked(true);
//            }
//            //
//            employees.add(employee);
//        }
//        adapter.setEmployees(employees);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}