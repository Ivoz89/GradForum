/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.Post;
import com.gft.grad.forum.model.repo.ForumRepository;
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
    ForumRepository forumRepository;

    @Override
    public List<Post> obtainPostsForThread(String threadName) {
        return forumRepository.findPostsForThread(threadName);
    }

    @Override
    public void addPost(String threadName, Post post) {
        forumRepository.addPost(threadName, post);
    }

    
    

}
