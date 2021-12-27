package com.example.emailweb;

import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;

public class Testing {

    public static void main(String[] args) throws ParseException, IOException{
        Operations o = new Operations();
        JSONObject JO = new JSONObject();
        JO.put("Name","Mohamed");
        JO.put("UserName","mohamed");
        JO.put("Password","00000000");
        JO.put("DateOfBirth","16-02-2006");
        o.Regist(JO.toString());
        JO.put("Name","Ahmed");
        JO.put("UserName","ahmed");
        JO.put("Password","1234567");
        JO.put("DateOfBirth","01-01-2002");
        o.Regist(JO.toString());
        System.out.println(o.accountslist.get(1).getDateOfBirth());
    }
}
