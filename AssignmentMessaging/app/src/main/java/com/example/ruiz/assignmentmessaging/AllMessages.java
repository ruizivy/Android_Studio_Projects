package com.example.ruiz.assignmentmessaging;

/**
 * Created by Ruiz on 8/14/2017.
 */

public class AllMessages {
    private String name, number, message, date;
    private String thread;

    public AllMessages(String n, String nu, String m, String thread_id, String d) {

        this.name = n;
        this.number = nu;
        this.message = m;
        this.thread = thread_id;
        this.date = d;
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

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getThread() {
        return thread;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
