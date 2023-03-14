package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    private EditText username , password;
    private Button loginBtn, registerBtn;

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                if(username.length() <= 0 || password.length() <= 0){
                    Toast.makeText(LoginActivity.this,"Please input username and password!", Toast.LENGTH_SHORT ).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Redirecting to Dashboard", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnRegister:
                Toast.makeText(LoginActivity.this, "Redirecting to Register...", Toast.LENGTH_LONG).show();
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(this);
        registerBtn = findViewById(R.id.btnRegister);
        registerBtn.setOnClickListener(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

}