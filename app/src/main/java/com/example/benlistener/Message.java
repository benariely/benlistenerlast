package com.example.benlistener;

public class Message {
    private String sender;
    private String data;
    private int status;

    public Message(String sender, String data, int status) {
        this.sender = sender;
        this.data = data;
        this.status = status;
    }

    public Message() {

    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
