package com.codeup.blog.Controller;

import com.codeup.blog.Model.PostRepository;
import com.codeup.blog.Model.UserRepository;
import com.codeup.blog.Services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.codeup.blog.Model.Post;
import com.codeup.blog.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
public class HomeController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailSvc;

    public HomeController(PostRepository postDao, UserRepository userDao, EmailService emailSvc) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailSvc = emailSvc;
    }

    @GetMapping("/")
    public String landingPage(Model model) {
        model.addAttribute("allPosts", postDao.findAll());
//        for each owner add their username
//        Post postdb = postDao.getOne(id);
//        model.addAttribute("post", postdb);
//        model.addAttribute("user",postdb.getOwner());
        return "home";
    }

    @GetMapping("/roll-dice/")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return (num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
