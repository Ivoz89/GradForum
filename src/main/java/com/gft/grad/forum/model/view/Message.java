/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.model.view;

import lombok.Data;

/**
 *
 * @author izielinski
 */
@Data
public class Message {

    private MessageType messageType;
    private String message;

    public Message(MessageType messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }
}
