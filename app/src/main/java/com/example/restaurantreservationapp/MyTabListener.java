package com.example.restaurantreservationapp;

import android.content.Context;

import androidx.fragment.app.Fragment;

    public class MyTabListener implements androidx.appcompat.app.ActionBar.TabListener {
        private Context context;
        private Fragment frag;
        public MyTabListener(Context context, Fragment frag){
            this.context = context;
            this.frag = frag;
        }

        @Override
        public void onTabSelected(androidx.appcompat.app.ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {
            ft.replace(R.id.layoutMain,this.frag);
        }

        @Override
        public void onTabUnselected(androidx.appcompat.app.ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(androidx.appcompat.app.ActionBar.Tab tab, androidx.fragment.app.FragmentTransaction ft) {

        }
    }

