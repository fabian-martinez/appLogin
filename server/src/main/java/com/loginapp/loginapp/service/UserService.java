package com.loginapp.loginapp.service;

import com.loginapp.loginapp.dao.SessionRepository;
import com.loginapp.loginapp.dao.UserRepository;
import com.loginapp.loginapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

public class UserService {

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    public ResponseUser getUserById(String sessionId) throws Exception {
        Session session = sessionRepository.findById(sessionId).get();
        if (session.isState()){
            ResponseUser responseUser = new ResponseUser();
            responseUser.setUser(userRepository.findById(session.getUserActive()).get());
            return responseUser;
        }else {
            throw new Exception("Invalid Session!!");
        }
    }

    public ResponseSession createUser(User user) {
        user.setSalt(new String(Base64.getEncoder().
                encode(SecurityUtilsForPassword.getNextSalt())));
        user.setPass(new String(Base64.getEncoder().
                encode(SecurityUtilsForPassword.hash(
                        user.getPass().toCharArray(),Base64.getDecoder().decode(user.getSalt().getBytes())
                ))));
        //System.out.println(SecurityUtilsForPassword.isExpectedPassword("pasword123".toCharArray(),Base64.getDecoder().decode(this.salt.getBytes()),Base64.getDecoder().decode(this.pass.getBytes())));
        userRepository.save(user);
        return new SessionService().createSession(user.getUserName());
    }
}
