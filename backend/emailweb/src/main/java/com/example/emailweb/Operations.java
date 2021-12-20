package com.example.emailweb;

import java.util.ArrayList;

public class Operations {

    Account A = new Account("Ahmed", "Ezz", "ahmedezz", new ArrayList<>(), new ArrayList<>());
    Account B = new Account("Abdelatef", "Habiba", "abdelatef", new ArrayList<>(), new ArrayList<>());

    ArrayList<Account> accountslist;

    void mylist(){
        accountslist.add(A);
        accountslist.add(B);
    }

    Account ac(String Address){
        for (int i = 0; i < accountslist.size(); i++){
            String A = accountslist.get(i).getAddress();
            if (A.equalsIgnoreCase(Address)){
                return accountslist.get(i);
            }
        }
        return null;
    }
    void send(Email message){
        Account S = ac(message.getFrom());
        Account R = ac(message.getTo());
        ArrayList sent = S.getSent();
        sent.add(message);
        S.setSent(sent);
        ArrayList inbox = R.getReceived();
        inbox.add(message);
        R.setReceived(inbox);
    }

}
