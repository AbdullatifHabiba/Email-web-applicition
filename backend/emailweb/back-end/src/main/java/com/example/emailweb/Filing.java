package com.example.emailweb;

import com.example.emailweb.converter.AccountArraytoJSON;
import com.example.emailweb.converter.AccounttoJSON;
import com.example.emailweb.converter.JSONtoAccount;
import com.example.emailweb.converter.JSONtoAccountArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filing {

    AccountArraytoJSON AAJ = new AccountArraytoJSON();
    AccounttoJSON AJ = new AccounttoJSON();
    JSONtoAccountArray JAA = new JSONtoAccountArray();
    JSONtoAccount JA = new JSONtoAccount();
    JSONParser jsonParser = new JSONParser();

    void SaveAccounts() throws java.text.ParseException {
        try (FileWriter fileWriter1 = new FileWriter("accounts.json"))
        {
            fileWriter1.write(AAJ.create(Operations.accountslist).toJSONString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
    }

    void SaveLogged() throws java.text.ParseException {
        try (FileWriter fileWriter1 = new FileWriter("logged.json"))
        {
            fileWriter1.write(AJ.create(Operations.Logged).toString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
    }

    void LoadAccounts() throws java.text.ParseException {
        JSONObject J = new JSONObject();
        try (FileReader fileReader = new  FileReader("accounts.json"))
        {
            if (fileReader.equals("{}")) {
                Operations.accountslist = new ArrayList<Account>();
                return;
            }
            Object obj = jsonParser.parse(fileReader);
            J = (JSONObject) obj;
            Operations.accountslist = JAA.create(J);
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }
    }

    void LoadLogged() throws java.text.ParseException {
        try (FileReader fileReader = new  FileReader("logged.json"))
        {
            Object obj = jsonParser.parse(fileReader);
            JSONObject J = (JSONObject) obj;
            Operations.Logged = JA.create(J);
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }
    }
}
