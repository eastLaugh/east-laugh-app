package org.east.laugh.app.service.impl;

import org.east.laugh.app.service.UserService;

public class UserServiceImpl  implements UserService {

    @Override
    public boolean Register(String email, String pwd, String name) {
        if(name==null|| name.isEmpty())
            name=email;



        return false;
    }
}
