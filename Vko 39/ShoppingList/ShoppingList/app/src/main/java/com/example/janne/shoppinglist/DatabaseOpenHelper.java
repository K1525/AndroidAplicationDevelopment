package com.example.janne.shoppinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "JH_database";
    private final String DATABASE_TABLE = "shoppingList";
    private final String NAME = "name";
    private final String AMOUNT = "amount";
    private final String PRICE = "price";

    public DatabaseOpenHelper(Context context) {
        // Context, database name, optional cursor factory, database version
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create a new table
        db.execSQL("CREATE TABLE "+DATABASE_TABLE+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+AMOUNT+" REAL, "+PRICE+" REAL);");
        // create sample data
        ContentValues values = new ContentValues();
        values.put(NAME, "Omena");
        values.put(AMOUNT, 1);
        values.put(PRICE, 2);
        // insert data to database, name of table, "Nullcolumnhack", values
        db.insert(DATABASE_TABLE, null, values);
        // a more data...
        values.put(NAME, "Peruna");
        values.put(AMOUNT, 3);
        values.put(PRICE, 4);
        db.insert(DATABASE_TABLE, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
        onCreate(db);
    }
}