package com.github.propenster.birthdaycontactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    TextView txt_Contacts;
    TextView txt_welcomeUser;
    TextView txt_BirthdaysToday;
    TextView txt_Messages;
    TextView txt_ContactsCount;
    TextView txt_BirthdaysTodayCount;
    TextView txt_MessagesCount;
    //Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        txt_Contacts = (TextView)findViewById(R.id.txt_Contacts);
        txt_welcomeUser = (TextView)findViewById(R.id.txt_welcomeUser);
        txt_BirthdaysToday = (TextView)findViewById(R.id.txt_BirthdaysToday);
        txt_Messages = (TextView)findViewById(R.id.txt_Messages);
        txt_ContactsCount = (TextView)findViewById(R.id.txt_ContactsCount);
        txt_BirthdaysTodayCount = (TextView)findViewById(R.id.txt_BirthdaysTodayCount);
        txt_MessagesCount = (TextView)findViewById(R.id.txt_MessagesCount);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddBirthdayContactActivity.class);
                startActivity(intent);
            }
        });

        txt_ContactsCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowAllContactsList.class);
                startActivity(intent);
            }
        });
        txt_Contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowAllContactsList.class);
                startActivity(intent);
            }
        });




    }
}