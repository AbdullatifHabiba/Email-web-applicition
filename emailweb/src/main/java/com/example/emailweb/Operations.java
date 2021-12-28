package com.example.emailweb;

import com.example.emailweb.converter.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/operate")
public class Operations {

    static ArrayList<Account> accountslist = new ArrayList<>();
    static Account Logged;
    EmailArraytoJSON EAJ = new EmailArraytoJSON();
    EmailtoJSON EJ = new EmailtoJSON();
    AccountArraytoJSON AAJ = new AccountArraytoJSON();
    JSONtoAccount JA = new JSONtoAccount();
    AccounttoJSON AJ = new AccounttoJSON();
    JSONtoAccountArray JAA = new JSONtoAccountArray();
    ContactArraytoJSON CAJ = new ContactArraytoJSON();
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");


    public Operations() throws IOException {
    }

    boolean Existed(String user){
        if (accountslist.size() == 0)
            return false;
        else {
            for (int i = 0;i < accountslist.size();i++){
                if (accountslist.get(i).getUserName().equalsIgnoreCase(user))
                    return true;
            }
        }
        return false;
    }

    int Acc(String Address){
        for (int i = 0; i < accountslist.size(); i++){
            String A = accountslist.get(i).getUserName();
            if (A.equalsIgnoreCase(Address)){
                return i;
            }
        }
        return -1;
    }

    void SaveAccounts(){
        try{
            FileWriter fileWriter1 = new FileWriter("accounts.json");
            fileWriter1.write(AAJ.create(accountslist).toString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
        catch (Exception e){ e.printStackTrace(); }
    }

    void SaveLogged(){
        try{
            FileWriter fileWriter2 = new FileWriter("logged.json");
            fileWriter2.write(AJ.create(Logged).toString());
            fileWriter2.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
        catch (Exception e){ e.printStackTrace(); }
    }

    void LoadAccounts(){
        try {
            FileReader fileReader1 = new FileReader("accounts.json");
            JSONObject JO1 = new JSONObject(fileReader1);
            accountslist = JAA.create(JO1);
        }
        catch (ParseException e) {e.printStackTrace(); }
        catch (Exception e) {e.printStackTrace(); }
    }

    void LoadLogged(){
        try {
            FileReader fileReader2 = new FileReader("logged.json");
            JSONObject JO2 = new JSONObject(fileReader2);
            Logged = JA.create(JO2);
        }
        catch (ParseException e) {e.printStackTrace(); }
        catch (Exception e) {e.printStackTrace(); }
    }

    @GetMapping("/send")
    boolean send(@RequestParam String object, @RequestParam String body, @RequestParam String to, int importance){
        if (Existed(to)){
            Email M = new Email(object, body, Logged.getUserName(), to, new Date(), importance);
            int i = Acc(to);
            Account R = accountslist.get(i);
            ArrayList<Email> inbox = R.getInbox();
            inbox.add(0, M);
            R.setInbox(inbox);
            accountslist.set(i, R);
            i = Acc(Logged.getUserName());
            ArrayList<Email> sent = Logged.getSent();
            sent.add(0, M);
            Logged.setSent(sent);
            accountslist.set(i, Logged);
            return true;
        }
        return false;
    }

    @GetMapping("/checklogin")
    boolean LogIn(@RequestParam String username, @RequestParam String password){
        if (!Existed(username))
            return false;
        Account AC = accountslist.get(Acc(username));
        if (AC.getPassword().equalsIgnoreCase(password)){
            Logged = AC;
            return true;
        }
        else
            return false;
    }

    @GetMapping("/checkregister")
    boolean Regist(@RequestParam String Form) throws ParseException {
        LoadAccounts();
        //LoadLogged();
        JSONObject JO = new JSONObject(Form);
        if (!Existed(JO.getString("UserName"))) {
            JO.put("DateOfBirth", sdf1.format(sdf2.parse(JO.getString("DateOfBirth"))));
            JO.put("Sent", EAJ.create(new ArrayList<Email>()));
            JO.put("Inbox", EAJ.create(new ArrayList<Email>()));
            JO.put("Trash", EAJ.create(new ArrayList<Email>()));
            JO.put("Starred", EAJ.create(new ArrayList<Email>()));
            JO.put("Drafts", EAJ.create(new ArrayList<Email>()));
            JO.put("Contacts", CAJ.create(new ArrayList<Contact>()));
            Account Ac = JA.create(JO);
            accountslist.add(Ac);
            LogIn(Ac.getUserName(), Ac.getPassword());
            SaveAccounts();
            SaveLogged();
            return true;
        }
        return false;
    }

    void paggination(String type) throws IOException {
        FileWriter fileWriter3 = new FileWriter("emails.json");
        JSONArray Jarray = new JSONArray();
        ArrayList<Email> emails = new ArrayList<>();
        JSONObject JO = new JSONObject();
        switch (type) {
            case "Inbox":
                emails = Logged.getInbox();
                break;
            case "Sent":
                emails = Logged.getSent();
                break;
            case "Srarred":
                emails = Logged.getStarred();
                break;
            case "Trash":
                emails = Logged.getTrash();
                break;
            case "Drafts":
                emails = Logged.getDrafts();
                break;
            default:
                break;
        }
        for (int i = 0;i < emails.size() / 5;i++){
            for (int j = 0;j < 5;j++){
                Jarray.put(EJ.create(emails.get(5 * i + j)));
            }
            JO.put("Page " + (i + 1), Jarray);
            Jarray.clear();
        }
        for (int i = 0;i < emails.size() % 5;i++){
            Jarray.put(emails.get(5 * emails.size() / 5 + i));
        }
        JO.put("Page", (emails.size() / 5 + 1));
        Jarray.clear();
        fileWriter3.write(EAJ.create(emails).toString());
        fileWriter3.flush();
    }
}
