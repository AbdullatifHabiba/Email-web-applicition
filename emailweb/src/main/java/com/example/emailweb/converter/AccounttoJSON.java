package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AccounttoJSON implements Converter<JSONObject, Account>{

    EmailArraytoJSON EAJ = new EmailArraytoJSON();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public JSONObject create(Account AC) throws JSONException, ParseException {
        JSONObject J = new JSONObject();
        J.put("Name",AC.getName());
        J.put("UserName",AC.getUserName());
        J.put("Password",AC.getPassword());
        J.put("DateOfBirth",sdf.format(AC.getDateOfBirth()));
        J.put("Sent",EAJ.create(AC.getSent()));
        J.put("Inbox",EAJ.create(AC.getInbox()));
        J.put("Trash",EAJ.create(AC.getTrash()));
        J.put("Starred",EAJ.create(AC.getStarred()));
        J.put("Drafts",EAJ.create(AC.getDrafts()));
        return J;
    }
}
