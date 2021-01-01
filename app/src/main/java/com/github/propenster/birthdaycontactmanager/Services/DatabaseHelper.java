package com.github.propenster.birthdaycontactmanager.Services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.github.propenster.birthdaycontactmanager.Models.Contact;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "";
    public static final String TABLE_NAME = "BirthdayContacts";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "birthdayContactName";
    public static final String COL_3 = "birthdayContactPhone";
    public static final String COL_4 = "birthDate";
    //public static final String COL_5 = "birthdayContactImage";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " + COL_3 + " TEXT," + COL_4 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, contact.getContactName());
        contentValues.put(COL_3, contact.getContactPhone());
        contentValues.put(COL_4, contact.getContactBirthDate().toString());

        Log.d(TAG, "Adding Birthday Contact" + contact + " to the Database Table " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        //check if data is inserted correctly
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}
