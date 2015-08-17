/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model.repo;

import com.gft.grad.forum.controller.Credentials;
import com.gft.grad.forum.model.Board;
import com.gft.grad.forum.model.ForumThread;
import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.model.Post;
import java.util.List;

/**
 *
 * @author izielinski
 */
public interface ForumRepository {

    List<Board> findAllBoards();

    List<ForumThread> findThreadsForBoard(String boardName);

    List<Post> findPostsForThread(String threadName);

    ForumUser logIn(Credentials credentials);
    
    ForumUser findByLogin(String login);

    void addThread(String boardName, ForumThread thread);

    void addPost(String threadName, Post post);

    void addUser(ForumUser user);

    void addBoard(Board board);
}
