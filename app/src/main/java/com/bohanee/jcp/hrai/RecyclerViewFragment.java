package com.bohanee.jcp.hrai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.database.Product;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class RecyclerViewFragment extends Fragment {
    ArrayList<Product> arrayList;
    BillingRVAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list);


        arrayList = new ArrayList<>();
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        arrayList.add(new Product("Tinder Joy", 50, 56));
        adapter = new BillingRVAdapter(arrayList);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

        return view;
    }
}