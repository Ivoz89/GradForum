/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.model.Post;
import com.gft.grad.forum.service.ThreadService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author izielinski
 */
@Controller
@SessionAttributes("user")
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @ModelAttribute("user")
    public ForumUser initNewUser() {
        return new ForumUser();
    }

    @ModelAttribute("post")
    public Post initNewPost() {
        return new Post();
    }

    @RequestMapping(value = "/board/thread/{thread}", method = RequestMethod.GET)
    public String get(@PathVariable String thread, Model model) {
        model.addAttribute("posts", threadService.obtainPostsForThread(thread));
        model.addAttribute("threadName", thread);
        return "thread";
    }

    @RequestMapping(value = "/board/thread/{thread}", method = RequestMethod.POST)
    public String post(@PathVariable String thread, @ModelAttribute("post") Post post,
            @ModelAttribute("user") ForumUser user, BindingResult result) {
        post.setCreator(user);
        post.setDate(new Date());
        threadService.addPost(thread, post);
        return "redirect:/board/thread/" + thread;
    }
}
