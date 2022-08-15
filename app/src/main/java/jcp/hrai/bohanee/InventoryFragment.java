package jcp.hrai.bohanee;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class InventoryFragment extends Fragment implements CameraFragment.OnChildFragmentInteractionListener {
    private BillingFragment.OnFragmentInteractionListener mListener;
    FragmentTransaction fragmentTransactionI;
    private TextView editText;

    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inventory, container, false);
        editText = v.findViewById(R.id.CameraDataInventory);
        /*CameraFragment cameraFragmentI = new CameraFragment();
        fragmentTransactionI = getActivity().getSupportFragmentManager().beginTransaction(); //getFragmentManager().beginTransaction();
        fragmentTransactionI.replace(R.id.fragmentContainerForCameraI, cameraFragmentI);
        fragmentTransactionI.commit();*/
        return v;
    }

    @Override
    public void messageFromChildToParent(String myString) {
        //Log.v("TAG", myString);
        editText.setText(myString);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment childFragment = new CameraFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerForCameraI, childFragment).commit();
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
}