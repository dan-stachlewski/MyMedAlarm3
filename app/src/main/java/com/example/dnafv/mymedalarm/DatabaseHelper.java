package com.example.dnafv.mymedalarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//We need to Extend the DatabaseHelper using the SQLiteOpenHelper Class which has a number of Methods
// & a Constructor that need to be instantiated

public class DatabaseHelper extends SQLiteOpenHelper {

    //Declare Variables to Create the DATABASE & the TABLES within the Database:

    //LogCat Tag:
    private static final String LOG = "DatabaseHelper";

    //Database Version
    private static final int DATABASE_VERSION = 2;

    //DATABASE NAME:
    public static final String DATABASE_NAME = "med_alarm.db";


    //TABLE NAMES:
    public static final String TABLE_NAME_USER_PROFILE = "user_profile";
    public static final String TABLE_NAME_MEDICATIONS = "medications";
    public static final String TABLE_NAME_MEDICATION_IMAGES = "medication_images";
    public static final String TABLE_NAME_MEDICATION_NOTIFICATIONS = "medication_notifications";
    public static final String TABLE_NAME_EXPIRED_NOTIFICATIONS = "expired_notifications";

    //COMMON - Column Names
    //private static final String KEY_ID = "id";
    //private static final String KEY_CREATED_AT = "created_at";

    //TABLE COLUMN_NAMES:
    //USER_PROFILE Table - Column Names
    private static final String USER_ID = "user_id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String BLOOD_GROUP = "blood_group";
    private static final String CONTACT_NUMBER = "contact_number";
    private static final String DOB = "date_of_birth";
    private static final String EMAIL_ADDRESS = "email_address";
    //private static final String PROFILE_IMAGE = "profile_image";

    //MEDICATIONS Table - Column Names
    private static final String MEDICATION_ID = "medication_id";
    private static final String MEDICATION_NAME = "medication_name";
    private static final String MEDICATION_DOSE = "medication_dose";
    private static final String TABLET_COUNT = "tablet_count";
    private static final String MEDICATION_EXPIRY_DATE = "medication_expiry_date";
    private static final String DOSE_START_DATE  = "dose_start_date";
    private static final String DOSE_START_TIME  = "dose_start_time";
    private static final String REPEAT_EVERY  = "repeat_every";
    private static final String FINISH_AFTER  = "finish_after";
    private static final String LAST_DOSE_TAKEN_DATE  = "last_dose_taken_date";
    private static final String LAST_DOSE_TAKEN_TIME  = "last_dose_taken_time";

    //MEDICATION_IMAGES Table - Column Names
    private static final String MEDICATION_IMAGE_ID = "medication_image_id";
//    private static final String MEDICATION_ID = "medication_id";
    private static final String MEDICATION_NAME_IMAGE = "medication_name_image";
    private static final String MEDICATION_BOX_IMAGE = "medication_image_box";
    private static final String MEDICATION_TABLET_IMAGE = "medication_image_tablet";

    //MEDICATION_NOTIFICATIONS Table - Column Names
    private static final String MEDICATION_NOTIFICATION_ID = "notification_id";
    /*
    private static final String MEDICATION_ID = "medication_id";
    private static final String MEDICATION_IMAGE_ID = "medication_image_id";
    private static final String MEDICATION_NAME = "medication_name";
    private static final String MEDICATION_DOSE = "medication_dose";
    private static final String TABLET_COUNT = "tablet_count";

    private static final String DOSE_START_DATE  = "dose_start_date";
    private static final String DOSE_START_TIME  = "dose_start_time";
    private static final String REPEAT_EVERY  = "repeat_every";
    private static final String FINISH_AFTER  = "finish_after";
    private static final String LAST_DOSE_TAKEN_DATE  = "last_dose_taken_date";
    private static final String LAST_DOSE_TAKEN_TIME  = "last_dose_taken_time";
    private static final String MEDICATION_IMAGE_BOX = "medication_image_box";
    private static final String MEDICATION_IMAGE_TABLET = "medication_image_tablet";
    */

    //EXPIRED_MEDICATIONS Table - Column Names
    private static final String EXPIRED_NOTIFICATION_ID = "notification_id";
    /*
    private static final String MEDICATION_ID = "medication_id";
    private static final String MEDICATION_IMAGE_ID = "medication_image_id";
    private static final String MEDICATION_NAME = "medication_name";
    private static final String MEDICATION_DOSE = "medication_dose";
    private static final String TABLET_COUNT = "tablet_count";

    private static final String DOSE_START_DATE  = "dose_start_date";
    private static final String DOSE_START_TIME  = "dose_start_time";
    private static final String REPEAT_EVERY  = "repeat_every";
    private static final String FINISH_AFTER  = "finish_after";
    private static final String LAST_DOSE_TAKEN_DATE  = "last_dose_taken_date";
    private static final String LAST_DOSE_TAKEN_TIME  = "last_dose_taken_time";
    private static final String MEDICATION_IMAGE_BOX = "medication_image_box";
    private static final String MEDICATION_IMAGE_TABLET = "medication_image_tablet";
    */


    //TABLE CREATE STATEMENTS:
    //USER_PROFILE Table - Create Statement
    private static final String CREATE_TABLE_USER_PROFILE = "CREATE TABLE "
            + TABLE_NAME_USER_PROFILE + "("
            + USER_ID + " integer PRIMARY KEY AUTOINCREMENT,"
            + FIRST_NAME +" text NOT NULL, "
            + LAST_NAME + " text NOT NULL, "
            + BLOOD_GROUP + " text NOT NULL, "
            + CONTACT_NUMBER + " text NOT NULL, "
            + DOB + " text NOT NULL, "
            + EMAIL_ADDRESS + " text NOT NULL"
            + ")";
    /*
    private static final String CREATE_TABLE_USER_PROFILE = "CREATE TABLE "
            + TABLE_NAME_USER_PROFILE + "("
            + USER_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + FIRST_NAME +" text NOT NULL, "
            + LAST_NAME + " text NOT NULL, "
            + BLOOD_GROUP + " text NOT NULL, "
            + CONTACT_NUMBER + " integer NOT NULL, "
            + DOB + " date NOT NULL, "
            + EMAIL_ADDRESS + " text NOT NULL, "
            + KEY_CREATED_AT + " datetime NOT NULL,"
            + PROFILE_IMAGE + " blob NOT NULL"
            + ")";
       */

    //MEDICATIONS Table - Create Statement
    private static final String CREATE_TABLE_MEDICATIONS = "CREATE TABLE "
            + TABLE_NAME_MEDICATIONS + "("
            + MEDICATION_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + MEDICATION_NAME +" text NOT NULL, "
            + MEDICATION_DOSE + " integer NOT NULL, "
            + TABLET_COUNT + " integer NOT NULL, "
            + MEDICATION_EXPIRY_DATE + " date NOT NULL, "
            + DOSE_START_DATE + " date NOT NULL, "
            + DOSE_START_TIME + " time NOT NULL, "
            + REPEAT_EVERY + " integer NOT NULL, "
            + FINISH_AFTER + " integer NOT NULL, "
            + LAST_DOSE_TAKEN_DATE + " date NOT NULL, "
            + LAST_DOSE_TAKEN_TIME + " time NOT NULL "
            + ")";

    //MEDICATION_IMAGE Table - Create Statement
    // Need to Add Mediation_ID (FK)
    private static final String CREATE_TABLE_MEDICATION_IMAGE = "CREATE TABLE "
            + TABLE_NAME_MEDICATION_IMAGES + "("
            + MEDICATION_IMAGE_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT,"
            + MEDICATION_NAME_IMAGE +" blob NOT NULL, "
            + MEDICATION_BOX_IMAGE +" blob NOT NULL, "
            + MEDICATION_TABLET_IMAGE +" blob NOT NULL "
            + ")";

    //MEDICATION_NOTIFICATION Table - Create Statement
    // Need to Add Mediation_ID (FK)
    private static final String CREATE_TABLE_MEDICATION_NOTIFICATIONS = "CREATE TABLE "
            + TABLE_NAME_MEDICATION_NOTIFICATIONS + "("
            + MEDICATION_NOTIFICATION_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT"
            + ")";

    //EXPIRED_NOTIFICATIONS Table - Create Statement
    // Need to Add Mediation_ID (FK)
    private static final String CREATE_TABLE_EXPIRED_NOTIFICATIONS = "CREATE TABLE "
            + TABLE_NAME_EXPIRED_NOTIFICATIONS + "("
            + EXPIRED_NOTIFICATION_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT"
            + ")";

    //This is the Constructor that sets up the Database and creates a Connection to the DATABASE & TABLE NAMES
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // We used the below code to view the create Database & Tables.
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE THE REQUIRED TABLES
        db.execSQL(CREATE_TABLE_USER_PROFILE);
        db.execSQL(CREATE_TABLE_MEDICATIONS);
        db.execSQL(CREATE_TABLE_MEDICATION_IMAGE);
        db.execSQL(CREATE_TABLE_MEDICATION_NOTIFICATIONS);
        db.execSQL(CREATE_TABLE_EXPIRED_NOTIFICATIONS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //IF WE WERE TO UPGRADE THE APP AND WE WANTED TO DELETE THE TABLES AND START AGAIN:
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_USER_PROFILE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MEDICATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MEDICATION_IMAGES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_MEDICATION_NOTIFICATIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_EXPIRED_NOTIFICATIONS);

        //CREATE NEW TABLES
        onCreate(db);

    }

    //Insert Data into Database from Form:
    public boolean insertUserData(
            String first_name,
            String last_name,
            String blood_group,
            String contact_number,
            String date_of_birth,
            String email_address){
            //String image_name
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(BLOOD_GROUP, blood_group);
        contentValues.put(CONTACT_NUMBER, contact_number);
        contentValues.put(DOB, date_of_birth);
        contentValues.put(EMAIL_ADDRESS, email_address);
        //contentValues.put(PROFILE_IMAGE, image_name);
        long result = db.insert(TABLE_NAME_USER_PROFILE, null, contentValues);
        //If result = -1 then the values wern't inserted into the database.
        if(result == -1){
            return false;
        }else{
            return true;
        }


    }

}
