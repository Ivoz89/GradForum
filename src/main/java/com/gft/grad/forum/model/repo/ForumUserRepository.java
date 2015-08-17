/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model.repo;

import com.gft.grad.forum.model.ForumUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author izielinski
 */
public interface ForumUserRepository extends JpaRepository<ForumUser, Long> {

    ForumUser findByUsernameAndPassword(String usernname, String password);

    ForumUser findByUsername(String usernname);
}
