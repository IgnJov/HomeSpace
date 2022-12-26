package com.example.homespace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "HomeSpace";

    //Table names
//    private static final String[] TABLE_NAME = {"categories", "items", "shopping_list", "events"};
    private static final String TABLE_CATEGORY = "categories";

    //Table Column
    private static final String ID = "category_id";
    private static final String NAME = "category_name";

//    //Table scheme
//    private static final String[] CREATE_TABLE = {
//            //Categories table
//            "CREATE TABLE " + "categories" + " (" +
//                    "category_id" + " INTEGER PRIMARY KEY," +
//                    "category_name" + " TEXT" +
//                    ");"
//
////            //Items table
////            "CREATE TABLE " + "items" + " (" +
////            "item_id" + " INTEGER PRIMARY KEY," +
////            "category_id" + " INTEGER," +
////            "FOREIGN KEY (category_id) REFERENCES categories(category_id)," +
////            "item_name" + " TEXT," +
////            "price" + " INTEGER," +
////            "stock" + " INTEGER," +
////            "expired_date" + " TEXT" +
////            ");",
////
////            //Shopping List table
////            "CREATE TABLE " + "shopping_list" + " (" +
////                    "shopping_list_id" + " INTEGER PRIMARY KEY," +
////                    "item_name" + " TEXT," +
////                    "status" + " INTEGER" +
////                    ");",
////
////            //Events List table
////            "CREATE TABLE " + "events" + " (" +
////                    "event_id" + " INTEGER PRIMARY KEY," +
////                    "event_detail" + " TEXT," +
////                    "event_type" + " TEXT," +
////                    "event_date" + " TEXT," +
////                    "amount" + " INTEGER" +
////                    ");"
//    };

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        for(int i = 0; i < CREATE_TABLE.length; i++){
//            sqLiteDatabase.execSQL(CREATE_TABLE[i]);
//        }
        String CREATE_CATEGORY_TABLE =
            "CREATE TABLE " + TABLE_CATEGORY + " (" +
                    ID + " INTEGER PRIMARY KEY," +
                    NAME + " TEXT" +
                    ");";
        sqLiteDatabase.execSQL(CREATE_CATEGORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
//        for(int i = 0; i < CREATE_TABLE.length; i++){
//            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME[i]);
//        }
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        onCreate(sqLiteDatabase);
    }

    public void addRecord(){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("category_name", "Food");
        db.insert("category", null, values);

        db.close();
    }

    public String getCategory(){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {ID, NAME};
        Cursor cursor = db.rawQuery(DatabaseHelper);

        String text = "Hello";
        if(cursor != null){
            cursor.moveToFirst();
            text = cursor.getString(cursor.getColumnIndexOrThrow(NAME));
        }else{
            text = "Error";
        }

        return text;
    }
}
