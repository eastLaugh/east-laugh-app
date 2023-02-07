package org.east.laugh.app.controller;

import org.east.laugh.app.domain.Blog;
import org.east.laugh.app.mapper.BlogMapper;
import org.east.laugh.app.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("blogs")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService, BlogMapper blogMapper) {
        this.blogService = blogService;
        this.blogMapper = blogMapper;
    }


    private BlogMapper blogMapper;

    @GetMapping("{uid}")
    public List<Blog> findBlogById(@PathVariable("uid") int value) {
        return blogMapper.SelectBlogsByUid(value);
    }


    @PostMapping("post")
    public Blog post(@RequestBody Map<String, String> mapper) {
        blogService.Verify(mapper.get("token"));
        return blogService.Post(mapper.get("title"), mapper.get("content"));
    }
}
