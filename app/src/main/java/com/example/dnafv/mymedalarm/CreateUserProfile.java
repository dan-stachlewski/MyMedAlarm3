package com.example.dnafv.mymedalarm;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class CreateUserProfile extends HomeMenuActivity {
    //Create an Instance of the DatabaseHelper Class so that when the onCreate() starts it will
    // trigger the myDB and call the constructor of the DatabaseHelper Class which creates the
    // database and tables
    DatabaseHelper myDB;

    //EditText & Button Variables that need to be defined on the CreateUserActivity to connect
    // the data from the TextFields to the Database
    EditText edit_first_name,
             edit_last_name,
             edit_blood_group,
             edit_contact_number,
             edit_date_of_birth,
             edit_email_address;
    //ImageView edit_profile_image;
    Button button_submit_user_profile;
    Button button_view_user_profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user_profile);
        //When the HomeMenuActivity is created, it will call the DatabaseHelper Class and the Constructor
        // will create a NEW Database and create the tables if they don't already exist.
        myDB = new DatabaseHelper(this);

        edit_first_name = (EditText)findViewById(R.id.TxtFldFirstName);
        edit_last_name = (EditText)findViewById(R.id.TxtFldLastName);
        edit_blood_group = (EditText)findViewById(R.id.TxtFldBloodGroup);
        edit_contact_number = (EditText)findViewById(R.id.TxtFldContactNumber);
        edit_date_of_birth = (EditText)findViewById(R.id.TxtFldDOB);
        edit_email_address = (EditText)findViewById(R.id.TxtFldEMailAddress);
        //edit_profile_image = (EditText)findViewById(R.id.ImgUserProfile);
        //edit_profile_image = (ImageView)findViewById(R.id.ImgUserProfile);

        button_submit_user_profile = (Button)findViewById(R.id.BtnSubmitUserProfileData);
        button_view_user_profile = (Button)findViewById(R.id.BtnViewUserProfile);

        //Add the AddData Method to the onCreate Method for CreateUserProfile Activity so that when
        // the Submit Details Btn is clicked the data will be added to the Database.
        AddData();

        viewAllUserData();
    }

    public void AddData(){
        button_submit_user_profile.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertUserData(edit_first_name.getText().toString(),
                                edit_last_name.getText().toString(),
                                edit_blood_group.getText().toString(),
                                edit_contact_number.getText().toString(),
                                edit_date_of_birth.getText().toString(),
                                edit_email_address.getText().toString());
                                //edit_profile_image.getDrawable().toString()
                        if(isInserted = true){
                            Toast.makeText(CreateUserProfile.this, "Data Inserted Successfully", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(CreateUserProfile.this, "Data Failed to Save!", Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }

    public void viewAllUserData(){
        button_view_user_profile.setOnClickListener(
            new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Cursor queryResult = myDB.getAllUserData();
                    if(queryResult.getCount() == 0){
                        //No Data in Table show error
                        showMessage("Error", "No data found!");
                        return;
                    }

                    //If there is a result = display Data
                    StringBuffer buffer = new StringBuffer();
                    while(queryResult.moveToNext()){
                        buffer.append("USER_ID :" + queryResult.getString(0) + "\n");
                        buffer.append("FIRST_NAME :" + queryResult.getString(1) + "\n");
                        buffer.append("LAST_NAME :" + queryResult.getString(2) + "\n");
                        buffer.append("BLOOD_GROUP :" + queryResult.getString(3) + "\n");
                        buffer.append("CONTACT_NUMBER :" + queryResult.getString(4) + "\n");
                        buffer.append("DOB :" + queryResult.getString(5) + "\n");
                        buffer.append("EMAIL_ADDRESS :" + queryResult.getString(6) + "\n\n");
                    }
                    //Show All Data:
                    showMessage("Data", buffer.toString());
                    return;
                }
            }
       );
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
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
