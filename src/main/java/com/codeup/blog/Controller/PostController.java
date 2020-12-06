package com.codeup.blog.Controller;

import com.codeup.blog.Model.PostRepository;
import com.codeup.blog.Model.Post;
import com.codeup.blog.Model.User;
import com.codeup.blog.Model.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String showPosts(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
        return "posts/index";
    }

    //    @GetMapping("/posts/search"){
//        public String search(@RequestParam(name = "search") String searchTitle, Model viewModel){
//            Post post = postDao.findByTitle(searchTitle);
//        }
//    }
    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        model.addAttribute("user",userDao.getOne(1L));
        return "posts/show";
    }
    @PostMapping("/posts/{id}")
    public String postIndividual(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        model.addAttribute("user",userDao.getOne(1L));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPostView(@ModelAttribute Post post) {
        post.setUser(userDao.getOne(1L));
        postDao.save(post);
        return "redirect:/posts/" + post.getID();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPosts(@PathVariable long id,
                            @RequestParam(name = "title") String title,
                            @RequestParam(name = "body") String body) {
        Post post = postDao.getOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + post.getID();
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }
}
