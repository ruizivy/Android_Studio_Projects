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

public class ContactsAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ContactsList> contacts;

    public ContactsAdapter(Activity a, List<ContactsList> m) {
        this.activity = a;
        this.contacts = m;
    }

    public int getCount() {
        return contacts.size();
    }

    public Object getItem(int pos) {
        return contacts.get(pos);
    }

    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int pos, View view, ViewGroup vGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null) {
            view = inflater.inflate(R.layout.contact_list, null);
        }

        TextView name = (TextView) view.findViewById(R.id.lblcontactname);
        TextView number = (TextView) view.findViewById(R.id.lblcontactnumber);


        ContactsList m = contacts.get(pos);
        name.setText(m.getName());
        number.setText(m.getNumber());

        return view;
    }
}
