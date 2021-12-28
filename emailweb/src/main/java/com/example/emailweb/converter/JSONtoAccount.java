package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JSONtoAccount implements Converter<Account, JSONObject>{

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    JSONtoEmailArray JEA = new JSONtoEmailArray();
    JSONtoContactArray JCA = new JSONtoContactArray();

    @Override
    public Account create(JSONObject JO) throws JSONException, ParseException {
        Account Ac = new Account(JO.getString("Name"),
                JO.getString("UserName"),
                JO.getString("Password"),
                sdf.parse(JO.getString("DateOfBirth")),
                JEA.create(JO.getJSONObject("Sent")),
                JEA.create(JO.getJSONObject("Inbox")),
                JEA.create(JO.getJSONObject("Trash")),
                JEA.create(JO.getJSONObject("Starred")),
                JEA.create(JO.getJSONObject("Drafts")),
                JCA.create(JO.getJSONObject("Contacts")));
        return Ac;
    }
}
