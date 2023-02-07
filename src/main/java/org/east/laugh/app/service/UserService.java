package org.east.laugh.app.service;

import org.east.laugh.app.controller.Result;
import org.east.laugh.app.domain.User;

public interface UserService {

    Result<Object> Register(String email);

    Result<Object> Register(String email, String pwd, String code);
    User SelectById(int id);
    Result<String> Login(String email,String pwd);

    Result<String> LoginByJwt(String token);

    String GetEmailByToken(String token);
}
