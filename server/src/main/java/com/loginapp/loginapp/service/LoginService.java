package com.loginapp.loginapp.service;

import com.loginapp.loginapp.model.*;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public ResponseSession Login(RequestLogin requestLogin){
        return (requestLogin.getLogin().isValidLogin())?
                requestLogin.getLogin().CreateSession():null;
    }

    public ResponseSession Signin(RequestUser requestUser){
        return requestUser.getUser().createSession();
    }

    public ResponseUser getUser(RequestSession requestSession){
        return new Session().getUserById(requestSession.getSessionId());
    }

}
