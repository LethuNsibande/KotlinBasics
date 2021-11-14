package com.nsibandelh.practicalassignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends Activity {
    TextView txtUserName;
    TextView txtLoginPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        txtUserName = (TextView) findViewById(R.id.txtUserName);
        txtLoginPassword = (TextView) findViewById(R.id.txtLoginPassword);

        final String sPassword = getIntent().getStringExtra("password");
        final String sUsername = getIntent().getStringExtra("username");

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUserName.getText().toString().equals(sUsername))
                    if (txtLoginPassword.getText().toString().equals(sPassword)){
                        Intent data = new Intent(login.this, MainActivity.class);

                        final Intent intent = data.putExtra("password", sPassword);
                        data.putExtra("username", sUsername);

                        startActivity(data);
                    }


            }
        });
    }
}