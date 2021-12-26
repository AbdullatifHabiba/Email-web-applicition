package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtoEmail implements Converter<Email, JSONObject>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public Email create(JSONObject J) throws JSONException, ParseException {
        Email temp = new Email(J.getString("Object"),
                J.getString("body"),
                J.getString("from"),
                J.getString("to"),
                sdf.parse(J.getString("Date")));
        return temp;
    }
}
