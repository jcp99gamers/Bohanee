package com.bohanee.jcp.hrai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class BillingFragment extends Fragment implements CameraFragment.OnChildFragmentInteractionListener {

    private OnFragmentInteractionListener mListener;
    FragmentTransaction fragmentTransactionB;
    private Button cancelButton,proceedButton,fastForwardButton;
    private EditText discountAmtEdt, discountPercentEdt;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_billing, container, false);
        cancelButton = view.findViewById(R.id.btn_cancel);
        proceedButton = view.findViewById(R.id.btn_proceed);
        fastForwardButton = view.findViewById(R.id.btn_fast_forward);
        discountAmtEdt=view.findViewById(R.id.discount_amt_et);
        discountPercentEdt=view.findViewById(R.id.discount_percent_et);

        discountAmtEdt.setText("₹");
        Selection.setSelection(discountAmtEdt.getText(), discountAmtEdt.getText().length());


        discountAmtEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().startsWith("₹")){
                    discountAmtEdt.setText("₹");
                    Selection.setSelection(discountAmtEdt.getText(), discountAmtEdt.getText().length());

                }

            }



        });

        discountPercentEdt.setText("%");
        Selection.setSelection(discountPercentEdt.getText(), discountPercentEdt.getText().length());


        discountPercentEdt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().endsWith("%")){
                    discountPercentEdt.setText("%");
                    Selection.setSelection(discountPercentEdt.getText(), discountPercentEdt.getText().length());

                }

            }
            });



        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CustomerDetailsActivity.class);
                startActivity(intent);
            }
        });

        fastForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductSummaryActivity.class);
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void messageFromChildToParent(String stringUPC, String stringRAW) {

    }

    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment childFragment = new CameraFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerForCameraBILLING, childFragment).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}