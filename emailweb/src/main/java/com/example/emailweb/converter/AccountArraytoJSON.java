package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class AccountArraytoJSON implements Converter<JSONObject, ArrayList<Account>>{

    @Override
    public JSONObject create(ArrayList<Account> accounts) throws JSONException, ParseException {
        JSONObject J = new JSONObject();
        AccounttoJSON AJ = new AccounttoJSON();
        for (int i = 0;i < accounts.size();i++){
            J.put("Account" + (i + 1), AJ.create(accounts.get(i)));
        }
        return J;
    }
}