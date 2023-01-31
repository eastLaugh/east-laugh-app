package org.east.laugh.app.controller;

import org.east.laugh.app.dao.UserMapper;
import org.east.laugh.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping
    public List<User> SelectAll(){
        return userMapper.SelectAll();
    }

    @PostMapping("reg")
    public void reg(@RequestBody User user){
        userMapper.Insert(user);
    }

}
