package com.github.propenster.birthdaycontactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.propenster.birthdaycontactmanager.Models.Contact;
import com.github.propenster.birthdaycontactmanager.Services.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import java.time.DateTimeException;
import java.util.Date;

public class AddBirthdayContactActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText editTextBirthDateContactName;
    EditText editTextPhone;
    EditText editBirthDate;
    Button btn_addNewBirthDayContactSubmit;
    Contact mycontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_birthday_contact);

        databaseHelper = new DatabaseHelper(AddBirthdayContactActivity.this);
        editTextBirthDateContactName = findViewById(R.id.editTextTextPersonName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editBirthDate = findViewById(R.id.editTextDate2);
        btn_addNewBirthDayContactSubmit = findViewById(R.id.btn_addNewBirthDayContactSubmit);
        mycontact.setContactName(editTextBirthDateContactName.toString());
        mycontact.setContactPhone(editTextPhone.toString());
        mycontact.setContactBirthDate(new Date());

        btn_addNewBirthDayContactSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextBirthDateContactName.getText().toString() != "" && editTextPhone.getText().toString() != ""){
                    insertData(mycontact);
                    editTextBirthDateContactName.setText("");
                    editTextPhone.setText("");
                    editBirthDate.setText("");
                }else{
                    Toast.makeText(AddBirthdayContactActivity.this, "You must put something in the TextFields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void insertData(Contact contact){
        boolean insertDataStatus = databaseHelper.addData(mycontact);
        if(insertDataStatus){
            Toast.makeText(this, "Data successfully inserted in DB", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Something went wrong. Data was not successfully inserted", Toast.LENGTH_SHORT).show();
        }

    }



}