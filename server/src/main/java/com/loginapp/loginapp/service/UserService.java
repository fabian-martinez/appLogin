package com.loginapp.loginapp.service;

import com.loginapp.loginapp.dao.DaoSession;
import com.loginapp.loginapp.dao.DaoUser;
import com.loginapp.loginapp.dao.SessionRepository;
import com.loginapp.loginapp.dao.UserRepository;
import com.loginapp.loginapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Base64;
import java.util.Calendar;

public class UserService {

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    SessionRepository sessionRepository;

    public ResponseUser getUserById(String sessionId) throws Exception {
        DaoSession daoSession = new DaoSession();
        Session session = daoSession.getSessionById(sessionId);
        //Session session = sessionRepository.findById(sessionId).get();

        session.setState(session.getExpirationDate() > (Calendar.getInstance().getTimeInMillis()));
        if (session.isState()){
            ResponseUser responseUser = new ResponseUser();
            responseUser.setUser(new DaoUser().getUserByUsername(session.getUserActive()));
            //responseUser.setUser(userRepository.findById(session.getUserActive()).get());
            return responseUser;
        }else {
            throw new Exception("Invalid Session!!");
        }
    }

    public ResponseSession createUser(User user) throws Exception {
        user.setSalt(new String(Base64.getEncoder().
                encode(SecurityUtilsForPassword.getNextSalt())));
        user.setPass(new String(Base64.getEncoder().
                encode(SecurityUtilsForPassword.hash(
                        user.getPass().toCharArray(),Base64.getDecoder().decode(user.getSalt().getBytes())
                ))));
        //System.out.println(SecurityUtilsForPassword.isExpectedPassword("pasword123".toCharArray(),Base64.getDecoder().decode(this.salt.getBytes()),Base64.getDecoder().decode(this.pass.getBytes())));
        //userRepository.save(user);
        new DaoUser().createUser(user);
        return new SessionService().createSession(user.getUserName());
    }
}
