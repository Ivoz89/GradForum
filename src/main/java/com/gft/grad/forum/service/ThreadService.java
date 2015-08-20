/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.service;

import com.gft.grad.forum.model.Post;
import java.util.List;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.MANDATORY;

/**
 *
 * @author izielinski
 */
public interface ThreadService {

    @Transactional(MANDATORY)
    public List<Post> obtainPostsForThread(String thread);

    public void addPost(String thread, Post post);
}
