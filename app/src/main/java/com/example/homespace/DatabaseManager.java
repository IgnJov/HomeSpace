package com.example.homespace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c){
        context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(){
        ContentValues values = new ContentValues();
        values.put("category_name", "Food");
        database.insert("category", null, values);
    }

    public String show(){
        String[] columns = new String[] {"category_name"};
        Cursor cursor = database.query("category", columns, null, null, null, null, null);

        String text = null;
        if(cursor != null){
            if(cursor.moveToFirst())

                text = cursor.getString(cursor.getColumnIndexOrThrow("category_name"));
        }

        return text;
    }
}
