package com.example.homespace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

public class ListItem extends AppCompatActivity {
    private RecyclerView itemList;
    private ArrayList<Item> list = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        itemList = findViewById(R.id.rv_item);
        itemList.setHasFixedSize(true);


    }
}