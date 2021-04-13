package com.example.passactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistActivity extends AppCompatActivity {
    EditText name, surname, status, login, password, age, grade;
    int cnt=0, cnt0=7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        name=findViewById(R.id.Name);
        surname=findViewById(R.id.Surname);
        status=findViewById(R.id.Status);
        login=findViewById(R.id.Login);
        password=findViewById(R.id.Password);
        age=findViewById(R.id.Age);
        grade=findViewById(R.id.Grade);
    }

    public void onRegistration(View view) {
        Person person = new Person();
        name.getText();
        if (name!=null){
            person.setName(name.toString());
            cnt++;
        } else {
            Toast.makeText(this, "@string/name_error", Toast.LENGTH_LONG).show();
        }
        surname.getText();
        if (surname!=null){
            person.setSurname(surname.toString());
            cnt++;
        } else {
            Toast.makeText(this, "@string/surname_error", Toast.LENGTH_LONG).show();
        }
        status.getText();
        if (status.equals("@string/status1")||status.equals("@string/status2")||status.equals("@string/status")){
            person.setStatus(status.toString());
            cnt++;
        } else {
            Toast.makeText(this, "@string/status_error", Toast.LENGTH_LONG).show();
        }
        login.getText();
        if (login!=null){
            person.setLogin(login.toString());
            cnt++;
        } else {
            Toast.makeText(this, "@string/login_error", Toast.LENGTH_LONG).show();
        }
        password.getText();
        if (password!=null){
            person.setPassword(password.toString());
            cnt++;
        } else {
            Toast.makeText(this, "@string/password_error", Toast.LENGTH_LONG).show();
        }
        age.getText();
        if (Integer.parseInt(age.toString())<=0){
            Toast.makeText(this, "@string/age_error1", Toast.LENGTH_LONG).show();
        } else if (age!=null) {
            person.setAge(Integer.parseInt(age.toString()));
            cnt++;
        } else {
            Toast.makeText(this, "@string/age_error2", Toast.LENGTH_LONG).show();
        }
        grade.getText();
        if (Integer.parseInt(grade.toString())<=0){
            Toast.makeText(this, "@string/grade_error1", Toast.LENGTH_LONG).show();
        }
        else if (grade!=null){
            person.setGrade(grade.toString());
            cnt++;
        } else {
            Toast.makeText(this, "@string/grade_error2", Toast.LENGTH_LONG).show();
        }
        if (cnt==cnt0){
            Toast.makeText(this, "@string/reg_success", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RegistActivity.this, RegistActivity.class);
            startActivity(intent);
        }
    }
}
