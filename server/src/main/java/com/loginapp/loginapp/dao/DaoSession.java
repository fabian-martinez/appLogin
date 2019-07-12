package com.loginapp.loginapp.dao;

import com.loginapp.loginapp.model.Session;

public class DaoSession {

    Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void createSession(){
        //Insert Session in DB
    }

    public String getUsernameBySessionId(String SessionId){
        //Get session from DB
        return null;
    }

    public Session getSessionById(String sessionId){
        return session;
    }
}
