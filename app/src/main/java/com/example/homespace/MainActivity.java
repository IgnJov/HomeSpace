package com.example.homespace;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String name;

    //    TextView username;
    TextView viewDate;
    Calendar calendar;
    String current;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        username = findViewById(R.id.username);
//        name = getIntent().getExtras().getString("username");
//        username.setText(name);

        calendar = Calendar.getInstance();
        current = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        viewDate = findViewById(R.id.date);
        viewDate.setText(current);
    }
}