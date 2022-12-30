package com.bohanee.jcp.hrai;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.database.Product;
import com.bohanee.jcp.hrai.databinding.ListItemBillingBinding;

import java.util.ArrayList;
import java.util.List;


public class BillingRVAdapter extends RecyclerView.Adapter<BillingRVAdapter.ViewHolder> {

    private List<Product> productList;

    public BillingRVAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListItemBillingBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        holder.productNameTv.setText(currentProduct.getProductName());
        holder.productQtyTv.setText(currentProduct.getQuantity() + "");
        holder.productSPTv.setText("₹"+currentProduct.getSp());
        holder.productQtyXCpTv.setText(+currentProduct.getQuantity()+" X ₹"+currentProduct.getSp());

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
        public TextView productSPTv;
        public TextView productQtyXCpTv;

        public ViewHolder(ListItemBillingBinding binding) {
            super(binding.getRoot());
            productNameTv = binding.productNameTv;
            productQtyTv = binding.qtyTv;
            productSPTv = binding.liBillingSpTv;
            productQtyXCpTv=binding.qtyXPriceTv;
        }
    }
}