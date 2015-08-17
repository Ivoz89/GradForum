package com.gft.grad.forum.controller;

import com.gft.grad.forum.model.Board;
import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.service.ForumService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class IndexController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ForumService forumService;

    @ModelAttribute("user")
    public ForumUser anonymousUser() {
        return new ForumUser();
    }

    @ModelAttribute("newBoard")
    public Board initNewBoard() {
        return new Board();
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("boards", forumService.obtainBoards());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String post(@Valid @ModelAttribute("newBoard") Board board,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        forumService.addBoard(board);
        return "redirect:/";
    }
}
