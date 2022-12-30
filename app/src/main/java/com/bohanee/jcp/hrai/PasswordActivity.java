package com.bohanee.jcp.hrai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        //Currently only implementing this button for store code.
        Button continueButton = findViewById(R.id.pending_approvals_btn);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PasswordActivity.this, AddStoreActivity.class);
                startActivity(intent);
            }
        });
    }
}