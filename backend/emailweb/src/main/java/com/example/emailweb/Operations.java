package com.example.emailweb;

import com.example.emailweb.converter.*;
import com.example.emailweb.sorting.SortByDateA;
import com.example.emailweb.sorting.SortByDateD;
import com.example.emailweb.sorting.SortByImportanceA;
import com.example.emailweb.sorting.SortByImportanceD;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Operations {

    static ArrayList<Account> accountslist = new ArrayList<Account>();
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
    JSONtoEmail JE = new JSONtoEmail();
    SortByImportanceA SIA = new SortByImportanceA();
    SortByImportanceD SID = new SortByImportanceD();
    SortByDateA SDA = new SortByDateA();
    SortByDateD SDD = new SortByDateD();



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

    boolean Send(String model, MultipartFile file) throws IOException, ParseException {
        JSONObject JO = new JSONObject(model);
        LoadAccounts();
        //LoadLogged();
        if (Existed(JO.getString("To").toString())){
            JO.put("From", Logged.getUserName());
            Email M = JE.create(JO);
            int i = Acc(JO.getString("To"));
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
            SaveLogged();
            SaveAccounts();
            return true;
        }
        return false;
    }

    boolean LogIn(String username, String password){
        if (!Existed(username))
            return false;
        Account AC = accountslist.get(Acc(username));
        if (AC.getPassword().equalsIgnoreCase(password)){
            Logged = AC;
            SaveLogged();
            SaveAccounts();
            return true;
        }
        else
            return false;
    }

    boolean Regist(String Form) throws ParseException {
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

    void paggination(String Type) throws IOException {
        FileWriter fileWriter3 = new FileWriter("emails.json");
        JSONArray Jarray = new JSONArray();
        ArrayList<Email> emails = new ArrayList<>();
        JSONObject JO = new JSONObject();
        switch (Type) {
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
            JO.put("Page " + (i + 1), Jarray.toString());
            Jarray.clear();
        }
        for (int i = 0;i < emails.size() % 5;i++){
            Jarray.put(EJ.create(emails.get(5 * (emails.size() / 5) + i)));
        }
        JO.put("Page" + (emails.size() / 5 + 1), Jarray.toString());
        Jarray.clear();
        fileWriter3.write(JO.toString());
        fileWriter3.flush();
    }

    void Sort(String Type, String EmailsType){
        ArrayList<Email> emails = new ArrayList<>();
        switch (EmailsType) {
            case "Inbox":
                emails = Logged.getInbox();
                switch (Type){
                    case "DateA":
                        SDA.Sort(emails);
                        Logged.setInbox(emails);
                        break;
                    case "DateD":
                        SDD.Sort(emails);
                        Logged.setInbox(emails);
                        break;
                    case "ImportanceA":
                        SIA.Sort(emails);
                        Logged.setInbox(emails);
                        break;
                    case "ImportanceD":
                        SID.Sort(emails);
                        Logged.setInbox(emails);
                        break;
                    default:
                        break;
                }
                break;
            case "Sent":
                switch (Type){
                    case "DateA":
                        SDA.Sort(emails);
                        Logged.setSent(emails);
                        break;
                    case "DateD":
                        SDD.Sort(emails);
                        Logged.setSent(emails);
                        break;
                    case "ImportanceA":
                        SIA.Sort(emails);
                        Logged.setSent(emails);
                        break;
                    case "ImportanceD":
                        SID.Sort(emails);
                        Logged.setSent(emails);
                        break;
                    default:
                        break;
                }
                break;
            case "Srarred":
                switch (Type){
                    case "DateA":
                        SDA.Sort(emails);
                        Logged.setStarred(emails);
                        break;
                    case "DateD":
                        SDD.Sort(emails);
                        Logged.setStarred(emails);
                        break;
                    case "ImportanceA":
                        SIA.Sort(emails);
                        Logged.setStarred(emails);
                        break;
                    case "ImportanceD":
                        SID.Sort(emails);
                        Logged.setStarred(emails);
                        break;
                    default:
                        break;
                }
                break;
            case "Trash":
                switch (Type){
                    case "DateA":
                        SDA.Sort(emails);
                        Logged.setTrash(emails);
                        break;
                    case "DateD":
                        SDD.Sort(emails);
                        Logged.setTrash(emails);
                        break;
                    case "ImportanceA":
                        SIA.Sort(emails);
                        Logged.setTrash(emails);
                        break;
                    case "ImportanceD":
                        SID.Sort(emails);
                        Logged.setTrash(emails);
                        break;
                    default:
                        break;
                }
                break;
            case "Drafts":
                switch (Type){
                    case "DateA":
                        SDA.Sort(emails);
                        Logged.setDrafts(emails);
                        break;
                    case "DateD":
                        SDD.Sort(emails);
                        Logged.setDrafts(emails);
                        break;
                    case "ImportanceA":
                        SIA.Sort(emails);
                        Logged.setDrafts(emails);
                        break;
                    case "ImportanceD":
                        SID.Sort(emails);
                        Logged.setDrafts(emails);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    void Delete(String Type, int Position){
        ArrayList<Email> emails = new ArrayList<>();
        ArrayList<Email> trash = Logged.getTrash();
        switch (Type) {
            case "Inbox":
                emails = Logged.getInbox();
                trash.add(emails.get(Position));
                emails.remove(Position);
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            case "Sent":
                emails = Logged.getSent();
                trash.add(emails.get(Position));
                emails.remove(Position);
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            case "Srarred":
                emails = Logged.getStarred();
                trash.add(emails.get(Position));
                emails.remove(Position);
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            case "Drafts":
                emails = Logged.getDrafts();
                trash.add(emails.get(Position));
                emails.remove(Position);
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            default:
                break;
        }
    }

    void Star(String Type, int Position){
        ArrayList<Email> emails = new ArrayList<>();
        ArrayList<Email> trash = Logged.getTrash();
        switch (Type) {
            case "Inbox":
                emails = Logged.getInbox();
                trash.add(emails.get(Position));
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            case "Sent":
                emails = Logged.getSent();
                trash.add(emails.get(Position));
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            case "Drafts":
                emails = Logged.getDrafts();
                trash.add(emails.get(Position));
                Logged.setSent(emails);
                Logged.setTrash(trash);
                break;
            default:
                break;
        }
    }
}
