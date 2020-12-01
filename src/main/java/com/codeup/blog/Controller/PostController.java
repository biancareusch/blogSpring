package com.codeup.blog.Controller;

import com.codeup.blog.Model.PostRepository;
import com.codeup.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
        List<Post> allPosts = new ArrayList<>();
        Post firstPost = new Post(1, "First Post", "Hello World!");
        Post secondPost = new Post(2, "new Post", "what's going on");
        allPosts.add(firstPost);
        allPosts.add(secondPost);
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
//        Post thisPost = Post.getPostByID(id);
        Post thisPost = new Post("show Post", "showing individual post");
        model.addAttribute("post", thisPost);
        return "posts/show";
    }

    @GetMapping("/posts/new")
    public String createPost() {
        return "posts/new";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostView(@RequestParam(name = "title") String title,
                                 @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        Post postdb = postDao.save(post);
        return "create a new Post with the id : " + postdb.getID();
    }


}
