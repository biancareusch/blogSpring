package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String showPosts(Model model){
        List<Post> allPosts = new ArrayList<>();
        Post firstPost = new Post(1,"First Post","Hello World!");
        Post secondPost = new Post(2,"new Post", "what's going on");
        allPosts.add(firstPost);
        allPosts.add(secondPost);
        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model){
//        Post thisPost = Post.getPostByID(id);
        Post thisPost = new Post("show Post","showing individual post");
        model.addAttribute("post",thisPost);
        return "posts/show";
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
