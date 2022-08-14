package jcp.hrai.bohanee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CameraFragment.CameraListener{
    private CameraFragment cameraFragment;
    private BillingFragment billingFragment;
    private InventoryFragment inventoryFragment;
    FragmentTransaction fragmentTransaction;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//This Line Hides The Action Bar.*/
        cameraFragment = new CameraFragment();
        billingFragment = new BillingFragment();
        inventoryFragment = new InventoryFragment();
        btn = findViewById(R.id.button);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerForCamera, cameraFragment)
                .replace(R.id.fragmentContainerMain, billingFragment)
                .commit();


    }

/*    @Override
    public void onInputGotFromCamera(CharSequence input) {
        cameraFragment.updateEditText(input);
    }*/

    @Override
    public void onInputSent(CharSequence input) {
        billingFragment.updateEditText(input);
    }
}