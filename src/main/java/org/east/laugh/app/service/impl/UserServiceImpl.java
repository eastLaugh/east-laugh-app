package org.east.laugh.app.service.impl;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.east.laugh.app.controller.Result;
import org.east.laugh.app.mapper.UserMapper;
import org.east.laugh.app.domain.User;
import org.east.laugh.app.service.UserService;
import org.east.laugh.app.util.EmailVerification;
import org.east.laugh.app.util.JWTGenerator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper, JWTGenerator jwtGenerator,EmailVerification emailVerification) {
        this.userMapper = userMapper;
        this.jwtGenerator = jwtGenerator;
        this.emailVerification=emailVerification;
    }

    private final EmailVerification emailVerification;
    Map<String,String> VerifyCodeMapper = new HashMap<>();
    @Override
    public Result<Object> Register(String email) {
        if(userMapper.SelectByEmail(email)!=null){
            return new Result<>("邮箱已注册。");
        }
        VerifyCodeMapper.remove(email);
        var code = String.format("%05d",(int)(Math.random()*99999));
        emailVerification.SendEmail(email,code);
        VerifyCodeMapper.put(email,code);
        return new Result<>("验证码已发送");

//        var user = new User(null, email, pwd, email, null, null, null, null);
//        userMapper.Insert(user);
//
//        return new Result<>(user, Code.INSERT_OK, "注册成功");
    }

    @Override
    public Result<Object> Register(String email, String pwd, String code) {
        if(VerifyCodeMapper.get(email).equals(code)){
            VerifyCodeMapper.remove(email);
            userMapper.Insert(new User(email,pwd,email,"common"));
//            预留做注册后自动登录

            return new Result<>("已注册");
        }else{
            return new Result<>("验证码错误或不存在");
        }

    }


    @Override
    public User SelectById(int id) {
        return userMapper.SelectById(id);
    }

    private final JWTGenerator jwtGenerator;

    @Override
    public Result<String> Login(String email, String pwd) {
        List<User> users = userMapper.SelectByEmailAndPwd(email, pwd);
        if (users.size() == 1) {

            return new Result<>(jwtGenerator.GenerateJwt(email),"");
        } else {
            return new Result<>();
        }
    }

    @Override
    public Result<String> LoginByJwt(String token) {
//        if(jwtGenerator.ParseJwt(token,))
        return new Result<>(Jwts.parserBuilder().setSigningKey(JWTGenerator.key).build().parseClaimsJws(token).getBody().getSubject());
    }

    @Override
    public String GetEmailByToken(String token) {
        String subject;
        try {
            subject = Jwts.parserBuilder().setSigningKey(JWTGenerator.key).build().parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException ex) {
            throw ex;
        }
        return subject;
    }
}
