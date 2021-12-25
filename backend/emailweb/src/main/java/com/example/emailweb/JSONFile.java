package com.example.emailweb;

import org.json.JSONArray;

import java.util.ArrayList;

public class JSONFile {
    JSONArray Accounts = new JSONArray();

    ArrayList<Account> accountslist;

    Account ac(String Address){
        for (int i = 0; i < accountslist.size(); i++){
            String A = accountslist.get(i).getUserName();
            if (A.equalsIgnoreCase(Address)){
                return accountslist.get(i);
            }
        }
        return null;
    }

    public void Save(){

    }
}
