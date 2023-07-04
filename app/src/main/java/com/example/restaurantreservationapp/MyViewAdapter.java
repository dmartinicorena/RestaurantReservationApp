package com.example.restaurantreservationapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewAdapter extends FragmentStateAdapter {
    public MyViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentLogin();
            case 1:
                return new FragmentRegister();
            default:
                return new FragmentLogin();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
