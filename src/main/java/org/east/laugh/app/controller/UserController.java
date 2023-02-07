package org.east.laugh.app.controller;

import org.east.laugh.app.mapper.UserMapper;
import org.east.laugh.app.domain.User;
import org.east.laugh.app.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.Region;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
//ttps://www.bilibili.com/video/BV1nV4y1s7ZN/?p=11&share_source=copy_web&vd_source=f2995da4e482643a320cf5879302cded
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public Result<List<User>> SelectAll() {
        return new Result<List<User>>(userMapper.SelectAll(), Code.SELECT_OK, null);
    }

    @GetMapping("{id}")
    public User SelectByID(@PathVariable("id") int value) {
        return userMapper.SelectWithBlogsById(value);
    }

    /**
     * 发送验证码
     * @param mapper @RequestBody是jsons数据，与之相对的是 @RequestParam从表格中获取数据
     * @return msg
     */
    @PostMapping("register")
    public Result<Object> reg(@RequestBody Map<String, String> mapper) {
        return userService.Register(mapper.get("email"));
    }

    /**
     * 获得验证码后，再次注册
     * @param mapper
     * @return msg
     */
    @PostMapping("registerWithCode")
    public Result<Object> registerWithCode(@RequestBody Map<String,String> mapper){
        return userService.Register(mapper.get("email"), mapper.get("pwd"),mapper.get("code"));
    }

    @PostMapping("login")
    public Result<String> login(@RequestBody Map<String, String> mapper) {
        return userService.Login(mapper.get("email"),mapper.get("pwd"));
    }

    @PostMapping("loginByJwt")
    public Result<String> loginByJwt(@RequestBody Map<String,String> mapper){
        return userService.LoginByJwt(mapper.get("token"));
    }


}
