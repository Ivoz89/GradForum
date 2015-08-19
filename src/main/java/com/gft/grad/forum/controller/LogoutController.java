package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.view.MessageType;
import com.gft.grad.forum.model.view.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String handleLogout(@ModelAttribute Credentials credentials, Model model,
            BindingResult result, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", new Message(MessageType.INFO,
                "You have successfully logged out."));
        return "redirect:/";
    }
}
