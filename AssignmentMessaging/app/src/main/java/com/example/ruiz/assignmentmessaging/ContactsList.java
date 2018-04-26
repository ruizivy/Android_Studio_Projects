package com.example.ruiz.assignmentmessaging;

/**
 * Created by Ruiz on 8/14/2017.
 */

public class ContactsList {

    private String name, number;

    public ContactsList(String n, String num) {
        this.name = n;
        this.number = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
