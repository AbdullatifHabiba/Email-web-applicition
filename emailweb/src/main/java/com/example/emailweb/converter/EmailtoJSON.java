package com.example.emailweb.converter;

import com.example.emailweb.Email;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.SimpleDateFormat;

public class EmailtoJSON implements Converter<JSONObject, Email>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Override
    public JSONObject create(Email e) throws JSONException {
        JSONObject J = new JSONObject();
        J.put("Object", e.getObject());
        J.put("body", e.getBody());
        J.put("from", e.getFrom());
        J.put("to", e.getTo());
        J.put("Date", sdf.format(e.getDate()));
        return J;
    }
}
