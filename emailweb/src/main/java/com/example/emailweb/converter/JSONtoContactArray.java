package com.example.emailweb.converter;

import com.example.emailweb.Contact;
import com.example.emailweb.Email;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoContactArray implements Converter<ArrayList<Contact>, JSONObject>{

    JSONtoContact JC = new JSONtoContact();

    @Override
    public ArrayList<Contact> create(JSONObject JO) throws JSONException, ParseException {
        ArrayList<Contact> contacts = new ArrayList<>();
        String[] keys = JO.keySet().toArray(String[]::new);
        for (int i = 0;i < keys.length;i++) {
            JSONArray JA = JO.getJSONArray(keys[i]);
            JSONObject type = JA.getJSONObject(0);
            contacts.add(JC.create(type));
        }
        return contacts;
    }
}
