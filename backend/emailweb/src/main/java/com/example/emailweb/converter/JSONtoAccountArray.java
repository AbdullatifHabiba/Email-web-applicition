package com.example.emailweb.converter;

import com.example.emailweb.Account;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.util.ArrayList;


public class JSONtoAccountArray implements Converter<ArrayList<Account>, JSONObject>{

    ArrayList<Account> Accounts = new ArrayList<>();

    @Override
    public ArrayList<Account> create(JSONObject J) throws JSONException, ParseException {

        JSONtoAccount JC = new JSONtoAccount();
        String[] keys = J.keySet().toArray(String[]::new);
        for (int i = 0;i < keys.length;i++) {
            JSONArray JA = J.getJSONArray(keys[i]);
            JSONObject type = JA.getJSONObject(0);
            Accounts.add(JC.create(type));
        }
        return Accounts;
    }
}