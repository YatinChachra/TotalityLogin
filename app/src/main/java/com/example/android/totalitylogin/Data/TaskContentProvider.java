package com.example.android.totalitylogin.Data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.example.android.totalitylogin.Data.Contract.FirstTable.TABLE_NAME;

/**
 * Created by 300 on 5/1/2018.
 */

public class TaskContentProvider extends ContentProvider {


    //STEP 1
    private Helper mDbHelper;


    // STEP 5
    public static final int TASKS=100;

    public static final UriMatcher sUriMatcher=buildUriMatcher();

    public static UriMatcher buildUriMatcher()
    {UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

        //FOR IDENTIFING URI OF ACCCESSING WHOLE TABLE
        uriMatcher.addURI(Contract.AUTHORITY,Contract.PATH_TASKS,TASKS);

        return uriMatcher;

    }

    //STEP5



    @Override
    public boolean onCreate() {
        Context context=getContext();
        mDbHelper=new Helper(context);

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {


        // COMPLETED (1) Get access to underlying database (read-only for query)
        final SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // COMPLETED (2) Write URI match code and set a variable to return a Cursor
        int match = sUriMatcher.match(uri);
        Cursor retCursor;

        // COMPLETED (3) Query for the tasks directory and write a default case
        switch (match) {
            // Query for the tasks directory
            case TASKS:
                retCursor =  db.query(TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            // Default exception
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        // COMPLETED (4) Set a notification URI on the Cursor and return that Cursor
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);

        // Return the desired Cursor
        return retCursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
