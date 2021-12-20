package com.example.emailweb;

import java.util.ArrayList;

public class Account {
    String First_Name;
    String Last_Name;
    String Address;
    ArrayList<Email> Sent;
    ArrayList<Email> Received;

    public Account(String first_Name, String last_Name, String address, ArrayList<Email> sent, ArrayList<Email> received) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Address = address;
        Sent = sent;
        Received = received;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public ArrayList<Email> getSent() {
        return Sent;
    }

    public void setSent(ArrayList<Email> sent) {
        Sent = sent;
    }

    public ArrayList<Email> getReceived() {
        return Received;
    }

    public void setReceived(ArrayList<Email> received) {
        Received = received;
    }
}
