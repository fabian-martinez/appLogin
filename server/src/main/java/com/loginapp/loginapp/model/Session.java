package com.loginapp.loginapp.model;

public class Session {
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

    private String sessionId;
    private int expirationDate;
    private User userActive;
}
