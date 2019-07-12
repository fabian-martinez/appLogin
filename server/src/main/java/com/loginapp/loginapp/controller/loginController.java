package com.loginapp.loginapp.controller;

import com.loginapp.loginapp.model.*;
import com.loginapp.loginapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private LoginService login;

    @PostMapping("/login")
    public ResponseEntity<ResponseSession> retriveLogin(@RequestBody RequestLogin requestLogin){
        return new ResponseEntity<ResponseSession>(login.Login(requestLogin), HttpStatus.ACCEPTED);
    }

    @PostMapping("/signin")
    public ResponseEntity<ResponseSession> retriveSigin(@RequestBody RequestUser requestUser){
        return new ResponseEntity<ResponseSession>(login.Signin(requestUser), HttpStatus.ACCEPTED);
    }

    @PostMapping("/user")
    public ResponseEntity<ResponseUser> retriveUser(@RequestBody RequestSession requestSession){
        return new ResponseEntity<ResponseUser>(login.getUser(requestSession), HttpStatus.ACCEPTED);
    }
}
