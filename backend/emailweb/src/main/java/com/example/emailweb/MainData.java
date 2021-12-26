package com.example.emailweb;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class MainData {

    ArrayList<Account> accountslist;
    Account Loged;

    public ArrayList<Account> getAccountslist() {
        return accountslist;
    }

    public void setAccountslist(ArrayList<Account> accountslist) {
        this.accountslist = accountslist;
    }

    public Account getLoged() {
        return Loged;
    }

    public void setLoged(Account loged) {
        Loged = loged;
    }
/*
    public static void main(String[] args) throws ParseException, IOException {
        Operations o = new Operations();
        boolean b = o.Regist("Ahmed", "ahmed", "01234567", "2002-01-01");
        o.Save();
    }*/
}
