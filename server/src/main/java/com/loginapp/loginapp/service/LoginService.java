package com.loginapp.loginapp.service;

import com.loginapp.loginapp.dao.DaoUser;
import com.loginapp.loginapp.model.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoginService {

    public ResponseSession Login(RequestLogin requestLogin){
        return (requestLogin.getLogin().isValidLogin())?
                requestLogin.getLogin().CreateSession():null;
    }

    /*
        Inserta un nuevo usuario con sus datos y su contraseña hasada a base de datos
     */
    public ResponseSession Signin(RequestUser requestUser){
        requestUser.getUser().setPass(
                Arrays.toString(SecurityUtilsForPassword.hash(requestUser.getUser().getPass().toCharArray(),
                        SecurityUtilsForPassword.getNextSalt())));
        new DaoUser().createUser(requestUser.getUser());
        return requestUser.getUser().createSession();
    }

    public ResponseUser getUser(RequestSession requestSession){
        return new Session().getUserById(requestSession.getSessionId());
    }

}
