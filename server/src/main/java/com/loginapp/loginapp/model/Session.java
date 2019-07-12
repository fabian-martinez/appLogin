package com.loginapp.loginapp.model;

import com.loginapp.loginapp.dao.DaoSession;
import com.loginapp.loginapp.dao.DaoUser;

public class Session {

    private String sessionId;
    private int expirationDate;
    private User userActive;
    private boolean state;


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getUserActive() {
        return userActive;
    }

    public void setUserActive(User userActive) {
        this.userActive = userActive;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public ResponseUser getUserById(String sessionId){

        User user = new User();
        user = new DaoUser().getUserByUsername(new DaoSession()
                .getUsernameBySessionId(sessionId));

        ResponseUser responseUser = new ResponseUser();
        responseUser.setUser(user);
        return responseUser;
    }

}
