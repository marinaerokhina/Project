package com.example.passactivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
    TextView textview;
    EditText login;
    EditText password;
    Button btn;
    String LOGIN;
    String PASSWORD;
    String l;
    String p;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textview = findViewById(R.id.textview);
        btn = findViewById(R.id.btn);
        login = findViewById(R.id.Login);
        password = findViewById(R.id.Password);

    }

    public void CheckPerson(View view) {
        l = login.getText().toString();
        p = password.getText().toString();
        if (LOGIN.equals(l) && PASSWORD.equals(p)) {
            Toast.makeText(this, "@string/log_success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } else if (l == null || p == null) {
            textview.setText("@string/log_error1");
        } else {
            textview.setText("@string/log_error2");
        }
    }


    public void onRegistration(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
        startActivity(intent);
    }
}
