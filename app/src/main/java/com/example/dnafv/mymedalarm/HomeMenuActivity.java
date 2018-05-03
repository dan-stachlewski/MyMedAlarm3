package com.example.dnafv.mymedalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
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

        //Send User to Expired Medicaions
        if(v.getId() == R.id.BtnExpiredMedications){
            Intent i = new Intent(HomeMenuActivity.this, ExpiredMedications.class);
                startActivity(i);
        }
    }

}
