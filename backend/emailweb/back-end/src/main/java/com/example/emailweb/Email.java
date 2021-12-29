package com.example.emailweb;

import java.util.Date;

public class Email {
    String Object;
    String Body;
    String From;
    String To;
    Date Date;
    int Importance;

    public Email(String object, String body, String from, String to, java.util.Date date, int importance) {
        Object = object;
        Body = body;
        From = from;
        To = to;
        Date = date;
        Importance = importance;
    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public int getImportance() {
        return Importance;
    }

    public void setImportance(int importance) {
        Importance = importance;
    }
}
