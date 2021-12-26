package com.example.emailweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/operate")
public class Operations {

    JSONObject obj = new JSONObject();
    ObjectMapper mapper = new ObjectMapper();
    
    JSONFile J = new JSONFile();



    @GetMapping("/send")
    void send(@RequestParam Email message){
        Account S = J.ac(message.getFrom());
        Account R = J.ac(message.getTo());
        ArrayList sent = S.getSent();
        sent.add(message);
        S.setSent(sent);
        ArrayList inbox = R.getInbox();
        inbox.add(message);
        R.setInbox(inbox);
    }
  @PostMapping("/login")
    void login(@RequestBody Object form){
System.out.println(form);
  }
    private static String UPLOADED_FOLDER = "G://temp//";

    /*@PostMapping("/post")
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("Info") String Info) {
        System.out.println("email" + Info);
        if (file.isEmpty()) {
            return "No file attached";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Succuss";
    }*/

}
