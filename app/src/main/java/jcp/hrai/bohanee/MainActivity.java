package jcp.hrai.bohanee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    private BillingFragment billingFragment;
    private InventoryFragment inventoryFragment;
    private String TAGGING;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView topNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billingFragment = new BillingFragment();
        inventoryFragment = new InventoryFragment();
        topNav = findViewById(R.id.TopNavView);
        topNav.setOnNavigationItemSelectedListener(navListener);
        topNav.setSelectedItemId(R.id.nav_billing);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (savedInstanceState == null) {
            TAGGING = "BILLING";
            fragmentTransaction.replace(R.id.fragmentContainerMain, billingFragment, TAGGING);
        }
        fragmentTransaction.commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_billing:
                            selectedFragment = new BillingFragment();
                            TAGGING = "BILLING";
                            break;
                        case R.id.nav_inventory:
                            selectedFragment = new InventoryFragment();
                            TAGGING = "INVENTORY";
                            break;
                        //return false;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerMain,
                            selectedFragment, TAGGING).commit();
                    return true;
                }
            };
}
class Data{
    String pID;
    int QTY;
    int amt;
    String UPCData;
    public Data(String Pid, int Amt, int Qty, String UpcData) {
        this.pID = Pid;
        this.amt = Amt;
        this.QTY = Qty;
        this.UPCData = UpcData;
    }
}