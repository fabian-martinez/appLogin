package com.loginapp.loginapp.service;

import com.loginapp.loginapp.dao.DaoSession;
import com.loginapp.loginapp.dao.SessionRepository;
import com.loginapp.loginapp.model.ResponseSession;
import com.loginapp.loginapp.model.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Calendar;

public class SessionService {

    public ResponseSession createSession(String userName) throws Exception {

        Session session = new Session();
        session.setUserActive(userName);
        //set new session parametters:
        long expiratonDate = Calendar.getInstance().getTimeInMillis() + 30000L;
        session.setExpirationDate(expiratonDate);
        String sessionId = String.valueOf(expiratonDate) + String.valueOf((int)(Math.random()*(999-100)));
        session.setSessionId(sessionId);
        session.setState(true);

        DaoSession daoSession = new DaoSession();
        daoSession.setSession(session);
        daoSession.createSession();

        ResponseSession responseSession = new ResponseSession();
        responseSession.setSession(session);
        return responseSession;
    }
}
