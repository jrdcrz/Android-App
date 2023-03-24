package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usernameEDT, emailEDT, passwordEDT;
    Button registerBTN, loginBTN;
    DBHelper loginDB;

    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btnRegister1:
                if(usernameEDT.length() <= 0 || passwordEDT.length() <= 0 || emailEDT.length() <= 0){
                    Toast.makeText(RegisterActivity.this,"Please input username, email, and password!", Toast.LENGTH_SHORT ).show();
                } else {
                    loginDB = new DBHelper(this);
                    boolean isUserDataInserted = loginDB.insertUserData(usernameEDT.getText().toString(),emailEDT.getText().toString(),passwordEDT.getText().toString());
                    if(isUserDataInserted == true) {
                        Toast.makeText(RegisterActivity.this,"New user successfully added!", Toast.LENGTH_SHORT ).show();
                    } else {
                        Toast.makeText(RegisterActivity.this,"New user failed to be added!", Toast.LENGTH_SHORT ).show();
                    }
                }
                break;
            case R.id.btnLogin:
                Toast.makeText(RegisterActivity.this, "Redirecting to Login...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEDT = (EditText) findViewById(R.id.username);
        emailEDT = (EditText) findViewById(R.id.email);
        passwordEDT = (EditText) findViewById(R.id.password);
        registerBTN = (Button) findViewById(R.id.btnRegister1);
        registerBTN.setOnClickListener(this);
        loginBTN = (Button) findViewById(R.id.btnLogin);
        loginBTN.setOnClickListener(this);
    }
}