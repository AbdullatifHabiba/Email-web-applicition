package com.example.emailweb.converter;

import com.example.emailweb.Contact;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class ContacttoJSON implements Converter<JSONObject, Contact>{
    @Override
    public JSONObject create(Contact C) throws JSONException, ParseException {
        JSONObject JO = new JSONObject();
        JSONArray JA = new JSONArray();
        for (int i = 0;i < C.getUserNames().size();i++){
            JA.put(i, C.getUserNames().get(i));
        }
        JO.put("Name", C.getName());
        JO.put("UserNames", JA);
        return JO;
    }
}
