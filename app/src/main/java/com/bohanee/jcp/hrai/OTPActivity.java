package com.bohanee.jcp.hrai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class OTPActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        et1=findViewById(R.id.otp_edittext1);
        et2=findViewById(R.id.otp_edittext2);
        et3=findViewById(R.id.otp_edittext3);
        et4=findViewById(R.id.otp_edittext4);
        et5=findViewById(R.id.otp_edittext5);
        et6=findViewById(R.id.otp_edittext6);

        //combining text received from each of the six edittext boxes as a String.
        String receivedOTP =et1.getText().toString()+
                et2.getText().toString()+
                et3.getText().toString()+
                et4.getText().toString()+
                et5.getText().toString()+
                et6.getText().toString();
    }
}