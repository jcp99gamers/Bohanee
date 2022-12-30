package com.bohanee.jcp.hrai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BizStoreCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biz_store_code);

        Button continueBtn=findViewById(R.id.biz_code_continue_btn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BizStoreCodeActivity.this, ApprovalActivity.class);
                startActivity(intent);
            }
        });

    }
}