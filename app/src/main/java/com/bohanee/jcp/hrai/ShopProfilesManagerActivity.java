package com.bohanee.jcp.hrai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShopProfilesManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_profiles_manager);
        Button dashboardBtn = findViewById(R.id.dashboard_btn);
        Button pendingApprovalsBtn = findViewById(R.id.pending_approvals_btn);
        RecyclerView recyclerView = findViewById(R.id.sp_employees_rv);

        // Temporary dummy data for testing.
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Harshit Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Jonathan Chacko", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Shivanshu Raj", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Devdutt Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Harshit Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Jonathan Chacko", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Shivanshu Raj", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Devdutt Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Harshit Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Jonathan Chacko", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Shivanshu Raj", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Devdutt Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Harshit Rai", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Jonathan Chacko", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Shivanshu Raj", "01x2", "8734", 1234567890L));
        empList.add(new Employee("Devdutt Rai", "01x2", "8734", 1234567890L));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        EmployeeRVAdapter employeeRVAdapter = new EmployeeRVAdapter(empList);
        recyclerView.setAdapter(employeeRVAdapter);
        dashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopProfilesManagerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        pendingApprovalsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopProfilesManagerActivity.this, ApproveDenyActivity.class);
                startActivity(intent);
            }
        });
    }
}