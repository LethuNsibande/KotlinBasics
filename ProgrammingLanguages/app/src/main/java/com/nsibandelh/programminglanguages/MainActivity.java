package com.nsibandelh.programminglanguages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView lvLanguages;

    String[] sLanguages =
            {
                    "amdroid",
                    "cpp",
                    "csharp",
                    "css",
                    "html",
                    "java",
                    "js",
                    "php"
            };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLanguages = findViewById(R.id.lvLanguages);

        //Changes form of array to be receivable n=by list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, sLanguages);

        //Link the array to list view
        lvLanguages.setAdapter(adapter);
    }
}