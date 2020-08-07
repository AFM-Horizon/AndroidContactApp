package com.example.mvctutorial.Activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvctutorial.DB.PhonebookDB;
import com.example.mvctutorial.Models.Contact;
import com.example.mvctutorial.R;

public class AddContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add Contact");
        }
    }

    public void AddContact(Contact contact) {
        PhonebookDB db = PhonebookDB.getInstance();
        db.addContact(contact);
        db.LogDump();
    }
}
