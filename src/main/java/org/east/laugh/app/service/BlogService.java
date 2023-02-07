package org.east.laugh.app.service;

import org.east.laugh.app.domain.Blog;
import org.springframework.stereotype.Service;


public interface BlogService {
    void Verify(String token);
    Blog Post(String title,String content);
}
