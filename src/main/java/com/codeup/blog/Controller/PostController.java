package com.codeup.blog.Controller;

import com.codeup.blog.Model.PostRepository;
import com.codeup.blog.Model.Post;
import org.springframework.data.repository.query.Param;
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

    //    @GetMapping("/posts/search"){
//        public String search(@RequestParam(name = "search") String searchTitle, Model viewModel){
//            Post post = postDao.findByTitle(searchTitle);
//        }
//    }
    @GetMapping("/posts/create")
    public String createPost(Model model) {
        return "posts/new";
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        Post thisPost = postDao.getOne(id);
//        Post thisPost = new Post("show Post", "showing individual post");
        model.addAttribute("post", thisPost);
        return "posts/show";
    }

    @PostMapping("posts/{id}")
    public String postIndividual(@ModelAttribute Post post, @PathVariable long id, Model model){
        Post thisPost = postDao.getOne(id);
        model.addAttribute("post",thisPost);
        return "posts/show";
    }

    @PostMapping("/posts/create")
    @ResponseBody

    public String createPostView(@Param("title") String title,
                                 @Param("body") String body, Model model) {
        Post post = new Post(title, body);
        Post postdb = postDao.save(post);
        return " create a new post with post id " + postdb.getID();
    }
}
