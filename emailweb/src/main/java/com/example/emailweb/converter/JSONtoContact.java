package com.example.emailweb.converter;

import com.example.emailweb.Contact;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoContact implements Converter<Contact, JSONObject>{
    @Override
    public Contact create(JSONObject JO) throws JSONException, ParseException {
        ArrayList<String> UserNames = new ArrayList<>();
        JSONArray JA = (JSONArray) JO.get("Usernames");
        for (int i = 0;i < JA.size();i++){
            UserNames.add(JA.get(i).toString());
        }
        Contact C = new Contact(JO.get("Name").toString(), UserNames);
        return C;
    }
}
