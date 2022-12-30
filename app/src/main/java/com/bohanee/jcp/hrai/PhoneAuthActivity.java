package com.bohanee.jcp.hrai;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneAuthActivity extends AppCompatActivity {
    private static final String TAG = "PhoneAuthActivity";
    // variable for FirebaseAuth class
    private FirebaseAuth mAuth;
    // variable for our text input
    // field for phone and OTP.
    private EditText edtPhoneNo, OTP1, OTP2, OTP3, OTP4, OTP5, OTP6;
    private TextView verificationTV, enterOTPTV, waitingTV, verifyTV;
    private ImageView OTPImg, loadingImg, bohaneeImg;


    // buttons for generating OTP and verifying OTP
    private Button signInBtn, verifyOTPBtn;

    // string for storing our verification ID; fullOTP string combines the text of all OTP edittext boxes.
    private String verificationId, fullOTP;
    // callback method is called on Phone auth provider.
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            // initializing our callbacks for on
            // verification callback method.
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        // below method is used when
        // OTP is sent from Firebase
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            // when we receive the OTP it
            // contains a unique id which
            // we are storing in our string
            // which we have already created.
            verificationId = s;
        }

        // this method is called when user
        // receive OTP from Firebase.
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            // below line is used for getting OTP code
            // which is sent in phone auth credentials.
            final String code = phoneAuthCredential.getSmsCode();

            // checking if the code
            // is null or not.
            if (code != null) {
                // if the code is not null then
                // we are setting that code to
                // our OTP edittext field.
                OTP1.setText(fullOTP.charAt(0));
                OTP2.setText(fullOTP.charAt(1));
                OTP3.setText(fullOTP.charAt(2));
                OTP4.setText(fullOTP.charAt(3));
                OTP5.setText(fullOTP.charAt(4));
                OTP6.setText(fullOTP.charAt(5));

                // after setting this code
                // to OTP edittext field we
                // are calling our verifycode method.
                verifyCode(code);
            }
        }

        // this method is called when firebase doesn't
        // sends our OTP code due to any error or issue.
        @Override
        public void onVerificationFailed(FirebaseException e) {
            // displaying error message with firebase exception.
            Toast.makeText(PhoneAuthActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//This Line Hides The Action Bar.*/
        // below line is for getting instance
        // of our FirebaseAuth.
        mAuth = FirebaseAuth.getInstance();

        referenceVariables();

        // setting onclick listener for generate OTP button.
        signInBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // below line is for checking weather the user
                // has entered his mobile number or not.
                Log.d(TAG, "onClick: signInButton");
                if (TextUtils.isEmpty(edtPhoneNo.getText().toString()) && edtPhoneNo.getText().toString().length() < 10) {
                    // when mobile number text field is empty
                    // displaying a toast message.
                    Toast.makeText(PhoneAuthActivity.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    // if the text field is not empty we are calling our
                    // send OTP method for getting OTP from Firebase.
                    String phone = "+91" + edtPhoneNo.getText().toString();
                    hideSignInScreen();
                    showOTPScreen();
                    sendVerificationCode(phone);
                }
            }
        });

        // initializing on click listener
        // for verify otp button
        verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fullOTP = OTP1.getText().toString() +
                        OTP2.getText().toString() +
                        OTP3.getText().toString() +
                        OTP4.getText().toString() +
                        OTP5.getText().toString() +
                        OTP6.getText().toString();

                Log.d(TAG, "onCreate: " + fullOTP);

                // validating if the OTP text field is empty or not.
                if (fullOTP.length() == 0) {
                    // if the OTP text field is empty display
                    // a message to user to enter OTP
                    Toast.makeText(PhoneAuthActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    // if OTP field is not empty calling
                    // method to verify the OTP.
                    verifyCode(fullOTP);
                }
            }
        });
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        // inside this method we are checking if
        // the code entered is correct or not.
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // if the code is correct and the task is successful
                            // we are sending our user to new activity.
                            Intent i = new Intent(PhoneAuthActivity.this, CreateProfileActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            // if the code is not correct then we are
                            // displaying an error message to the user.
                            Toast.makeText(PhoneAuthActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void sendVerificationCode(String number) {
        // this method is used for getting
        // OTP on user phone number.
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(number)         // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBack)         // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    // below method is use to verify code from Firebase.
    private void verifyCode(String code) {
        // below line is used for getting
        // credentials from our verification id and code.
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

        // after getting credential we are
        // calling sign in method.
        signInWithCredential(credential);
    }

    //method that sets required views as visible to show sign in screen.
    private void showSignInScreen() {
        bohaneeImg.setVisibility(View.VISIBLE);
        verifyTV.setVisibility(View.VISIBLE);
        edtPhoneNo.setVisibility(View.VISIBLE);
        signInBtn.setVisibility(View.VISIBLE);

    }

    //method that sets required views as visible to hide sign in screen.
    private void hideSignInScreen() {
        bohaneeImg.setVisibility(View.INVISIBLE);
        verifyTV.setVisibility(View.INVISIBLE);
        edtPhoneNo.setVisibility(View.INVISIBLE);
        signInBtn.setVisibility(View.INVISIBLE);

    }

    //method that sets required views as visible to show OTP screen.
    private void showOTPScreen() {
        verificationTV.setVisibility(View.VISIBLE);
        OTPImg.setVisibility(View.VISIBLE);
        enterOTPTV.setVisibility(View.VISIBLE);
        loadingImg.setVisibility(View.VISIBLE);
        waitingTV.setVisibility(View.VISIBLE);
        verifyOTPBtn.setVisibility(View.VISIBLE);
        OTP1.setVisibility(View.VISIBLE);
        OTP2.setVisibility(View.VISIBLE);
        OTP3.setVisibility(View.VISIBLE);
        OTP4.setVisibility(View.VISIBLE);
        OTP5.setVisibility(View.VISIBLE);
        OTP6.setVisibility(View.VISIBLE);

    }

    //method that sets required views as invisible to hide OTP screen.
    private void hideOTPScreen() {
        verificationTV.setVisibility(View.INVISIBLE);
        OTPImg.setVisibility(View.INVISIBLE);
        enterOTPTV.setVisibility(View.INVISIBLE);
        loadingImg.setVisibility(View.INVISIBLE);
        waitingTV.setVisibility(View.INVISIBLE);
        verifyOTPBtn.setVisibility(View.INVISIBLE);
        OTP1.setVisibility(View.INVISIBLE);
        OTP2.setVisibility(View.INVISIBLE);
        OTP3.setVisibility(View.INVISIBLE);
        OTP4.setVisibility(View.INVISIBLE);
        OTP5.setVisibility(View.INVISIBLE);
        OTP6.setVisibility(View.INVISIBLE);
    }

    //method that references views by calling their respective findViewByIds.
    private void referenceVariables() {
        edtPhoneNo = findViewById(R.id.editTextPhoneNo);
        OTP1 = findViewById(R.id.otp_edittext1);
        OTP2 = findViewById(R.id.otp_edittext2);
        OTP3 = findViewById(R.id.otp_edittext3);
        OTP4 = findViewById(R.id.otp_edittext4);
        OTP5 = findViewById(R.id.otp_edittext5);
        OTP6 = findViewById(R.id.otp_edittext6);

        verifyOTPBtn = findViewById(R.id.verify_btn);
        signInBtn = findViewById(R.id.sign_in_btn);

        verificationTV = findViewById(R.id.verification_tv);
        enterOTPTV = findViewById(R.id.enter_otp_tv);
        waitingTV = findViewById(R.id.waiting_tv);
        verifyTV = findViewById(R.id.verify_tv);

        OTPImg = findViewById(R.id.otp_img);
        loadingImg = findViewById(R.id.loading_img);
        bohaneeImg = findViewById(R.id.bohanee_img);
    }

}
