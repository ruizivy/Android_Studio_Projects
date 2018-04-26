package com.example.ruiz.messagingapp;

/**
 * Created by Ruiz on 8/8/2017.
 */

public class AllMessages {
    private String name , number , message;
    private int thread;

    public  AllMessages(String n ,String nu,  String m , int thread_id){

        this.name = n;
        this.number = nu;
        this.message = m;
        this.thread = thread_id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setThread(int thread) {
        this.thread = thread;
    }

    public int getThread() {
        return thread;
    }
}
