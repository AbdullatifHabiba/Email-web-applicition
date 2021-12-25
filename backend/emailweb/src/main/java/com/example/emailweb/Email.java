package com.example.emailweb;

import java.util.Date;

public class Email {
    String Object;
    String body;
    String from;
    String to;
    Date date;

    public Email(String object, String body, String from, String to, Date date) {
        Object = object;
        this.body = body;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public String getObject() {
        return Object;
    }

    public void setObject(String object) {
        Object = object;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
