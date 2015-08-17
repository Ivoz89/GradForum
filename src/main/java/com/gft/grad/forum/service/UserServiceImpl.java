/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.controller.Credentials;
import com.gft.grad.forum.model.ForumUser;
import com.gft.grad.forum.model.repo.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author izielinski
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ForumRepository forumRepository;

    @Override
    public ForumUser logIn(Credentials credentials) {
        return forumRepository.logIn(credentials);
    }

    @Override
    public void register(ForumUser forumUser) {
        forumRepository.addUser(forumUser);
    }

    @Override
    public ForumUser findByUsername(String username) {
        return forumRepository.findByLogin(username);
    }

}
