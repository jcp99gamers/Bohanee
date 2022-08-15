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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BillingFragment extends Fragment implements CameraFragment.OnChildFragmentInteractionListener {
    private OnFragmentInteractionListener mListener;
    FragmentTransaction fragmentTransactionB;
    private TextView editText;

    public interface OnFragmentInteractionListener {
        void messageFromParentFragmentToActivity(String myString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_billing, container, false);
        editText = v.findViewById(R.id.CameraDataBilling);
        /*CameraFragment cameraFragmentB = new CameraFragment();
        fragmentTransactionB = getActivity().getSupportFragmentManager().beginTransaction(); //getFragmentManager().beginTransaction();
        fragmentTransactionB.replace(R.id.fragmentContainerForCameraB, cameraFragmentB);
        fragmentTransactionB.commit();*/
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
        editText.setText(myString);
    }
}