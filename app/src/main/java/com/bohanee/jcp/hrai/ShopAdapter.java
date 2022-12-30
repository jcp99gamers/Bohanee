package com.bohanee.jcp.hrai;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.databinding.ListItemShopsBinding;

import java.util.List;


/**
 * Created by Shivanshu Raj on 28-12-2022.
 */
public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    List<String> shopsList;

    public ShopAdapter(List<String> data) {
        this.shopsList = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ListItemShopsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String currentString = shopsList.get(position);
        holder.shopTv.setText(currentString);

    }


    @Override
    public int getItemCount() {
        return shopsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView shopTv;


        public ViewHolder(ListItemShopsBinding binding) {
            super(binding.getRoot());
            shopTv = binding.shopTv;

        }
    }
}
