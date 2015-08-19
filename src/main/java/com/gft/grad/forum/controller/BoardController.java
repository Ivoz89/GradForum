/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.controller;

import com.gft.grad.forum.service.BoardService;
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
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/{board}", method = RequestMethod.GET)
    public String get(@PathVariable String board, Model model) {
        model.addAttribute("threads", boardService.obtainThreadsForBoard(board));
        model.addAttribute("boardName", board);
        return "board";
    }
}
