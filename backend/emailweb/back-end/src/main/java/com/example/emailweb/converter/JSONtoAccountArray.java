package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONException;
import org.json.simple.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;


public class JSONtoAccountArray implements Converter<ArrayList<Account>, JSONObject>{

    ArrayList<Account> Accounts = new ArrayList<>();

    @Override
    public ArrayList<Account> create(JSONObject J) throws JSONException, ParseException {

        JSONtoAccount JA = new JSONtoAccount();
        for (int i = 0;i < J.size();i++) {
            JSONObject type = (JSONObject) J.get("Account" + (i + 1));
            Accounts.add(JA.create(type));
        }
        return Accounts;
    }
}