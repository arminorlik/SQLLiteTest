package com.example.armin.sqllitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Armin on 2017-04-11.
 */

class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "tabela_tras";
    private static final String COL1 = "ID";
    private static final String COL2 = "start";
    private static final String COL3 = "koniec";
    private static final String COL4 = "czas";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL2 + " TEXT," + COL3 + " TEXT," + COL4 + " TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXIST " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean addData(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, "Karmelkowa");
        contentValues.put(DatabaseHelper.COL3, "Wólka");
        contentValues.put(DatabaseHelper.COL4, item);

        Log.d(TAG, "AddData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String querry = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(querry, null);
        return data;

    }
}
