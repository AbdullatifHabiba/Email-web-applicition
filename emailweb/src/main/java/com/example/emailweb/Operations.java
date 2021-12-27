package com.example.emailweb;

import com.example.emailweb.converter.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/operate")
public class Operations {

    static ArrayList<Account> accountslist;
    static Account Logged;
    EmailArraytoJSON EAJ = new EmailArraytoJSON();
    AccountArraytoJSON AAJ = new AccountArraytoJSON();
    JSONtoAccount JA = new JSONtoAccount();
    JSONtoArrayAccounts JAA = new JSONtoArrayAccounts();
    FileWriter fileWriter1 = new FileWriter("accounts.json");
    FileReader fileReader1 = new FileReader("accounts.json");


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

    void Save(){
        try{
            fileWriter1.write(AAJ.create(accountslist).toString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
        catch (Exception e){ e.printStackTrace(); }
    }

    void Load(){
        try {
            JSONObject JO = new JSONObject(fileReader1);
            accountslist = JAA.create(JO);
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
            sent.add(M);
            Logged.setSent(sent);
            accountslist.set(i, Logged);
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
        Load();
        JSONObject JO = new JSONObject(Form);
        if (!Existed(JO.getString("UserName"))) {
            JO.put("Sent", EAJ.create(new ArrayList<Email>()));
            JO.put("Inbox", EAJ.create(new ArrayList<Email>()));
            JO.put("Trash", EAJ.create(new ArrayList<Email>()));
            JO.put("Starred", EAJ.create(new ArrayList<Email>()));
            JO.put("Drafts", EAJ.create(new ArrayList<Email>()));
            Account Ac = JA.create(JO);
            accountslist.add(Ac);
            Save();
            return true;
        }
        return false;
    }
}
