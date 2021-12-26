<<<<<<< HEAD
package com.example.emailweb;

import com.example.emailweb.converter.AccountArraytoJSON;
import com.example.emailweb.converter.AccounttoJSON;
import com.example.emailweb.converter.JSONtoAccount;
import com.example.emailweb.converter.JSONtoArrayAccounts;
import org.json.JSONArray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class JSONFile {
    ArrayList<Account> accountslist = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();
    JSONtoArrayAccounts JAA = new JSONtoArrayAccounts();
    AccountArraytoJSON AAJ = new AccountArraytoJSON();

    Account ac(String Address){
        for (int i = 0; i < accountslist.size(); i++){
            String A = accountslist.get(i).getUserName();
            if (A.equalsIgnoreCase(Address)){
                return accountslist.get(i);
            }
        }
        return null;
    }

    public void Save() throws ParseException {
        Account A = new Account("Ahmed Ezz",
                "ahmedezz",
                "012345678",
                //new Date(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>());
        Account B = new Account("Ahmed",
                "ahmed",
                "0123456",
                //new Date(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>());
        accountslist.add(A);
        accountslist.add(B);
    }

    public static void main(String[] args) throws ParseException {
        JSONFile JF = new JSONFile();
        JF.Save();
        JF.accounts = JF.JAA.create(JF.AAJ.create(JF.accountslist));
        String A = JF.accounts.get(1).getUserName();
        System.out.println(A);
    }
}
=======
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
>>>>>>> b47148ba014efdfdd8a3bb2376bb5b5fba54da49
