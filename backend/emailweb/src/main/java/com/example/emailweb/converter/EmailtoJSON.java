package com.example.emailweb.converter;

import com.example.emailweb.Email;
import com.fasterxml.jackson.core.JacksonException;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailtoJSON implements Converter<JSONObject, Email>{

    @Override
    public JSONObject create(Email e) throws JSONException {
        JSONObject J = new JSONObject();
        J.put("Object", e.getObject());
        J.put("body", e.getBody());
        J.put("from", e.getFrom());
        J.put("to", e.getTo());
        J.put("Date", e.getDate().toString());
        return J;
    }
}
