package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoEmailArray implements Converter<ArrayList<Email>, JSONObject>{

    ArrayList<Email> emails = new ArrayList<>();

    @Override
    public ArrayList<Email> create(JSONObject J) throws JSONException, ParseException {

        JSONtoEmail JE = new JSONtoEmail();
        String[] keys = J.keySet().toArray(String[]::new);
        for (int i = 0;i < keys.length;i++) {
            JSONArray JA = J.getJSONArray(keys[i]);
            JSONObject type = JA.getJSONObject(0);
            emails.add(JE.create(type));
        }
        return emails;
    }
}
