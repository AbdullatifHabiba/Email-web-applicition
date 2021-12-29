package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class JSONtoEmailArray implements Converter<ArrayList<Email>, JSONObject>{

    JSONtoEmail JE = new JSONtoEmail();

    @Override
    public ArrayList<Email> create(JSONObject JO) throws JSONException, ParseException {
        ArrayList<Email> emails = new ArrayList<>();
        for (int i = 0;i < JO.size();i++) {
            emails.add(JE.create((JSONObject) JO.get("Email" + (i + 1))));
        }
        return emails;
    }
}
