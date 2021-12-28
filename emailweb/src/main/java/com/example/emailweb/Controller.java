package com.example.emailweb;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/operate")
public class Controller {
    Operations O = new Operations();

    public Controller() throws IOException {
    }

    @GetMapping("/send")
    boolean send(@RequestParam("Info") String model, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException, ParseException {
        return O.Send(model, file);
    }

    @GetMapping("/checklogin")
    boolean login(@RequestParam String username, @RequestParam String password){
        return O.LogIn(username, password);
    }

    @GetMapping("/checkregister")
    boolean regist(@RequestParam String Form) throws ParseException {
        return O.Regist(Form);
    }

    @GetMapping("/delete")
    void delete(@RequestParam String Type, @RequestParam int Position){
        O.Delete(Type, Position);
    }

    @GetMapping("/sort")
    void sort(@RequestParam String Type, @RequestParam String EmailsType){
        O.Sort(Type, EmailsType);
    }

    @GetMapping("/star")
    void star(@RequestParam String Type, @RequestParam int Position){
        O.Star(Type, Position);
    }
}
