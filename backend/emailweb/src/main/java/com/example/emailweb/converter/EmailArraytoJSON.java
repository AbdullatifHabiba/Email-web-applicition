package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class EmailArraytoJSON implements Converter<JSONObject, ArrayList<Email>>{

    @Override
    public JSONObject create(ArrayList<Email> emails) throws JSONException {
        JSONObject J = new JSONObject();
        EmailtoJSON EJ = new EmailtoJSON();
        for (int i = 0;i < emails.size();i++){
            JSONArray JA = new JSONArray();
            JA.put(EJ.create(emails.get(i)));
            J.put("Email" + (i + 1), JA);
        }
        return J;
    }
}
