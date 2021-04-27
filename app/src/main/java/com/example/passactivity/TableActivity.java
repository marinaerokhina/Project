package com.example.passactivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class TableActivity extends AppCompatActivity {

        TextView textView;
        ListView listView;
        EditText personFilter;
        DataBaseHelper dataBaseHelper;
        SQLiteDatabase db;
        Cursor userCursor;

        ArrayAdapter<Person> personAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_table);
            textView = findViewById(R.id.textview);
            listView = findViewById(R.id.list);

            dataBaseHelper = new DataBaseHelper(getApplicationContext());

            dataBaseHelper.create_db();

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Person person = personAdapter.getItem(position);
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("login", person.getLogin());
                    startActivity(intent);
                }
            });

        }

        @Override
        protected void onResume() {
            super.onResume();
            try {
                DataBaseAdapter adapter= new DataBaseAdapter(this);
                adapter.open();
                db = dataBaseHelper.open();
                List<Person> persons = adapter.getPersons();
                personAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,persons);

                /*if (!personFilter.getText().toString().isEmpty())
                    personAdapter.getFilter().filter(personFilter.getText().toString());
                personFilter.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        personAdapter.getFilter().filter(s.toString());
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });*/

                listView.setAdapter(personAdapter);
                adapter.close();
            } catch (SQLException e) {
            }
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            db.close();
            //   userCursor.close();
        }
}

