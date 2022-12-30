package com.bohanee.jcp.hrai;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bohanee.jcp.hrai.databinding.ListItemSpManagerBinding;

import java.util.List;

/**
 * Created by Shivanshu Raj on 28-12-2022.
 */
public class EmployeeRVAdapter extends RecyclerView.Adapter<EmployeeRVAdapter.ViewHolder> {
    private List<Employee> employeeList;

    public EmployeeRVAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeRVAdapter.ViewHolder(ListItemSpManagerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee currentEmployee = employeeList.get(position);
        holder.empName.setText(currentEmployee.getName());
        holder.empPhNo.setText(currentEmployee.getPhoneNo() + "");
        holder.storeCode.setText(currentEmployee.getStoreCode());
        holder.empID.setText(currentEmployee.getEmpID());
    }


    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView empName;
        public TextView empPhNo;
        public TextView storeCode;
        public TextView empID;

        public ViewHolder(ListItemSpManagerBinding binding) {
            super(binding.getRoot());
            empName = binding.spEmpNameTv;
            empPhNo = binding.spEmpPhnTv;
            storeCode = binding.spStoreCodeTv;
            empID = binding.spEmpIdTv;
        }
    }
}
