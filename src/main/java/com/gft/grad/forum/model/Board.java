/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Size;

/**
 *
 * @author izielinski
 */
public class Board {

    private List<ForumThread> threads;
    
    @Size(min = 3, max = 15)
    private String name;

    public Board() {
        threads = new ArrayList<>();
    }

    public Board(String name) {
        threads = new ArrayList<>();
        this.name = name;
    }

    public List<ForumThread> getThreads() {
        return threads;
    }

    public void setThreads(List<ForumThread> threads) {
        this.threads = threads;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
