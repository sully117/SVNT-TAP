package com.javaxiaodi.springapi.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Xiaodi Tao
 * @className: Message
 * @packageName: entity
 * @description: This is the class for message that should be return back to the client side
 * @data: 2019-10-25
 **/
@Setter
@Getter
public class Message<T> {
    // Http status code
    private int code;
    // Details that describe the error or successful status
    private String messageDetails;
    // Objects that should be return back to client
    private T value;

    // Default constructor
    public Message() {

    }
    // Constructor with parameters
    public Message(int code, String messageDetails){
        this.code = code;
        this.messageDetails = messageDetails;
    }
    // Getters and Setters
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessageDetails() {
        return messageDetails;
    }
    public void setMessageDetails(String messageDetails) {
        this.messageDetails = messageDetails;
    }
}
