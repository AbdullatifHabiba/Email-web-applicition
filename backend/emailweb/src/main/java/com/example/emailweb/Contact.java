package com.example.emailweb;

import java.util.ArrayList;

public class Contact {
    String Name;
    ArrayList<String> UserNames;

    public Contact(String name, ArrayList<String> userNames) {
        Name = name;
        UserNames = userNames;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<String> getUserNames() {
        return UserNames;
    }

    public void setUserNames(ArrayList<String> userNames) {
        UserNames = userNames;
    }
}
