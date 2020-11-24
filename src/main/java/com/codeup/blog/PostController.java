package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String indexPage(){
        return "posts index page";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(){
        return "view an individual post";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostView(){
        return "view the form for creating a post";
    }
    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }
}
