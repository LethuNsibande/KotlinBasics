package com.nsibandelh.exampractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static String TABLE_NAME = "students_table";
    private static String COL1 = "Class Of";
    private static String COL2 = "Student Number";
    private static String COL3 = "First Name";
    private static String COL4 = "Last Name";
    private static String COL5 = "Age";
    private static String COL6 = "Gender";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ("
                + COL3 + " INTEGER PRIMARY KEY, "
                + COL1 + " INTEGER, "
                + COL3 + " STRING, "
                + COL4 + " STRING, "
                + COL5 + " STRING, "
                + COL6 + " STRING, "

                + COL2 + " int, "

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
