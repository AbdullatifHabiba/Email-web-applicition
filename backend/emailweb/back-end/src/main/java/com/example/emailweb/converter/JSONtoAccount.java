package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtoAccount implements Converter<Account, JSONObject>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    JSONtoEmailArray JEA = new JSONtoEmailArray();
    JSONtoContactArray JCA = new JSONtoContactArray();

    @Override
    public Account create(JSONObject JO) throws JSONException, ParseException {
        Account Ac = new Account(JO.get("Name").toString(),
                JO.get("UserName").toString(),
                JO.get("Password").toString(),
                sdf.parse(JO.get("DateOfBirth").toString()),
                JEA.create((JSONObject) JO.get("Sent")),
                JEA.create((JSONObject) JO.get("Inbox")),
                JEA.create((JSONObject) JO.get("Trash")),
                JEA.create((JSONObject) JO.get("Starred")),
                JEA.create((JSONObject) JO.get("Drafts")),
                JCA.create((JSONObject) JO.get("Contacts")));
        return Ac;
    }
}
