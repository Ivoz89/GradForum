/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.rest;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.model.Post;
import com.gft.grad.forum.service.ThreadService;
import com.gft.grad.forum.service.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author izielinski
 */
@RestController
public class PostEndpoint {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/board/{boardName}/{threadName}/{text}", method = RequestMethod.POST)
    public Post post(@PathVariable String boardName, @PathVariable String threadName,
            @PathVariable String text) {
        Post post = new Post();
        ForumUser creator = userService.getCurrentUser();
        post.setCreator(creator);
        post.setDate(new Date());
        post.setText(text);
        threadService.addPost(threadName, post);
        return post;
    }
}
