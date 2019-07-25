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

    @PostMapping("/api/login")
    public ResponseEntity<ResponseSession> retriveLogin(@RequestBody RequestLogin requestLogin) throws Exception {
        return new ResponseEntity<ResponseSession>(login.Login(requestLogin), HttpStatus.ACCEPTED);
    }

    @PostMapping("/api/signin")
    public ResponseEntity<ResponseSession> retriveSigin(@RequestBody RequestUser requestUser) throws Exception {
        return new ResponseEntity<ResponseSession>(login.Signin(requestUser), HttpStatus.ACCEPTED);
    }

    @PostMapping("/api/user")
    public ResponseEntity<ResponseUser> retriveUser(@RequestBody RequestSession requestSession) throws Exception {
        return new ResponseEntity<ResponseUser>(login.getUser(requestSession), HttpStatus.ACCEPTED);
    }
}
