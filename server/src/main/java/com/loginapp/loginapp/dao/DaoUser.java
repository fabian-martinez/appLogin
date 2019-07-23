package com.loginapp.loginapp.dao;

import com.loginapp.loginapp.model.User;

public class DaoUser {
    User user;

    public User getUser() {
        if (user != null){
        return user;}
        else {
            return user = new User();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void createUser(User user){
        this.user = user;
        //quiery to insert user in DB
    }

    public User getUserByUsername(String userName){
        User user = new User();
        //set user parameters from DB
        return user;
    }

    public String getUserPass(String userName){
        //get pass from DB for userName
        String pass = "pass";
        return pass;
    }
}
