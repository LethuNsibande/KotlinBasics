package com.nsibandelh.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
    }

    public void onClick(View view) {
        Intent data = new Intent();

        //--Get the EditText view
        EditText txtUsername = (EditText)findViewById(R.id.txtUsername);

        //--Set the data to pass back
        data.setData(Uri.parse(txtUsername.getText().toString()));
        setResult(RESULT_OK, data);

        //--Closes the activity
        finish();
    }
}
