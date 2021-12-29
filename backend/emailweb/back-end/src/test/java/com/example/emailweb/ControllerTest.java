package com.example.emailweb;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import static org.mockito.Mockito.mock;

class ControllerTest {

    Operations o = mock(Operations.class);

    @Test
    void send() throws JSONException, ParseException, IOException, org.json.simple.parser.ParseException {
        Operations o = mock(Operations.class);
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
        JO = new JSONObject();
        JO.put("To","none");
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
    }

    @Test
    void login() throws JSONException, ParseException, org.json.simple.parser.ParseException, IOException {
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

    @Test
    void regist() throws JSONException, ParseException, org.json.simple.parser.ParseException, IOException {
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
    }

    @Test
    void delete() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
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
        o.Delete("Sent", 0);
    }

    @Test
    void sort() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
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
        o.Sort("DateD", "Sent");
    }

    @Test
    void star() throws IOException, ParseException, JSONException, org.json.simple.parser.ParseException {
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
        o.Star("Sent", 0);
    }
}