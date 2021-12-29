package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoEmailArray implements Converter<ArrayList<Email>, JSONObject>{

    JSONtoEmail JE = new JSONtoEmail();

    @Override
    public ArrayList<Email> create(JSONObject JO) throws JSONException, ParseException {
        ArrayList<Email> emails = new ArrayList<>();
        String[] keys = JO.keySet().toArray(String[]::new);
        for (int i = 0;i < keys.length;i++) {
            JSONArray JA = JO.getJSONArray(keys[i]);
            JSONObject type = JA.getJSONObject(0);
            emails.add(JE.create(type));
        }
        return emails;
    }
}
