package com.example.emailweb;

import com.example.emailweb.converter.ContactArraytoJSON;
import com.example.emailweb.converter.ContacttoJSON;
import com.example.emailweb.converter.JSONtoContact;
import com.example.emailweb.converter.JSONtoContactArray;
import org.json.JSONObject;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Testing {

    public static void main(String[] args) throws ParseException, IOException {
        Operations o = new Operations();
        JSONObject JO = new JSONObject();
        JO.put("Name","Ahmed");
        JO.put("UserName","ahmed");
        JO.put("Password","1234567");
        JO.put("DateOfBirth","2002-01-01");
        o.Regist(JO.toString());
        JO = new JSONObject();
        JO.put("Name","Mohamed");
        JO.put("UserName","mohamed");
        JO.put("Password","00000000");
        JO.put("DateOfBirth","2006-02-16");
        o.Regist(JO.toString());
        o.LogIn("ahmed", "1234567");
    }
}
