package com.example.emailweb;

import com.example.emailweb.converter.*;
import com.example.emailweb.sorting.SortByDateA;
import com.example.emailweb.sorting.SortByDateD;
import com.example.emailweb.sorting.SortByImportanceA;
import com.example.emailweb.sorting.SortByImportanceD;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Operations {

    ArrayList<Account> accountslist = new ArrayList<>();
    Account Logged;

    EmailArraytoJSON EAJ = new EmailArraytoJSON();
    JSONtoEmailArray JEA = new JSONtoEmailArray();
    EmailtoJSON EJ = new EmailtoJSON();
    AccountArraytoJSON AAJ = new AccountArraytoJSON();
    JSONtoAccount JA = new JSONtoAccount();
    AccounttoJSON AJ = new AccounttoJSON();
    JSONtoAccountArray JAA = new JSONtoAccountArray();
    ContactArraytoJSON CAJ = new ContactArraytoJSON();
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    JSONtoEmail JE = new JSONtoEmail();
    SortByImportanceA SIA = new SortByImportanceA();
    SortByImportanceD SID = new SortByImportanceD();
    SortByDateA SDA = new SortByDateA();
    SortByDateD SDD = new SortByDateD();
    JSONParser jsonParser = new JSONParser();


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

    void SaveAccounts() throws java.text.ParseException {
        try (FileWriter fileWriter1 = new FileWriter("accounts.json"))
        {
            fileWriter1.write(AAJ.create(accountslist).toJSONString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
    }

    void SaveLogged() throws java.text.ParseException {
        try (FileWriter fileWriter1 = new FileWriter("logged.json"))
        {
            fileWriter1.write(AJ.create(Logged).toString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }
    }

    void LoadAccounts() throws java.text.ParseException {
        try (FileReader fileReader1 = new  FileReader("accounts.json"))
        {
            Object obj = jsonParser.parse(fileReader1);
            JSONObject J = (JSONObject) obj;
            accountslist = JAA.create(J);
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
            Logged = JA.create(J);
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }
    }

    boolean Send(String model, MultipartFile file) throws IOException, ParseException, java.text.ParseException {
        JSONObject JO = (JSONObject) jsonParser.parse(model);
        LoadAccounts();
        LoadLogged();
        if (Existed(JO.get("To").toString())){
            JO.put("From", Logged.getUserName());
            JO.put("Date", sdf3.format(new Date()));
            Email M = JE.create(JO);
            int i = Acc(JO.get("To").toString());
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

    boolean LogIn(String username, String password) throws java.text.ParseException {
        LoadAccounts();
        if (!Existed(username))
            return false;
        Account AC = accountslist.get(Acc(username));
        if (AC.getPassword().equalsIgnoreCase(password)){
            Logged = AC;
            SaveLogged();
            return true;
        }
        else
            return false;
    }

    boolean Regist(String Form) throws ParseException, java.text.ParseException {
        LoadAccounts();
        JSONObject JO = (JSONObject) jsonParser.parse(Form);
        if (!Existed(JO.get("UserName").toString())) {
            JO.put("DateOfBirth", sdf1.format(sdf2.parse(JO.get("DateOfBirth").toString())));
            JO.put("Sent", EAJ.create(new ArrayList<Email>()));
            JO.put("Inbox", EAJ.create(new ArrayList<Email>()));
            JO.put("Trash", EAJ.create(new ArrayList<Email>()));
            JO.put("Starred", EAJ.create(new ArrayList<Email>()));
            JO.put("Drafts", EAJ.create(new ArrayList<Email>()));
            JO.put("Contacts", CAJ.create(new ArrayList<Contact>()));
            Account Ac = JA.create(JO);
            accountslist.add(Ac);
            SaveAccounts();

            LogIn(Ac.getUserName(), Ac.getPassword());
            SaveLogged();
            return true;
        }
        return false;
    }

    void Paggination(String Type) throws IOException {
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
            ArrayList<Email> subemails = new ArrayList<>();
            for (int j = 0;j < 5;j++){
                subemails.add(emails.get(5 * i + j));
            }
            JO.put("Page " + (i + 1), EAJ.create(subemails).toString());
        }
        ArrayList<Email> subemails = new ArrayList<>();
        for (int i = 0;i < emails.size() % 5;i++){
            subemails.add(emails.get(5 * (emails.size() / 5) + i));
        }
        JO.put("Page" + (emails.size() / 5 + 1), EAJ.create(subemails).toString());
        try (FileWriter fileWriter1 = new FileWriter("emails.json"))
        {
            fileWriter1.write(JO.toString());
            fileWriter1.flush();
        }
        catch (IOException e) {e.printStackTrace(); }

    }

    ArrayList<Email> DisplayEmails(String Type, int Page) throws IOException, ParseException, java.text.ParseException {
        Paggination(Type);
        ArrayList<Email> emails = new ArrayList<>();
        try (FileReader fileReader = new  FileReader("emails.json"))
        {
            Object obj = jsonParser.parse(fileReader);
            JSONObject J = (JSONObject) obj;
            emails = JEA.create(J);
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        catch (ParseException e) { e.printStackTrace(); }
        return emails;
    }

    Email DisplayEmail(String Type, int Position) throws IOException {
        Email email;
        JSONObject JO = new JSONObject();
        switch (Type) {
            case "Inbox":
                email = Logged.getInbox().get(Position);
                return email;
            case "Sent":
                email = Logged.getSent().get(Position);
                return email;
            case "Starred":
                email = Logged.getStarred().get(Position);
                return email;
            case "Trash":
                email = Logged.getTrash().get(Position);
                return email;
            case "Drafts":
                email = Logged.getDrafts().get(Position);
                return email;
            default:
                break;
        }
        return null;
    }

    void Sort(String Type, String EmailsType) throws IOException {
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

    void Delete(String Type, int Position) throws IOException {
        ArrayList<Email> emails = new ArrayList<>();
        ArrayList<Email> trash = Logged.getTrash();
        switch (Type) {
            case "Inbox":
                emails = Logged.getInbox();
                trash.add(emails.get(Position));
                emails.remove(Position);
                Logged.setInbox(emails);
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
                Logged.setStarred(emails);
                Logged.setTrash(trash);
                break;
            case "Drafts":
                emails = Logged.getDrafts();
                trash.add(emails.get(Position));
                emails.remove(Position);
                Logged.setDrafts(emails);
                Logged.setTrash(trash);
                break;
            default:
                break;
        }
    }

    void Star(String Type, int Position) throws IOException {
        ArrayList<Email> emails;
        ArrayList<Email> starred = Logged.getTrash();
        switch (Type) {
            case "Inbox":
                emails = Logged.getInbox();
                starred.add(emails.get(Position));
                Logged.setStarred(starred);
                break;
            case "Sent":
                emails = Logged.getSent();
                starred.add(emails.get(Position));
                Logged.setStarred(starred);
                break;
            case "Drafts":
                emails = Logged.getDrafts();
                starred.add(emails.get(Position));
                Logged.setStarred(starred);
                break;
            default:
                break;
        }
        Paggination(Type);
    }

}
