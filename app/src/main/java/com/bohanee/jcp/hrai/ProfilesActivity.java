package com.bohanee.jcp.hrai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProfilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        FloatingActionButton fab= findViewById(R.id.floatingActionButton);
        RecyclerView recyclerView = findViewById(R.id.profiles_rv);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ProfilesActivity.this, AddStoreActivity.class);
            startActivity(intent);
        });


        //Temporary dummy data for testing purposes only.
        List<String> shopList= new ArrayList<String>();
        shopList.add("Shop 1");
        shopList.add("Shop 2");
        shopList.add("Shop 3");
        shopList.add("Shop 4");
        shopList.add("Shop 5");
        shopList.add("Shop 1");
        shopList.add("Shop 1");
        shopList.add("Shop 1");
        shopList.add("Shop 1");
        shopList.add("Shop 1");
        shopList.add("Shop 1");
        shopList.add("Shop 1");
        shopList.add("Shop 1");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ShopAdapter adapter = new ShopAdapter(shopList);
        recyclerView.setAdapter(adapter);
    }


    }
