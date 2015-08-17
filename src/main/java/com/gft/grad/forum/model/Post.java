/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model;

import java.util.Date;

/**
 *
 * @author izielinski
 */
public class Post {

    private String text;
    private Date date;
    private ForumUser creator;

    public Post() {
        date = new Date();
    }

    public Post(String text) {
        date = new Date();
        this.text = text;
    }

    public Post(String text, ForumUser creator) {
        date = new Date();
        this.text = text;
        this.creator = creator;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ForumUser getCreator() {
        return creator;
    }

    public void setCreator(ForumUser creator) {
        this.creator = creator;
    }

}
