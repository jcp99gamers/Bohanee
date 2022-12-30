package com.bohanee.jcp.hrai;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.database.Product;
import com.bohanee.jcp.hrai.databinding.ListItemBarcodeItemsBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivanshu Raj on 28-12-2022.
 */
public class BarcodeAdapter extends RecyclerView.Adapter<BarcodeAdapter.ViewHolder> {

    private List<Product> productList;

    public BarcodeAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListItemBarcodeItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        holder.productNameTv.setText(currentProduct.getProductName());
        holder.productQtyTv.setText(currentProduct.getQuantity() + "");
        holder.productCPTv.setText("₹"+currentProduct.getCp());
        holder.productSPTv.setText("₹"+currentProduct.getSp());

    }

    @Override
    public int getItemCount() {
        if (productList.size() == 0) {
            return 0;
        } else {
            return productList.size();

        }
    }

    public void setProduct(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productNameTv;
        public TextView productQtyTv;
        public TextView productCPTv;
        public TextView productSPTv;

        public ViewHolder(ListItemBarcodeItemsBinding binding) {
            super(binding.getRoot());
            productNameTv = binding.productNameTv;
            productQtyTv = binding.qtyTv;
            productCPTv = binding.liBarcodeCpTv;
            productSPTv = binding.liBarcodeSpTv;
        }
    }
}
