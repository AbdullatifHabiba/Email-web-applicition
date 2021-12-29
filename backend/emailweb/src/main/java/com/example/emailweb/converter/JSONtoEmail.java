package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtoEmail implements Converter<Email, JSONObject>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public Email create(JSONObject JO) throws JSONException, ParseException {
        Email temp = new Email(JO.getString("Object"),
                JO.getString("Body"),
                JO.getString("From"),
                JO.getString("To"),
                sdf.parse(JO.getString("Date")),
                JO.getInt("Importance"));
        return temp;
    }
}
