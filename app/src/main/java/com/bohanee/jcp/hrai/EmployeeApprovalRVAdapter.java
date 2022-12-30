package com.bohanee.jcp.hrai;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.databinding.ListItemEmployeeApprovalBinding;

import java.util.List;

/**
 * Created by Shivanshu Raj on 28-12-2022.
 */
public class EmployeeApprovalRVAdapter extends RecyclerView.Adapter<EmployeeApprovalRVAdapter.ViewHolder> {
    private List<Employee> employeeList;

    public EmployeeApprovalRVAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(ListItemEmployeeApprovalBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee currentEmployee = employeeList.get(position);
        holder.empName.setText(currentEmployee.getName());
        holder.empPhoneNo.setText(currentEmployee.getPhoneNo() + "");
        holder.storeCode.setText(currentEmployee.getStoreCode());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView storeCode;
        private TextView empName;
        private TextView empPhoneNo;
        private Button approveButton;
        private Button denyButton;


        public ViewHolder(ListItemEmployeeApprovalBinding binding) {
            super(binding.getRoot());
            storeCode = binding.appStoreCodeTv;
            empName = binding.appEmpNameTv;
            empPhoneNo = binding.appEmpPhnTv;
            approveButton = binding.btnApprove;
            denyButton = binding.btnDeny;
        }
    }
}
