package com.nsibandelh.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    String[] sPresidents;
    AutoCompleteTextView txtInput;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);

        sPresidents = getResources().getStringArray(R.array.presidents_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sPresidents);
        txtInput.setThreshold(2);
        txtInput.setAdapter(adapter);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, sPresidents);
        spinner.setAdapter(adapter1);
    }
}