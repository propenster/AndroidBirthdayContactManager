package com.github.propenster.birthdaycontactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.propenster.birthdaycontactmanager.Adapters.MyCustomListAdapter;
import com.github.propenster.birthdaycontactmanager.Models.Contact;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ShowAllContactsList extends AppCompatActivity {

    ListView allBirthdayContactsList;
    //ArrayAdapter myArrayAdapter;
    MyCustomListAdapter myCustomListAdapter;
    ArrayList<Contact> listOfAllContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_contacts_list);

        allBirthdayContactsList = (ListView)findViewById(R.id.allBirthdayContactsList);
        listOfAllContacts = new ArrayList<Contact>();
        listOfAllContacts.add( new Contact(1, "Faith Olusegun", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(2, "Adam Smith", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(3, "John Doe", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(4, "Joshua Ajiniran", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(5, "Blessing Olabosoye", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(6, "Dapwol Pam", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(7, "Eunice Otokiti", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(8, "RIchard Brandson", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(9, "Brad Pitt", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(10, "Sly", "+2348109354862", new Date()));
        listOfAllContacts.add( new Contact(11, "Iron Man", "+2348109354862", new Date()));

        myCustomListAdapter = new MyCustomListAdapter(this,  listOfAllContacts);
        allBirthdayContactsList.setAdapter(myCustomListAdapter);
    }
}