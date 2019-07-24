package com.loginapp.loginapp.service;

import com.loginapp.loginapp.model.*;
import org.springframework.stereotype.Component;


@Component
public class LoginService {

    public ResponseSession Login(RequestLogin requestLogin) throws Exception {
        if (requestLogin.getLogin().isValidLogin()){
            return new  SessionService().createSession(requestLogin.getLogin().getUserName());
        }else {
            throw new Exception("Invalid Access.");
        }
    }

    /*
        Inserta un nuevo usuario con sus datos y su contraseña hasada a base de datos
     */
    public ResponseSession Signin(RequestUser requestUser) throws Exception {
        if (requestUser.getUser().getUserName()!=null && requestUser.getUser().getPass()!=null){
            return new UserService().createUser(requestUser.getUser());
        }else {
            throw new Exception("Invalid Parameters.");
        }
    }



    public ResponseUser getUser(RequestSession requestSession) throws Exception {
        return new UserService().getUserById(requestSession.getSessionId());
    }

}
