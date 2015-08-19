/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.controller;

import com.gft.grad.forum.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author izielinski
 */
@Controller
public class ThreadController {

    @Autowired
    ThreadService threadService;

    @RequestMapping(value = "/board/{boardName}/{threadName}", method = RequestMethod.GET)
    public String get(@PathVariable String boardName, @PathVariable String threadName, Model model) {
        model.addAttribute("posts", threadService.obtainPostsForThread(threadName));
        model.addAttribute("threadName", threadName);
        model.addAttribute("boardName", boardName);
        return "thread";
    }
}
