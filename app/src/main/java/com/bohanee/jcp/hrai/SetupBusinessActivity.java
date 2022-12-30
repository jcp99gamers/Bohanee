package com.bohanee.jcp.hrai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SetupBusinessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_business);

        Button singleStoreButton = findViewById(R.id.pending_approvals_btn);
        Button multiStoreButton = findViewById(R.id.multi_store_btn);


        /**Important Note: THE LAYOUT OF PASSWORD ACTIVITY CHANGES ON THE BASIS OF SINGLE OR
         MULTI STORE BUTTON CLICKED.**/

        singleStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupBusinessActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });
        multiStoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupBusinessActivity.this, PasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}