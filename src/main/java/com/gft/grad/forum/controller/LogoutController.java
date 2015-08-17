package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.ForumUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LogoutController {

    @RequestMapping("/logout")
    public String showContacts(Model model) {
        model.addAttribute("user", new ForumUser());
        return "redirect:/";
    }
}
