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
    @GetMapping("/posts/index")
    @ResponseBody
    public List<Post> showPosts(Model model){
        List<Post> allPosts = new ArrayList<>();
        Post firstPost = new Post(1,"First Post","Hello World!");
        Post secondPost = new Post(2,"new Post", "what's going on");
        allPosts.add(firstPost);
        allPosts.add(secondPost);
        model.addAttribute("allPosts", allPosts);
        return allPosts;
    }
    @GetMapping("/posts/show/{id}")
    @ResponseBody
    public Post individualPost(@PathVariable long id){
//        Post thisPost = Post.getPostByID(id);
        Post thisPost = new Post(id,"show Post","showing individual post");
        return thisPost;
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
