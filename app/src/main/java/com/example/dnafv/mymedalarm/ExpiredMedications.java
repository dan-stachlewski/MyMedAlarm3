package com.example.dnafv.mymedalarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExpiredMedications extends HomeMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expired_medications);
    }

    /***
     * This Method Controls what the Buttons on the Activity Do - they will send the user to the
     * corresponding Activity
     */
    public void onButtonClick(View v){
        //Send user back to the MedicationApp Home Activity
        if(v.getId() == R.id.BtnHome){
            Intent i = new Intent(ExpiredMedications.this, HomeMenuActivity.class);
            startActivity(i);
        }
    }
}
