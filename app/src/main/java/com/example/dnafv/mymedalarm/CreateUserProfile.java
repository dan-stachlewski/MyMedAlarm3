package com.example.dnafv.mymedalarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateUserProfile extends HomeMenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_profile);
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
