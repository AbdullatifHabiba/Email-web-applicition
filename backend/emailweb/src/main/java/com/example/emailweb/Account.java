package com.example.emailweb;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    String Name;
    String UserName;
    String Password;
    //Date DateOfBirth;
    ArrayList<Email> Sent;
    ArrayList<Email> Inbox;
    ArrayList<Email> Trash;
    ArrayList<Email> Starred;
    ArrayList<Email> Drafts;

    public Account(String name, String userName, String password/*, Date dateOfBirth*/, ArrayList<Email> sent, ArrayList<Email> inbox, ArrayList<Email> trash, ArrayList<Email> starred, ArrayList<Email> drafts) {
        Name = name;
        UserName = userName;
        Password = password;
        //DateOfBirth = dateOfBirth;
        Sent = sent;
        Inbox = inbox;
        Trash = trash;
        Starred = starred;
        Drafts = drafts;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    /*public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }*/

    public ArrayList<Email> getSent() {
        return Sent;
    }

    public void setSent(ArrayList<Email> sent) {
        Sent = sent;
    }

    public ArrayList<Email> getInbox() {
        return Inbox;
    }

    public void setInbox(ArrayList<Email> inbox) {
        Inbox = inbox;
    }

    public ArrayList<Email> getTrash() {
        return Trash;
    }

    public void setTrash(ArrayList<Email> trash) {
        Trash = trash;
    }

    public ArrayList<Email> getStarred() {
        return Starred;
    }

    public void setStarred(ArrayList<Email> starred) {
        Starred = starred;
    }

    public ArrayList<Email> getDrafts() {
        return Drafts;
    }

    public void setDrafts(ArrayList<Email> drafts) {
        Drafts = drafts;
    }
}
