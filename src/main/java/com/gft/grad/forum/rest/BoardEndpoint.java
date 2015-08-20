/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.rest;

import com.gft.grad.forum.model.Board;
import com.gft.grad.forum.service.ForumService;
import com.gft.grad.forum.service.UserService;
import javax.transaction.Transactional;
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
public class BoardEndpoint {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ForumService forumService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/board/{name}", method = RequestMethod.POST)
    @Transactional
    public Board post(@PathVariable String name) {
        Board board = new Board();
        board.setName(name);
        forumService.addBoard(board);
        return board;
    }
}
