package com.loginapp.loginapp.model;

import com.loginapp.loginapp.dao.DaoUser;
import com.loginapp.loginapp.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class Login {

    private String userName;
    private String pass;


    public boolean isValidLogin(){
        //query to database for is valid user
        User user = new DaoUser().getUserByUsername(this.userName);
        // User user = userRepository.findById(userName).get();
        return SecurityUtilsForPassword.isExpectedPassword(pass.toCharArray(),
                Base64.getDecoder().
                        decode(user.getSalt().getBytes()),
                Base64.getDecoder().
                        decode(user.getPass().getBytes()));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
