package com.nsibandelh.sicktest2021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RegistrationActivity extends Activity {
    TextView txtName;
    TextView txtSurname;
    TextView txtPassword;
    TextView txtConfirmPassword;

    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        txtName = findViewById(R.id.txtName);
        txtSurname = findViewById(R.id.txtSurname);
        txtPassword = findViewById(R.id.txtPassword);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassword);

        txtPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);

        String sName = txtName.getText().toString();
        String sSurname = txtSurname.getText().toString();
        String sPassword = txtPassword.getText().toString();
        String sConfirmPassword = txtConfirmPassword.getText().toString();

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sPassword.equals(sConfirmPassword)) {
                    String sUsername = txtSurname.getText().toString().toLowerCase()
                            + txtName.getText().toString().substring(0, 1).toLowerCase();

                    toastMessage("account was successfully created");

                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                    intent.putExtra("username", sUsername);
                    intent.putExtra("password", txtPassword.getText().toString());
                    startActivity(intent);
                }
                else
                    toastMessage("Passwords are not the same.");
            }
        });
    }

    public void toastMessage(String sMessage) {
        Toast.makeText(RegistrationActivity.this, sMessage, Toast.LENGTH_SHORT).show();
    }
}
