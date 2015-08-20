/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.controller.Credentials;
import com.gft.grad.forum.model.ForumUser;

/**
 *
 * @author izielinski
 */
public interface UserService {

    ForumUser findByUsername(String username);

    void register(ForumUser forumUser);

    ForumUser getCurrentUser();

    void updateUser(ForumUser user);
}
