package com.loginapp.loginapp.service;

import com.loginapp.loginapp.dao.SessionRepository;
import com.loginapp.loginapp.model.ResponseSession;
import com.loginapp.loginapp.model.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;

public class SessionService {

    @Autowired
    SessionRepository sessionRepository;

    public ResponseSession createSession(String userName){

        Session session = new Session();
        session.setUserActive(userName);
        //set new session parametters:
        int expiratonDate = (int) Calendar.getInstance().getTimeInMillis();
        session.setExpirationDate(expiratonDate);
        String sessionId = String.valueOf(expiratonDate) + String.valueOf((int)(Math.random()*(999-100)));
        session.setSessionId(sessionId);
        session.setState(true);

        sessionRepository.save(session);

        ResponseSession responseSession = new ResponseSession();
        responseSession.setSession(session);
        return responseSession;
    }
}
