package com.example.dnafv.mymedalarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateUserProfile extends HomeMenuActivity {
    //Create an Instance of the DatabaseHelper Class so that when the onCreate() starts it will
    // trigger the myDB and call the constructor of the DatabaseHelper Class which creates the
    // database and tables
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_profile);
        //When the HomeMenuActivity is created, it will call the DatabaseHelper Class and the Constructor
        // will create a NEW Database and create the tables if they don't already exist.
        myDB = new DatabaseHelper(this);
    }


    /***
     * This Method Controls what the Buttons on the Activity Do - they will send the user to the
     * corresponding Activity
     */

    public void onButtonClick(View v){
        //Sends user back to Home Activity
        if(v.getId() == R.id.BtnHome){
            Intent i = new Intent(CreateUserProfile.this, HomeMenuActivity.class);
            startActivity(i);
        }
    }
}
