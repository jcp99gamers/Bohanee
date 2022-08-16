package jcp.hrai.bohanee;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private Data[] listdata;
    public void setListdata(Data[] listdata) {
        this.listdata = listdata;
    }

//    private List<ArrayList<String>> listdata;
//    public void setListdata(List<ArrayList<String>> listdata) {
//        this.listdata = listdata;
//    }

    SQLiteDatabase db;
    Cursor cr;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.cart_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        System.out.println(listdata[position].name);
        holder.ProductID.setText(""+listdata[position].pID+"");
        holder.AMT.setText(""+listdata[position].amt+"");
        holder.Qty.setText(""+listdata[position].QTY+"");
        holder.LabelIDRaw.setText(""+listdata[position].UPCData +"");
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ProductID;
        public TextView AMT;
        public TextView Qty;
        public TextView LabelIDRaw;
        public ViewHolder(View itemView) {
            super(itemView);
            ProductID = itemView.findViewById(R.id.ProductIDs);
            AMT = itemView.findViewById(R.id.Amount);
            Qty = itemView.findViewById(R.id.Quantity);
            LabelIDRaw = itemView.findViewById(R.id.UPC);
        }
    }
}