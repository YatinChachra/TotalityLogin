package com.example.android.totalitylogin.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_DATE;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_EMAIL;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_ID;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_PASSWORD;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.TABLE_NAME;

/**
 * Created by 300 on 5/1/2018.
 */

//1. class impl SQLiteOpenHelper
public class Helper extends SQLiteOpenHelper
{

    //2.String constant for db name
    public static final String DATABASE_NAME="totality.db";

    //3.int constant for db version
    public static final int DATABASE_VERSION=1;

    //4. String constant for SQLite Table create command
    public static final String SQL_CREATE_TABLE =  "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_EMAIL+ " TEXT, "
            + COLUMN_PASSWORD+ " TEXT, "
            + COLUMN_DATE+ " TEXT"
            + ");";

    //5. CONSTRUCTOR
    public Helper(Context context)
    {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
        SQLiteDatabase db=this.getWritableDatabase();
    }


    //6.override onCreate


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

    }

    //7. override onUpgrade


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
}
