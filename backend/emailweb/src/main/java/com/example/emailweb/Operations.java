package com.example.emailweb;

import com.example.emailweb.converter.AccountArraytoJSON;
import com.example.emailweb.converter.JSONtoArrayAccounts;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/operate")
public class Operations {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    MainData D = new MainData();
    AccountArraytoJSON AAJ = new AccountArraytoJSON();
    JSONtoArrayAccounts JAA = new JSONtoArrayAccounts();
    FileWriter fileWriter = new FileWriter("accounts.json");
    FileReader fileReader = new FileReader("accounts.json");

    public Operations() throws IOException {
    }

    Account Acc(String Address){
        for (int i = 0; i < D.getAccountslist().size(); i++){
            String A = D.getAccountslist().get(i).getUserName();
            if (A.equalsIgnoreCase(Address)){
                return D.getAccountslist().get(i);
            }
        }
        return null;
    }

    void Save(){
        try{
            fileWriter.write(AAJ.create(D.getAccountslist()).toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void Load(){
        JSONParser Parser = new JSONParser();
        try {
            Object obj = Parser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;
            D.setAccountslist(JAA.create(jsonObject));
        }
        catch (FileNotFoundException e) {e.printStackTrace(); }
        catch (IOException e) {e.printStackTrace(); }
        catch (ParseException e) {e.printStackTrace(); }
        catch (Exception e) {e.printStackTrace(); }
    }

    @GetMapping("/send")
    boolean send(@RequestParam Email message){
        Account S = Acc(message.getFrom());
        Account R = Acc(message.getTo());
        if (S == null || R == null)
            return false;
        ArrayList sent = S.getSent();
        sent.add(message);
        S.setSent(sent);
        ArrayList inbox = R.getInbox();
        inbox.add(message);
        R.setInbox(inbox);
        return true;
    }

    @GetMapping("/checklogin")
    boolean LogIn(@RequestParam String username, @RequestParam String password){
        Account AC = Acc(username);
        if (AC.getPassword().equalsIgnoreCase(password)){
            D.setLoged(Acc(username));
            return true;
        }
        else
            return false;
    }

    @GetMapping("/checkregister")
    boolean Regist(@RequestParam String name, @RequestParam String username, @RequestParam String password, @RequestParam String dateofbirth) throws ParseException {
        if (Acc(username) != null)
            return false;
        /*if (sdf.parse(dateofbirth).after(new Date()) || Period.between(LocalDate.of(sdf.parse(dateofbirth).getYear(), sdf.parse(dateofbirth).getMonth(), sdf.parse(dateofbirth).getDay()), LocalDate.now()).getYears() < 12)
            return false;*/
        Account Ac = new Account(name,
                username,
                password,
                sdf.parse(dateofbirth),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>(),
                new ArrayList<Email>());
        ArrayList<Account> accounts = new ArrayList<>();
        accounts = D.getAccountslist();
        accounts.add(Ac);
        D.setAccountslist(accounts);
        return true;
    }
}
