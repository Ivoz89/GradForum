/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.ForumThread;
import com.gft.grad.forum.model.Post;
import com.gft.grad.forum.model.repo.ForumThreadRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author izielinski
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    ForumThreadRepository forumThreadRepository;

    @Override
    public List<Post> obtainPostsForThread(String threadName) {
        return forumThreadRepository.findByName(threadName).getPosts();
    }

    @Override
    public void addPost(String threadName, Post post) {
        ForumThread thread = forumThreadRepository.findByName(threadName);
        thread.getPosts().add(post);
        forumThreadRepository.save(thread);
    }
}
