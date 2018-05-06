package com.example.android.totalitylogin;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.totalitylogin.Data.Helper;

import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_DATE;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_EMAIL;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.COLUMN_PASSWORD;
import static com.example.android.totalitylogin.Data.Contract.FirstTable.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private Helper mDHelper;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mDHelper=new Helper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onBackPressed(){
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


    public void loginButton(View view)
    {
        EditText e11=(EditText)findViewById(R.id.loginEmail);
        EditText e12=(EditText)findViewById(R.id.loginPassword);
        String enteredEmail=String.valueOf(e11.getText());
        String enteredPassword=String.valueOf(e12.getText());


        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new java.util.Date());

        if(enteredEmail.length()>0&&enteredPassword.length()>0) {
            SQLiteDatabase db = mDHelper.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put(COLUMN_EMAIL, enteredEmail);
            val.put(COLUMN_PASSWORD, enteredPassword);
            val.put(COLUMN_DATE, currentDateTimeString);


            long result = db.insert(TABLE_NAME, null, val);
            if (result != -1) {
                Log.i("MainActivity.java", "Record Inserted");
                /*Context context = getApplicationContext();
                CharSequence text = "Processing.."; //data inserted
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
*/
                Intent i = new Intent(this, GoToActivity.class);
                startActivity(i);
            } else {
                Log.i("MainActivity.java", "Record Not Inserted");
                Context context = getApplicationContext();
                CharSequence text = "Unable to Login";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Fill the credentials";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
    }
}
