package com.example.ruiz.messagingapp;

/**
 * Created by Ruiz on 8/10/2017.
 */

public class Contacts {

    private String name , number;

    public Contacts(String n , String num){
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
