package com.example.homespace;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HomeSpace.db";

    //Table scheme
    private static final String[] CREATE_TABLE = {
            //Categories table
            "CREATE TABLE " + "categories" + " (" +
                    "category_id" + " INTEGER PRIMARY KEY," +
                    "category_name" + " TEXT" +
                    ");",

            //Items table
            "CREATE TABLE " + "items" + " (" +
            "item_id" + " INTEGER PRIMARY KEY," +
            "category_id" + " INTEGER," +
            "FOREIGN KEY (category_id) REFERENCES categories(category_id)," +
            "item_name" + " TEXT," +
            "price" + " INTEGER," +
            "stock" + " INTEGER," +
            "expired_date" + " TEXT" +
            ");",

            //Shopping List table
            "CREATE TABLE " + "shopping_list" + " (" +
                    "shopping_list_id" + " INTEGER PRIMARY KEY," +
                    "item_name" + " TEXT," +
                    "status" + " INTEGER" +
                    ");",

            //Events List table
            "CREATE TABLE " + "events" + " (" +
                    "event_id" + " INTEGER PRIMARY KEY," +
                    "event_detail" + " TEXT," +
                    "event_type" + " TEXT," +
                    "event_date" + " TEXT," +
                    "amount" + " INTEGER" +
                    ");"
    };

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for(int i = 0; i < CREATE_TABLE.length; i++){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
