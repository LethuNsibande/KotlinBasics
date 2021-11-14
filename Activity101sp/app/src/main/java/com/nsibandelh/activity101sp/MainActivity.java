package com.nsibandelh.activity101sp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Button btnSecondActivity;
    private int iRequestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = ProgressDialog.show(this, "Please Wait", "Processing...");

        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) { }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();

        btnSecondActivity = (Button) findViewById(R.id.btnSecondActivity);
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, SecondActivity.class), iRequestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == iRequestCode)
            if (resultCode == RESULT_OK)
            {
                Toast.makeText(this, "Name: " + data.getStringExtra("name"), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Student Number: " + data.getIntExtra("num", 0), Toast.LENGTH_SHORT).show();
            }
    }
}