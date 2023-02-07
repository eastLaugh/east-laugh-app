package org.east.laugh.app.service.impl;

import org.east.laugh.app.domain.Blog;
import org.east.laugh.app.domain.User;
import org.east.laugh.app.mapper.BlogMapper;
import org.east.laugh.app.mapper.UserMapper;
import org.east.laugh.app.service.BlogService;
import org.east.laugh.app.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final BlogMapper blogMapper;
    private User user;

    public BlogServiceImpl(UserService userService, UserMapper userMapper, BlogMapper blogMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.blogMapper = blogMapper;
    }

    @Override
    public void Verify(String token) {
        var email=userService.GetEmailByToken(token);
        user= userMapper.SelectByEmail(email);
    }

    @Override
    public Blog Post(String title, String content) {
        blogMapper.Insert(new Blog(null,title,user.getId(),content,null,null));
        return null;
    }
}
