package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @ModelAttribute("credentials")
    public Credentials initNewCredentials() {
        return new Credentials();
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String get(@PathVariable String username, Model model) {
        ForumUser targetUser = userService.findByUsername(username);
        model.addAttribute("targetUser", targetUser);
        return "user";
    }

}
