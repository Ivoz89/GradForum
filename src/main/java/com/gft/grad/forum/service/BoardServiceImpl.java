/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.Board;
import com.gft.grad.forum.model.ForumThread;
import com.gft.grad.forum.model.repo.BoardRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author izielinski
 */
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<ForumThread> obtainThreadsForBoard(String boardName) {
        Board board = boardRepository.findByName(boardName);
        return board.getThreads();
    }

    @Override
    public void addThread(String boardName, ForumThread thread) {
        Board board = boardRepository.findByName(boardName);
        board.getThreads().add(thread);
        boardRepository.save(board);
    }
}
