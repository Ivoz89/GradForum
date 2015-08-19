    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.rest;

import com.gft.grad.forum.model.ForumThread;
import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.BoardService;
import com.gft.grad.forum.service.UserService;
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
public class ThreadEndpoint {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/board/{boardName}/{threadName}", method = RequestMethod.POST)
    public ForumThread post(@PathVariable String boardName, @PathVariable String threadName) {
        ForumThread thread = new ForumThread();
        ForumUser creator = userService.getCurrentUser();
        thread.setCreator(creator);
        thread.setName(threadName);
        boardService.addThread(boardName, thread);
        return thread;
    }
}
