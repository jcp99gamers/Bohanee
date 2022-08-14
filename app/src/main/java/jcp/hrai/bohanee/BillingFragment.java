package jcp.hrai.bohanee;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BillingFragment extends Fragment {
    /*private FragmentBillingListener listener;*/
    private TextView editText;

    /*public interface FragmentBillingListener {
        void onInputGotFromCamera(CharSequence input);
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_billing, container, false);
        editText = v.findViewById(R.id.CameraData);
        return v;
    }

    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentBillingListener) {
            listener = (FragmentBillingListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }*/
}