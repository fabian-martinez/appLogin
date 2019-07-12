package com.loginapp.loginapp.model;

import com.loginapp.loginapp.dao.DaoSession;
import com.loginapp.loginapp.dao.DaoUser;

public class Login {

    private String userName;
    private String pass;

    public boolean isValidLogin(){
        //query to database for is valid user
        return pass.equals(new DaoUser().getUserPass(userName));
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

    public ResponseSession CreateSession() {
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
