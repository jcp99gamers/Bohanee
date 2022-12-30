package com.bohanee.jcp.hrai;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.database.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_summary);
        ActionBar ab = getSupportActionBar();

        if (ab != null)
            ab.setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = findViewById(R.id.prod_sum_rv);

        //Temporary dummy data for testing purposes.
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Dairy Milk", 20, 2));
        productList.add(new Product("Choclairs", 20, 4));
        productList.add(new Product("Tik Tak", 40, 4));
        productList.add(new Product("Mik Mak", 20, 2));
        productList.add(new Product("Dik Dak", 20, 3));
        productList.add(new Product("Pik Pak", 30, 3));
        productList.add(new Product("Dairy Milk", 20, 2));
        productList.add(new Product("Choclairs", 20, 6));
        productList.add(new Product("Tik Tak", 60, 6));
        productList.add(new Product("Mik Mak", 60, 2));
        productList.add(new Product("Dik Dak", 20, 2));
        productList.add(new Product("Pik Pak", 20, 2));
        productList.add(new Product("Dairy Milk", 20, 2));
        productList.add(new Product("Choclairs", 20, 2));
        productList.add(new Product("Tik Tak", 20, 2));
        productList.add(new Product("Mik Mak", 20, 2));
        productList.add(new Product("Dik Dak", 20, 2));
        productList.add(new Product("Pik Pak", 20, 2));

        ProductSummaryAdapter productSummaryAdapter = new ProductSummaryAdapter(productList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productSummaryAdapter);
    }
}