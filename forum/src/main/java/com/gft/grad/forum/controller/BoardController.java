/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.ForumThread;
import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.BoardService;
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
public class BoardController {

    @Autowired
    BoardService boardService;

    @ModelAttribute("thread")
    public ForumThread initNewThreadt() {
        return new ForumThread();
    }

    @RequestMapping(value = "/board/{board}", method = RequestMethod.GET)
    public String get(@PathVariable String board, Model model) {
        model.addAttribute("threads", boardService.obtainThreadsForBoard(board));
        model.addAttribute("boardName", board);
        return "board";
    }

    @RequestMapping(value = "/board/{board}", method = RequestMethod.POST)
    public String post(@PathVariable String board, @ModelAttribute("thread") ForumThread thread,
            @ModelAttribute("user") ForumUser user, BindingResult result) {
        thread.setCreator(user);
        boardService.addThread(board, thread);
        return "redirect:/board/" + board;
    }
}
