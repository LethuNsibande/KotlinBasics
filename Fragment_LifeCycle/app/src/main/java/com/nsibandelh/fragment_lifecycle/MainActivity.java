package com.nsibandelh.fragment_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        DisplayMetrics display = getResources().getDisplayMetrics();

        int height = display.heightPixels;
        int width = display.widthPixels;

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();

        if (height > width)
            fragmentTransaction.replace(android.R.id.content, fragment1);
        else
            fragmentTransaction.replace(android.R.id.content, fragment2);

        fragmentTransaction.commit();
    }
}