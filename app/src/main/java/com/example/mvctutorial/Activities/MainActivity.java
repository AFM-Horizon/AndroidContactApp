package com.example.mvctutorial.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvctutorial.DB.PhonebookDB;
import com.example.mvctutorial.Models.Contact;
import com.example.mvctutorial.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, 2);
            }
        });
        //asdasdasdasd

        Button btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteContact(GetViewData());
            }
        });

        Button btnUpdate = findViewById(R.id.btn_update);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateContact(GetViewData());
            }
        });
    }



    public void DeleteContact(Contact contact) {
        PhonebookDB db = PhonebookDB.getInstance();
        db.deleteContact(contact.getId());
        db.LogDump();
    }

    public void UpdateContact(Contact contact) {
        PhonebookDB db = PhonebookDB.getInstance();
        db.updateContact(contact);
        db.LogDump();
    }

    public Contact GetViewData(){
        Contact contact = new Contact(
                1,
                ((EditText)findViewById(R.id.edit_fname)).getText().toString(),
                ((EditText)findViewById(R.id.edit_lname)).getText().toString(),
                ((EditText)findViewById(R.id.edit_phone)).getText().toString(),
                ((EditText)findViewById(R.id.edit_email)).getText().toString()
        );

        return contact;
    }
}