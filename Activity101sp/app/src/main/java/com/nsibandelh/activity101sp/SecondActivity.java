package com.nsibandelh.activity101sp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity
{
    private Button btnSubmit;
    private EditText txtName, txtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtName = (EditText) findViewById(R.id.txtName);
                txtNumber = (EditText) findViewById(R.id.txtNumber);

                Intent data = new Intent();
                data.putExtra("name", txtName.getText().toString());
                data.putExtra("num", Integer.parseInt(txtNumber.getText().toString()));

                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
