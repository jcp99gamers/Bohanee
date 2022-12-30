package com.bohanee.jcp.hrai;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ApproveDenyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_deny);
        RecyclerView recyclerView = findViewById(R.id.list_approve_deny);

        // Temporary dummy data for testing purposes only.
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Harshit Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Jonathan Chacko", "1613", 4566123323L, true));
        empList.add(new Employee("Shivanshu Raj", "1613", 4566123323L, true));
        empList.add(new Employee("Devdutt Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Harshit Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Jonathan Chacko", "1613", 4566123323L, true));
        empList.add(new Employee("Shivanshu Raj", "1613", 4566123323L, true));
        empList.add(new Employee("Devdutt Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Harshit Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Jonathan Chacko", "1613", 4566123323L, true));
        empList.add(new Employee("Shivanshu Raj", "1613", 4566123323L, true));
        empList.add(new Employee("Devdutt Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Harshit Rai", "1613", 4566123323L, true));
        empList.add(new Employee("Jonathan Chacko", "1613", 4566123323L, true));
        empList.add(new Employee("Shivanshu Raj", "1613", 4566123323L, true));
        empList.add(new Employee("Devdutt Rai", "1613", 4566123323L, true));
        EmployeeApprovalRVAdapter employeeApprovalRVAdapter = new EmployeeApprovalRVAdapter( empList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(employeeApprovalRVAdapter);
    }
}