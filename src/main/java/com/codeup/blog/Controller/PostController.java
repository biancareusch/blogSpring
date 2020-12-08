package com.codeup.blog.Controller;


import com.codeup.blog.Model.PostRepository;
import com.codeup.blog.Model.Post;
import com.codeup.blog.Model.User;
import com.codeup.blog.Model.UserRepository;
import com.codeup.blog.Services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailSvc;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailSvc) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
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
        Post postdb = postDao.getOne(id);
        model.addAttribute("post", postdb);
        model.addAttribute("user",postdb.getOwner());
        return "posts/show";
    }
    @PostMapping("/posts/{id}")
    public String postIndividual(@PathVariable long id, Model model) {
        Post postdb = postDao.getOne(id);
        model.addAttribute("post", postdb);
        model.addAttribute("user",postdb.getOwner());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPostView(@ModelAttribute Post post) {
        User userDb = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(userDb);
         Post dbPost = postDao.save(post);
        emailSvc.prepAndSend(dbPost, "Post has been created", "You can find it with the id of " + dbPost.getID());
        return "redirect:/posts/" + dbPost.getID();
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
