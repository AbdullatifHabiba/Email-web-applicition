package com.example.emailweb.converter;

import com.example.emailweb.Contact;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class ContactArraytoJSON implements Converter<JSONObject, ArrayList<Contact>>{

    ContacttoJSON CJ = new ContacttoJSON();

    @Override
    public JSONObject create(ArrayList<Contact> C) throws JSONException, ParseException {
        JSONObject JO = new JSONObject();
        for (int i = 0;i < C.size();i++){
            JO.put("Contact" + (i + 1), CJ.create(C.get(i)));
        }
        return JO;    }
}
