package com.example.emailweb.converter;

import com.example.emailweb.Contact;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoContact implements Converter<Contact, JSONObject>{
    @Override
    public Contact create(JSONObject JO) throws JSONException, ParseException {
        ArrayList<String> UserNames = new ArrayList<>();
        JSONArray JA = JO.getJSONArray("UserNames");
        for (int i = 0;i < JA.length();i++){
            UserNames.add(JA.getString(i));
        }
        Contact C = new Contact(JO.getString("Name"), UserNames);
        return C;
    }
}
