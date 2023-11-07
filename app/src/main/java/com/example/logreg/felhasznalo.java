package com.example.logreg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public abstract class felhasznalo extends SQLiteOpenHelper {
    private static final String DB_NAME="Regisztracio.db";
    private static final int DB_VERSION =1;
    private static final String COL_ID="id";
    private static final String TABLE_NAME = "Felhasznalo";
    private static final String COL_EMAIL="email";
    private static final String COL_FELHNEV="felhnev";
    private static final String COL_JELSZO = "jelszo";
    private static final String COL_TELJESNEV = "teljesnev";
    public felhasznalo(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String sql="CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_EMAIL + " TEXT NOT NULL, "+
                COL_FELHNEV+ " TEXT NOT NULL, "+
                COL_JELSZO+" TEXT NOT NULL, "+
                COL_TELJESNEV+" TEXT NOT NULL"+
                ");";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(
                "DROP TABLE IF EXISTS "+TABLE_NAME
        );
        onCreate(sqLiteDatabase);
    }
    public boolean regisztracio(String email, String felhnev, String jelszo,String teljesnev)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_EMAIL, email);
        values.put(COL_FELHNEV, felhnev);
        values.put(COL_JELSZO, jelszo);
        values.put(COL_TELJESNEV, teljesnev);
        long result = database.insert(TABLE_NAME,null,values);
        if (result!=-1)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
