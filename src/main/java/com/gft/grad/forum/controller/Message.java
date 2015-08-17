/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gft.grad.forum.controller;

/**
 *
 * @author izielinski
 */
public class Message {

    private MessageType messageType;
    private String message;

    public Message(MessageType messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public Message() {
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return messageType.name() + ":" + message;
    }

}
