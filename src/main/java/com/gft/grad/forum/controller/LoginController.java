package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.view.MessageType;
import com.gft.grad.forum.model.view.Message;
import com.gft.grad.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @ModelAttribute("credentials")
    public Credentials initNewCredentials() {
        return new Credentials();
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String get(@RequestParam(value = "error", required = false) String error, Model model,
            RedirectAttributes redirectAttributes) {
        if (error != null) {
            redirectAttributes.addFlashAttribute("message", new Message(MessageType.ERROR,
                    "Login failed."));
            return "redirect:/login";
        }
        return "login";
    }
}
