package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtoAccount implements Converter<Account, JSONObject>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    JSONtoEmailArray JEA = new JSONtoEmailArray();

    @Override
    public Account create(JSONObject J) throws JSONException, ParseException {
        Account Ac = new Account(J.getString("Name"),
                J.getString("UserName"),
                J.getString("Password"),
                //sdf.parse(J.getString("DateOfBirth")),
                JEA.create(J.getJSONObject("Sent")),
                JEA.create(J.getJSONObject("Inbox")),
                JEA.create(J.getJSONObject("Trash")),
                JEA.create(J.getJSONObject("Starred")),
                JEA.create(J.getJSONObject("Drafts"))
                );
        return Ac;
    }
}
