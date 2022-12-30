package com.bohanee.jcp.hrai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JoinBusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_business);

        Button setupBusiness= findViewById(R.id.pending_approvals_btn);
        Button joinBusiness= findViewById(R.id.multi_store_btn);

        setupBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinBusinessActivity.this, SetupBusinessActivity.class);
                startActivity(intent);
            }
        });
        joinBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JoinBusinessActivity.this, BizStoreCodeActivity.class);
                startActivity(intent);
            }
        });

    }
}