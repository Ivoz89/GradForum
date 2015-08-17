/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author izielinski
 */
public class ForumThread {
  
    private List<Post> posts = new ArrayList<>();;
    private String name;
    private ForumUser creator;

    public ForumThread() {
        name = "Generic";
    }

    public ForumThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public ForumUser getCreator() {
        return creator;
    }

    public void setCreator(ForumUser creator) {
        this.creator = creator;
    }
}
