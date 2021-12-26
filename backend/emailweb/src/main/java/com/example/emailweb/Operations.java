package com.example.emailweb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.web.bind.annotation.*;

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

}
