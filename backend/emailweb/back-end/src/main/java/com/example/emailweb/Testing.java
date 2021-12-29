package com.example.emailweb;

import com.example.emailweb.converter.ContactArraytoJSON;
import com.example.emailweb.converter.ContacttoJSON;
import com.example.emailweb.converter.JSONtoContact;
import com.example.emailweb.converter.JSONtoContactArray;
import org.json.simple.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Testing {

    public static void main(String[] args) throws ParseException, IOException, org.json.simple.parser.ParseException {
        Operations o = new Operations();
        JSONObject JO = new JSONObject();
        Filing F = new Filing();
        JO.put("Name","Ahmed");
        JO.put("UserName","ahmed");
        JO.put("Password","1234567");
        JO.put("DateOfBirth","2002-01-01");
        o.Regist(JO.toString());
        System.out.println(o.accountslist.size());
        JO = new JSONObject();
        JO.put("Name","Mohamed");
        JO.put("UserName","mohamed");
        JO.put("Password","00000000");
        JO.put("DateOfBirth","2006-02-16");
        o.Regist(JO.toString());
        F.LoadAccounts();
        F.SaveAccounts();
        System.out.println(o.accountslist.size());
        /*o.Regist(JO.toString());
        JO = new JSONObject();
        JO.put("To","ahmed");
        JO.put("Object","Hi");
        JO.put("Body","How are U?");
        JO.put("Importance","0");
        o.Send(JO.toString(), new MultipartFile() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getOriginalFilename() {
                return null;
            }

            @Override
            public String getContentType() {
                return null;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public long getSize() {
                return 0;
            }

            @Override
            public byte[] getBytes() throws IOException {
                return new byte[0];
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {

            }
        });
        o.accountslist.clear();
        o.LoadAccounts();
        System.out.println(o.accountslist.get(1).getSent().get(0).getObject());
        o.DisplayEmail("Sent", 0);
        JO.put("Name","Mohamed 2");
        JO.put("UserName","mohamed");
        JO.put("Password","0000000");
        JO.put("DateOfBirth","2006-02-15");
        System.out.println(o.Regist(JO.toString()));
        o.LogIn("ahmed", "1234567");
        System.out.println(o.accountslist.get(1).getDateOfBirth());
        o.Logged = new Account("A", "B", "C", new Date(), new ArrayList<Email>(), new ArrayList<Email>(), new ArrayList<Email>(), new ArrayList<Email>(), new ArrayList<Email>(), new ArrayList<Contact>());
        System.out.println(o.Logged.getName());
        o.SaveLogged();
        System.out.println(o.Logged.getName());*/
    }
}
