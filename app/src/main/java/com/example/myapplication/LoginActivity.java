package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener  {

    private EditText username , password;
    private Button loginBtn, registerBtn;
    private Intent intent;
    private DBHelper loginDB = new DBHelper(this);
    private Cursor cursor;

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
                if(username.length() <= 0 || password.length() <= 0){
                    Toast.makeText(LoginActivity.this,"Please input username and password!", Toast.LENGTH_SHORT ).show();
                } else {
                    cursor = loginDB.readUserData();
                    if(cursor.getCount() <1) {
                        Toast.makeText(LoginActivity.this, "There is no user data available!", Toast.LENGTH_LONG).show();
                    } else {
                        while(cursor.moveToNext()) {
                            if(cursor.getString(1).equals(username.getText().toString()) && cursor.getString(2).equals(password.getText().toString())) {
                                Toast.makeText(LoginActivity.this, "Redirecting to Dashboard", Toast.LENGTH_LONG).show();
                                intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(LoginActivity.this, "Invalid username/password!", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
                break;
            case R.id.btnRegister:
                Toast.makeText(LoginActivity.this, "Redirecting to Register...", Toast.LENGTH_LONG).show();
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

}