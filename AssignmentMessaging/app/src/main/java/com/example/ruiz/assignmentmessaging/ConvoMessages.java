package com.example.ruiz.assignmentmessaging;

/**
 * Created by Ruiz on 8/14/2017.
 */

public class ConvoMessages {
    private String numberfrom, messagefrom, date, name;
    private int type;

    public ConvoMessages(String num, String convo, int t, String d, String n) {
        this.numberfrom = num;
        this.messagefrom = convo;
        this.type = t;
        this.date = d;
        this.name = n;
    }

    public void setNumberfrom(String numberfrom) {
        this.numberfrom = numberfrom;
    }

    public String getNumberfrom() {
        return numberfrom;
    }

    public void setMessagefrom(String messagefrom) {
        this.messagefrom = messagefrom;
    }

    public String getMessagefrom() {
        return messagefrom;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
