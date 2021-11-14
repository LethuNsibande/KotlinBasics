package com.nsibandelh.practicalassignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends Activity {
    TextView txtName;
    TextView txtSurname;
    TextView txtPassword;
    TextView txtConfirmPassword;
    Button btnRegister;
    String UserName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        txtName = (TextView) findViewById(R.id.txtName);
        txtSurname = (TextView) findViewById(R.id.txtSurname);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtConfirmPassword = (TextView) findViewById(R.id.txtConfirmPassword);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString()) ) {
                    UserName = txtSurname.getText().toString().toLowerCase() + txtName.getText().toString().substring(0, 1).toLowerCase();

                    Toast.makeText(registration.this, "account was successfully created", Toast.LENGTH_LONG).show();

                    Toast.makeText(registration.this, "Your UserName is " + UserName, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(registration.this, login.class);
                    intent.putExtra("password", txtPassword.getText().toString());
                    intent.putExtra("username", UserName);

                    startActivity(intent);

                }
            }
        });
    }
}
