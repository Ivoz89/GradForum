/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.model.repo.ForumUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author izielinski
 */
@Service
public class UserServiceImpl implements UserService  {

    @Autowired
    ForumUserRepository forumUserRepository;

    @Override
    public void register(ForumUser forumUser) {
        forumUserRepository.save(forumUser);
    }

    @Override
    public ForumUser findByUsername(String username) {
        return forumUserRepository.findByUsername(username);
    }
    
    @Override
    public ForumUser getCurrentUser() {
        return forumUserRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
