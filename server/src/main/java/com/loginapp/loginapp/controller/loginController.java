package com.loginapp.loginapp.controller;

import com.loginapp.loginapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    @Autowired
    private LoginService login;

    @PostMapping("/login")
    public ResponseEntity<> retriveLogin(@RequestBody Req)
}
