/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.ForumThread;
import java.util.List;

/**
 *
 * @author izielinski
 */
public interface BoardService {

    List<ForumThread> obtainThreadsForBoard(String boardName);

    void addThread(String boardName, ForumThread thread);

}
