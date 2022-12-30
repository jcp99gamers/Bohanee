package com.bohanee.jcp.hrai;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Created by Shivanshu Raj on 29-12-2022.
 */
public class InventoryScreenAdapter extends FragmentStateAdapter {
    public InventoryScreenAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new BarcodeItemsFragment();
        } else {
            return new LooseItemsFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
