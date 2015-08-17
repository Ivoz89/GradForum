package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    UserService userService;

    @ModelAttribute("credentials")
    public Credentials initNewCredentials() {
        return new Credentials();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String get(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute Credentials credentials, Model model,
            BindingResult result, RedirectAttributes redirectAttributes) {
        ForumUser forumUser = userService.logIn(credentials);
        if (forumUser != null) {
            model.addAttribute("user", forumUser);
            redirectAttributes.addFlashAttribute("message", new Message(MessageType.SUCCESS,
                    "Login successul."));
        } else {
            redirectAttributes.addFlashAttribute("message", new Message(MessageType.ERROR,
                    "Login failed."));
        }
        return "redirect:/";
    }
}
