package com.nsibandelh.sicktest2021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    EditText txtUsername;
    EditText txtPassword;

    CheckBox chkRememberPassword;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtUserPassword);

        chkRememberPassword = findViewById(R.id.chkRememberPassword);

        String sUsername = getIntent().getStringExtra("username");
        String sPassword = getIntent().getStringExtra("password");

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sUsername.equals(txtUsername.getText().toString())) {
                    toastMessage("sPassword: " + sPassword
                            + "\ntxtPassword:" + txtPassword.getText().toString());

                    if (sPassword.equals(txtPassword.getText().toString())) {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        intent.putExtra("username", sUsername);
                        startActivity(intent);
                    } else
                        toastMessage("The password entered is incorrect.");
                }
                else
                    toastMessage("The username entered is incorrect.");
            }
        });
    }

    public void toastMessage(String sMessage) {
        Toast.makeText(getBaseContext(), sMessage, Toast.LENGTH_SHORT).show();
    }
}
