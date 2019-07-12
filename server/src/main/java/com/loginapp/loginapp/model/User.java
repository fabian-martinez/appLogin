package com.loginapp.loginapp.model;

import com.loginapp.loginapp.dao.DaoSession;
import com.loginapp.loginapp.dao.DaoUser;

public class User {

    private String userName;
    private String pass;
    private String name;
    private String lastName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ResponseSession createSession(){
        DaoUser daoUser = new DaoUser();
        daoUser.getUser().setUserName(this.userName);
        daoUser.getUser().setLastName(this.lastName);
        daoUser.getUser().setName(this.name);
        daoUser.getUser().setPass(this.pass);

        Session session = new Session();
        session.setUserActive(new DaoUser().getUserByUsername(userName));
        //set new session parametters:
        //   session.setExpirationDate();
        //   session.setSessionId();
        session.setState(true);

        new DaoSession().setSession(session);

        ResponseSession responseSession = new ResponseSession();
        responseSession.setSession(session);
        return responseSession;
    }

}
