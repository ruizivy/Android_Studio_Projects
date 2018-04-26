package com.example.ruiz.messagingapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruiz on 8/8/2017.
 */

public class CustomListMain extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<AllMessages> messages;

    public CustomListMain(Activity a , List<AllMessages> m){
        this.activity = a;
        this.messages = m;
    }

    public  int getCount(){
        return  messages.size();
    }
    public Object getItem(int pos){
        return  messages.get(pos);
    }
    public long getItemId(int pos){
        return  pos;
    }
    public View getView(int pos , View view , ViewGroup vGroup){
        if(inflater == null){
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.activity_main__list , null);
        }

        TextView name  = (TextView)view.findViewById(R.id.lbltitle);
        TextView mess = (TextView)view.findViewById(R.id.lbldetails);

        AllMessages m = messages.get(pos);
        String names = m.getName();
        if(names != null) {
            name.setText(m.getName());
        }else if (names == null)
        {
            name.setText(m.getNumber());
        }

        mess.setText(m.getMessage());
        return view;
    }
}
