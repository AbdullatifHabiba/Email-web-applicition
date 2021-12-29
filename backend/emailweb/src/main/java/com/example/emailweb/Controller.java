package com.example.emailweb;

import com.example.emailweb.converter.JSONtoEmail;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/operate")
public class Controller {
    Operations O = new Operations();

    public Controller() throws IOException {
    }

    @PostMapping ("/send")

    boolean send(@RequestParam("Info") String model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException, ParseException, org.json.simple.parser.ParseException {
        return O.Send(model, file);
    }

    @GetMapping("/checklogin")
    boolean login(@RequestParam String username, @RequestParam String password) throws ParseException {
        return O.LogIn(username, password);
    }

    @GetMapping("/checkregister")
    boolean regist(@RequestParam String Form) throws ParseException, org.json.simple.parser.ParseException {
        return O.Regist(Form);
    }

    @GetMapping("/delete")
    void delete(@RequestParam String Type, @RequestParam int Position) throws IOException {
        O.Delete(Type, Position);
    }

    @GetMapping("/sort")
    void sort(@RequestParam String Type, @RequestParam String EmailsType) throws IOException {
        O.Sort(Type, EmailsType);
    }

    @GetMapping("/star")
    void star(@RequestParam String Type, @RequestParam int Position) throws IOException {
        O.Star(Type, Position);
    }

    @GetMapping("/displayemails")
    ArrayList<Email> displayemsils(@RequestParam String Type, @RequestParam int Page) throws IOException, ParseException, org.json.simple.parser.ParseException {
        return O.DisplayEmails(Type, Page);
    }

    @GetMapping("/displayemail")
    Email displayemail(@RequestParam String Type, @RequestParam int Position) throws IOException {
        return O.DisplayEmail(Type, Position);
    }

}
