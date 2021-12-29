package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class EmailArraytoJSON implements Converter<JSONObject, ArrayList<Email>>{

    EmailtoJSON EJ = new EmailtoJSON();

    @Override
    public JSONObject create(ArrayList<Email> emails) throws JSONException {
        JSONObject JO = new JSONObject();
        for (int i = 0;i < emails.size();i++){
            JO.put("Email" + (i + 1), EJ.create(emails.get(i)));
        }
        return JO;
    }
}
