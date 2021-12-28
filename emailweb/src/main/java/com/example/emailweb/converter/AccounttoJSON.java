package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AccounttoJSON implements Converter<JSONObject, Account>{

    EmailArraytoJSON EAJ = new EmailArraytoJSON();
    ContactArraytoJSON CAJ = new ContactArraytoJSON();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public JSONObject create(Account AC) throws JSONException, ParseException {
        JSONObject JO = new JSONObject();
        JO.put("Name",AC.getName());
        JO.put("UserName",AC.getUserName());
        JO.put("Password",AC.getPassword());
        JO.put("DateOfBirth",sdf.format(AC.getDateOfBirth()));
        JO.put("Sent",EAJ.create(AC.getSent()));
        JO.put("Inbox",EAJ.create(AC.getInbox()));
        JO.put("Trash",EAJ.create(AC.getTrash()));
        JO.put("Starred",EAJ.create(AC.getStarred()));
        JO.put("Drafts",EAJ.create(AC.getDrafts()));
        JO.put("Contacts",CAJ.create(AC.getContacts()));
        return JO;
    }
}
