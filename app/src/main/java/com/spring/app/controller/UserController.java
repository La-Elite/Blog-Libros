package com.spring.app.controller;

import com.spring.domain.User;
import com.spring.service.LoginAndRegister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@Controller
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {
    private final LoginAndRegister loginAndRegister;

    public UserController(LoginAndRegister loginAndRegister) {
        this.loginAndRegister = loginAndRegister;
    }

    @GetMapping("/register")
    public String login() {
        return "register";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        System.out.println(user.getId());
        var rs = loginAndRegister.getUser(user.getId(), user.getPass());
        if (rs == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Void> login(String user, String pass) {
        System.out.println("user = " + user + ", pass = " + pass);
        loginAndRegister.saveUser(user, pass);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://localhost:5173/" + user))
                .build();
    }
}
