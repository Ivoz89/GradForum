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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author izielinski
 */
@Repository
public class ForumRepositoryImpl implements ForumRepository {

    private List<Board> boards;
    private Map<String, Board> boardMap = new HashMap<>();
    private Map<String, ForumUser> userMap = new HashMap<>();
    private Map<String, ForumThread> threadMap = new HashMap<>();

    public ForumRepositoryImpl() {
        ForumUser user1 = new ForumUser("test1", "test1");
        ForumUser user2 = new ForumUser("test2", "test2");
        userMap.put("test1", user1);
        userMap.put("test2", user2);
        boards = new ArrayList<>();
        ArrayList<ForumThread> threads = new ArrayList<>();
        ForumThread forumThread = new ForumThread("test");
        threadMap.put("test", forumThread);
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("haha", user1));
        posts.add(new Post("heh", user1));
        posts.add(new Post("hehhh", user2));
        forumThread.setPosts(posts);
        threads.add(forumThread);
        Board board = new Board("FIRST");
        boardMap.put("FIRST", board);
        board.setThreads(threads);
        boards.add(board);
    }

    @Override
    public List<Board> findAllBoards() {
        return boards;
    }

    @Override
    public List<ForumThread> findThreadsForBoard(String boardName) {
        return boardMap.get(boardName).getThreads();
    }

    @Override
    public List<Post> findPostsForThread(String threadName) {
        return threadMap.get(threadName).getPosts();
    }

    @Override
    public ForumUser logIn(Credentials credentials) {
        ForumUser user = userMap.get(credentials.getUsername());
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void addPost(String threadName, Post post) {
        threadMap.get(threadName).getPosts().add(post);
    }

    @Override
    public void addThread(String boardName, ForumThread thread) {
        threadMap.put(thread.getName(), thread);
        boardMap.get(boardName).getThreads().add(thread);
    }

    @Override
    public void addUser(ForumUser user) {
        userMap.put(user.getUsername(), user);
    }

    @Override
    public void addBoard(Board board) {
        boardMap.put(board.getName(), board);
        boards.add(board);
    }

    @Override
    public ForumUser findByLogin(String login) {
        return userMap.get(login);
    }
}
