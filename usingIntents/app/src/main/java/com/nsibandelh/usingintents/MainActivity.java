package com.nsibandelh.usingintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btnDisplaySecondActivity;
    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDisplaySecondActivity = findViewById(R.id.btnDisplaySecondActivity);

        btnDisplaySecondActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent("com.nsibandelh.usingintents.SecondActivity"));
            }
        });

        Log.d(TAG,"Has started...");
    }
}