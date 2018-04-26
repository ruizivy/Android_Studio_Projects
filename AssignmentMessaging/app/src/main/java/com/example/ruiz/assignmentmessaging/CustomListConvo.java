package com.example.ruiz.assignmentmessaging;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruiz on 8/14/2017.
 */

public class CustomListConvo extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ConvoMessages> convoMessages;

    public CustomListConvo(Activity a, List<ConvoMessages> m) {
        this.activity = a;
        this.convoMessages = m;
    }

    public int getCount() {
        return convoMessages.size();
    }

    public Object getItem(int pos) {
        return convoMessages.get(pos);
    }

    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int pos, View view, ViewGroup vGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null) {
            view = inflater.inflate(R.layout.messagefrom, null);
        }

        TextView fromMessage = (TextView) view.findViewById(R.id.lblfrommessage);
        TextView date = (TextView) view.findViewById(R.id.lbldate);

        ConvoMessages m = convoMessages.get(pos);
        int type = m.getType();
        String names = m.getName();
        // fromNumber.setText(m.getNumberfrom());
        //toMessage.setText(m.getMessagefrom());

        if (type == 1) {
            fromMessage.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            date.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            if (names != null) {
                date.setText(m.getDate() + ", " + m.getName());
            } else if (names == null) {
                date.setText(m.getDate());
            }

        } else if (type == 2) {
            fromMessage.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            date.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            date.setText(m.getDate() + ", Me");
        }
        fromMessage.setText(m.getMessagefrom());
        //   date.setText(m.getDate());
        return view;
    }
}
