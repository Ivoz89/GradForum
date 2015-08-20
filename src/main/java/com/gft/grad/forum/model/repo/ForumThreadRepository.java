/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model.repo;

import com.gft.grad.forum.model.ForumThread;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRES_NEW;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author izielinski
 */
public interface ForumThreadRepository extends JpaRepository<ForumThread, Long> {

    @Transactional(REQUIRES_NEW)
    ForumThread findByName(String name);

}
