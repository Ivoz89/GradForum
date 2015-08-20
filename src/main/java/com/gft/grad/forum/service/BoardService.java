/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.ForumThread;
import java.util.List;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.MANDATORY;

/**
 *
 * @author izielinski
 */
public interface BoardService {

    @Transactional(MANDATORY)
    List<ForumThread> obtainThreadsForBoard(String boardName);

    void addThread(String boardName, ForumThread thread);

}
