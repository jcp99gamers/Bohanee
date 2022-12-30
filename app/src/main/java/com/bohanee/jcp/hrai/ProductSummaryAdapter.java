package com.bohanee.jcp.hrai;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.database.Product;
import com.bohanee.jcp.hrai.databinding.ListItemProductSummaryBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shivanshu Raj on 28-12-2022.
 */
public class ProductSummaryAdapter extends RecyclerView.Adapter<ProductSummaryAdapter.ViewHolder> {

    private List<Product> productList;

    public ProductSummaryAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListItemProductSummaryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        holder.productNameTv.setText(currentProduct.getProductName());
        holder.productQtyXPriceTv.setText(currentProduct.getQuantity() + "X" + currentProduct.getSp());
        holder.productSpTv.setText(currentProduct.getSp()+"");

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
        public TextView productQtyXPriceTv;
        public TextView productSpTv;

        public ViewHolder(ListItemProductSummaryBinding binding) {
            super(binding.getRoot());
            productNameTv = binding.productNameTv;
            productQtyXPriceTv = binding.qtyXPriceTv;
            productSpTv = binding.prodSumSpTv;
        }
    }
}
