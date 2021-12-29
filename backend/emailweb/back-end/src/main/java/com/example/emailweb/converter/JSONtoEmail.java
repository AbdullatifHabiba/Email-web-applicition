package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.simple.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtoEmail implements Converter<Email, JSONObject>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public Email create(JSONObject JO) throws JSONException, ParseException {
        Email temp = new Email(JO.get("Object").toString(),
                JO.get("Body").toString(),
                JO.get("From").toString(),
                JO.get("To").toString(),
                sdf.parse(JO.get("Date").toString()),
                Integer.parseInt(JO.get("Importance").toString()));
        return temp;
    }
}
