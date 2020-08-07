package com.example.mvctutorial.DB;

import android.util.Log;

import com.example.mvctutorial.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class PhonebookDB {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    private static PhonebookDB dbInstance = null;

    private PhonebookDB(){
        contacts.add(new Contact(1, "Smith", "John", "04322434323", "j@j.com"));
        contacts.add(new Contact(2, "Graham", "Coy", "04322434323", "c@c.com"));
        contacts.add(new Contact(3, "William", "Shatner", "04322434323", "w@w.com"));
        contacts.add(new Contact(4, "Boden", "Juden", "04322434323", "b@j.com"));
    }

    public static PhonebookDB getInstance(){
        if(dbInstance == null){
            dbInstance = new PhonebookDB();
        }

        return dbInstance;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
        return;
    }

    public void deleteContact(int id){
        for (int i = 0; i < contacts.size(); i++) {
            if(id == contacts.get(i).getId()){
                contacts.remove(i);
            }
        }
    }

    public void updateContact(Contact contact){
        for (int i = 0; i < contacts.size(); i++) {
            if(contact.getId() == contacts.get(i).getId()){
                contacts.set(i, contact);
            }
        }
    }

    public void LogDump() {
        for (Contact contact : contacts) {
            Log.d("Id", String.valueOf(contact.getId()));
            Log.d("First Name", contact.getFirstName());
            Log.d("Last Name", contact.getLastName());
            Log.d("Phone", contact.getPhone());
            Log.d("Email", contact.getEmail());
        }
    }
}
