package com.example.emailweb.converter;

import com.example.emailweb.Contact;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoContactArray implements Converter<ArrayList<Contact>, JSONObject>{

    JSONtoContact JC = new JSONtoContact();

    @Override
    public ArrayList<Contact> create(JSONObject JO) throws JSONException, ParseException {
        ArrayList<Contact> contacts = new ArrayList<>();
        for (int i = 0;i < JO.size();i++) {
            contacts.add(JC.create((JSONObject) JO.get("Contact" + (i + 1))));
        }
        return contacts;
    }
}
