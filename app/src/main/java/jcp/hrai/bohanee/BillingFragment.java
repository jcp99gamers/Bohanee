package jcp.hrai.bohanee;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import org.jsoup.Jsoup;

public class BillingFragment extends Fragment implements CameraFragment.OnChildFragmentInteractionListener {
    private OnFragmentInteractionListener mListener;
    FragmentTransaction fragmentTransactionB;
    SQLiteDatabase db;
    Cursor cr;
    private TextView editText;
    String Pid, UpcData;
    int Amt, Qty;
    private RecyclerView recyclerView;
    private DataAdapter testAdapter;
    Data[] data;
    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = getActivity().openOrCreateDatabase("BohaneeSQLiteDatabase",android.content.Context.MODE_PRIVATE ,null);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_billing, container, false);
        //editText = v.findViewById(R.id.CameraDataBilling);
        // db = openOrCreateDatabase("DATABASE",android.content.Context.MODE_PRIVATE ,null);
        db.execSQL("Create Table If Not Exists Bills(data Varchar, amt Int, qty Int,raw Varchar);");
        String queryB = "select * from bills";
        cr = db.rawQuery(queryB, null);
        // String newdata = "insert into transactionhistory values('JCP',1,'dd/mm/yy','cate')";
        // db.execSQL(newdata);
        recyclerView = v.findViewById(R.id.recycler_view);
        testAdapter = new DataAdapter();
        recyclerView.setAdapter(testAdapter);
        int count = cr.getCount();  //int count = DatabaseUtils.queryNumEntries(db, "transactionhistory");
        String AddData = "insert into bills values('"+"NameData"+"','"+100+"','"+1+"','"+"RawUPC"+"')";
        db.execSQL(AddData);
        Log.v("SQLData", count+"");
        data = new Data[count];//data = new Data[10];
        /*cr.moveToFirst();
        for (int i=0; i<=(count-1); i++) {
            name = cr.getString(0);
            amount = cr.getInt(1);
            Date = cr.getString(2);
            Category = cr.getString(3);
            data[i] = new Data(name, amount, Date, Category);
            cr.moveToNext();
        }*/
        int i = 0;
        while (cr.moveToNext()) {
            Pid = cr.getString(0);
            Amt = cr.getInt(1);
            Qty = cr.getInt(2);
            UpcData = cr.getString(3);
            data[i] = new Data(Pid, Amt, Qty, UpcData);
            i++;
        }
        /*
        Pid = "Name";
        Amt = 20;
        Qty = 19;
        UpcData = "UPC Label";
        data[0] = new Data(Pid, Amt, Qty, UpcData);
        data[1] = new Data(Pid, Amt, Qty, UpcData);
        data[2] = new Data(Pid, Amt, Qty, UpcData);
        data[3] = new Data(Pid, Amt, Qty, UpcData);
        data[4] = new Data(Pid, Amt, Qty, UpcData);
        data[5] = new Data(Pid, Amt, Qty, UpcData);
        data[6] = new Data(Pid, Amt, Qty, UpcData);
        data[7] = new Data(Pid, Amt, Qty, UpcData);
        data[8] = new Data(Pid, Amt, Qty, UpcData);
        data[9] = new Data(Pid, Amt, Qty, UpcData);*/
        testAdapter.setListdata(data);
        testAdapter.notifyDataSetChanged();
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment childFragment = new CameraFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerForCameraB, childFragment).commit();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void messageFromChildToParent(String myString) {
        //Log.v("TAG", myString);
        //editText.setText(myString);
    }
}