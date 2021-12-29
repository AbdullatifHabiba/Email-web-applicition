package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;

public class AccountArraytoJSON implements Converter<JSONObject, ArrayList<Account>>{

    @Override
    public JSONObject create(ArrayList<Account> accounts) throws JSONException, ParseException {
        JSONObject J = new JSONObject();
        AccounttoJSON AJ = new AccounttoJSON();
        for (int i = 0;i < accounts.size();i++){
            JSONArray JA = new JSONArray();
            JA.put(AJ.create(accounts.get(i)));
            J.put("Account" + (i + 1), JA);
        }
        return J;
    }
}