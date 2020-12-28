package com.github.propenster.birthdaycontactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.github.propenster.birthdaycontactmanager.Models.Contact;

public class SingleBirthContactActivity extends AppCompatActivity {
    Contact passedContact;
    EditText edt_birthContactName, edt_birthContactPhone, edt_birthdayContactBirthDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_birth_contact);
        edt_birthContactName = (EditText)findViewById(R.id.edt_birthContactName);
        edt_birthContactPhone = (EditText)findViewById(R.id.edt_birthContactPhone);
        edt_birthdayContactBirthDate = (EditText)findViewById(R.id.edt_birthdayContactBirthDate);

        displaySingleBirthContact();
    }

    private void displaySingleBirthContact() {
        Intent intent = getIntent();
        passedContact = (Contact)intent.getSerializableExtra("birthContactObject");

        edt_birthContactName.setText(passedContact.getContactName());
        edt_birthContactPhone.setText(passedContact.getContactPhone());
        edt_birthdayContactBirthDate.setText(passedContact.getContactBirthDate().toString());
    }
}