package com.example.restaurantreservationapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Login");
        tab1.setTabListener(new MyTabListener(this,new FragmentLogin()));
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("Register");
        tab2.setTabListener(new MyTabListener(this,new FragmentRegister()));
        actionbar.addTab(tab2);
    }
    }
