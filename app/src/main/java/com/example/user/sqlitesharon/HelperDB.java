package com.example.user.sqlitesharon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import static com.example.user.sqlitesharon.Table1.KEY_ID;
import static com.example.user.sqlitesharon.Table1.NAMEGUEST;
import static com.example.user.sqlitesharon.Table1.NAMEHOME;
import static com.example.user.sqlitesharon.Table1.TABLE_TABLE1;
import static com.example.user.sqlitesharon.Table2.KEY_ID2;
import static com.example.user.sqlitesharon.Table2.NAMETEAM;
import static com.example.user.sqlitesharon.Table2.NUMBERLOSSES;
import static com.example.user.sqlitesharon.Table2.NUMBERVICTORIES;
import static com.example.user.sqlitesharon.Table2.TABLE_TABLE2;

public class HelperDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dbgames.db";
    private static final int DATABASE_VERSION = 1;

    public HelperDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, String strCreate, String strDelete) {
        super(context, name, factory, version);
        this.strCreate = strCreate;
        this.strDelete = strDelete;
    }

    public HelperDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_TABLE1;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAMEHOME+" TEXT,";
        strCreate+=" "+NAMEGUEST+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_TABLE2;
        strCreate+=" ("+KEY_ID2+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAMETEAM+" TEXT,";
        strCreate+=" "+NUMBERVICTORIES+" TEXT,";
        strCreate+=" "+NUMBERLOSSES+" TEXT";
        strCreate+=");";
        db.execSQL(strCreate);
    }

    String strCreate, strDelete;
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_TABLE1;
        db.execSQL(strDelete);

        strDelete="DROP TABLE IF EXISTS "+TABLE_TABLE2;
        db.execSQL(strDelete);

        onCreate(db);
    }
}