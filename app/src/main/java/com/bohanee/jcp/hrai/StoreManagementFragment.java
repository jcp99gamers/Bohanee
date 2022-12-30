package com.bohanee.jcp.hrai;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.bohanee.jcp.hrai.database.Product;

import java.util.ArrayList;
import java.util.List;

public class StoreManagementFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_store_management, container, false);
        RecyclerView recyclerView =view.findViewById(R.id.store_man_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Product> productList= new ArrayList<>();
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        productList.add(new Product("sdlkfjds", 56,56, 8));
        StoreManagementAdapter storeManagementAdapter= new StoreManagementAdapter(productList);
        recyclerView.setAdapter(storeManagementAdapter);

        FloatingActionButton fab =view.findViewById(R.id.add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), InventoryAdditionActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}