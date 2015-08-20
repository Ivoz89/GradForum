package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.UserService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    @Transactional
    public String get(@PathVariable String username, Model model) throws SQLException {
        ForumUser targetUser = userService.findByUsername(username);
        model.addAttribute("targetUser", targetUser);
        return "user";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST)
    public String post(@RequestParam(value = "image", required = true) MultipartFile image) {
        ForumUser forumUser = userService.getCurrentUser();
        if (image != null) {
            try {
                forumUser.setAvatar(Base64.encode(image.getBytes()));
            } catch (IOException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
        }
        userService.updateUser(forumUser);
        return "redirect:/user/" + forumUser.getUsername();
    }

}
