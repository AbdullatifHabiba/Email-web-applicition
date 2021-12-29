package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;

public class EmailtoJSON implements Converter<JSONObject, Email>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public JSONObject create(Email E) throws JSONException {
        JSONObject JO = new JSONObject();
        JO.put("Object", E.getObject());
        JO.put("Body", E.getBody());
        JO.put("From", E.getFrom());
        JO.put("To", E.getTo());
        JO.put("Date", sdf.format(E.getDate()));
        JO.put("Importance", E.getImportance());
        return JO;
    }
}
