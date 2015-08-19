package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.view.MessageType;
import com.gft.grad.forum.model.view.Message;
import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @ModelAttribute("newUser")
    public ForumUser initNewCredentials() {
        return new ForumUser();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String get(Model model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String login(@ModelAttribute("newUser") ForumUser newUser, Model model,
            BindingResult result, RedirectAttributes redirectAttributes) {
        newUser.setRole("ROLE_USER");
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userService.register(newUser);
        redirectAttributes.addFlashAttribute("message", new Message(MessageType.SUCCESS,
                "Registration was successful. You can now log in."));
        return "redirect:/";
    }
}
