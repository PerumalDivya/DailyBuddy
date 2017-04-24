package com.example.keerthana.dailybud.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.keerthana.dailybud.data.DetailsContract.Entry;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "budget";
    private static final int DATABASE_VERSION = 1;
    public DbHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE " + Entry.TABLE_NAME + " ("
                + Entry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Entry.COLUMN_INITIAL_AMOUNT + " INTEGER, "
                + Entry.COLUMN_FOOD + " INTEGER, "
                + Entry.COLUMN_FUEL + " INTEGER, "
                + Entry.COLUMN_ENTERTAINMENT + " INTEGER, "
                + Entry.COLUMN_FRUITS_VEGETABLES + " INTEGER, "
                + Entry.COLUMN_GROCERY + " INTEGER, "
                + Entry.COLUMN_SHOPPING + " INTEGER, "
                + Entry.COLUMN_OTHERS + " INTEGER, "
                + Entry.COLUMN_TOTAL + " INTEGER, "
                + Entry.COLUMN_BALANCE + " INTEGER);";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
