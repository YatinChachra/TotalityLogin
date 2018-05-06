package com.example.android.totalitylogin.Data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by 300 on 5/1/2018.
 */

//1.Outer class
public final class Contract {


    //STEP 3,4
    public static final String AUTHORITY= "com.example.android.totalitylogin";

    public static final Uri BASE_CONTENT_URI= Uri.parse("content://" + AUTHORITY);

    public final static String PATH_TASKS = "login_details";
    //STEP 3,4






    //2.default empty constructor
    private Contract()
    {    }


    //3. Inner Class for table login_details
    public final static class FirstTable implements BaseColumns
    {

        //STEP 3,4

        public final static Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASKS).build();
        //STEP 3,4





        //4. String constants for each Column
        public final static String TABLE_NAME="login_details";
        public static String COLUMN_ID=BaseColumns._ID;
        public static String COLUMN_EMAIL="login_email";
        public static String COLUMN_PASSWORD="login_password";
        public static String COLUMN_DATE="date";

    }


}
