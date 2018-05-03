package com.example.dnafv.mymedalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeMenuActivity extends AppCompatActivity {


    //Create an Instance of the DatabaseHelper Class so that when the onCreate() starts it will
    // trigger the myDB and call the constructor of the DatabaseHelper Class which creates the
    // database and tables
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
        //When the HomeMenuActivity is created, it will call the DatabaseHelper Class and the Constructor
        // will create a NEW Database and create the tables if they don't already exist.
        myDB = new DatabaseHelper(this);
    }

    /***
     * This Method Controls what the Buttons on the Activity Do - they will send the user to the
     * corresponding Activity
     */

    public void onButtonClick(View v){

        //Send User to User Profile Activity
        if(v.getId() == R.id.BtnMedicationInventory){
            Intent i = new Intent(HomeMenuActivity.this, MedicationInventory.class);
            startActivity(i);
        }

        //Send User to Medication Inventory Activity
        if(v.getId() == R.id.BtnUserProfile){
            Intent i = new Intent(HomeMenuActivity.this, UserProfile.class);
            startActivity(i);
        }

        //Send User to Add New Medication
        if(v.getId() == R.id.BtnAddNewMedication){
            Intent i = new Intent(HomeMenuActivity.this, AddNewMedication.class);
            startActivity(i);
        }

        //Send User to Notifications
        if(v.getId() == R.id.BtnNotifications){
            Intent i = new Intent(HomeMenuActivity.this, Notifications.class);
            startActivity(i);
        }

        //Send User to Expired Medications Activity
        if(v.getId() == R.id.BtnExpiredMedications){
            Intent i = new Intent(HomeMenuActivity.this, ExpiredMedications.class);
                startActivity(i);
        }

        //Send User to Create User Profile Activity
        if(v.getId() == R.id.BtnCreateUserProfile){
            Intent i = new Intent(HomeMenuActivity.this, CreateUserProfile.class);
            startActivity(i);

        }
    }

}
