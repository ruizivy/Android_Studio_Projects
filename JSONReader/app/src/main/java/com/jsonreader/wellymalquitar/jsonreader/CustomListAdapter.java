package com.jsonreader.wellymalquitar.jsonreader;

/**
 * Created by wellymalquitar on 07/09/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<LocationDetails> locations;

    public CustomListAdapter(Activity act, List<LocationDetails> loc){
        this.activity = act;
        this.locations = loc;
    }
    public int getCount() {
        return locations.size();
    }
    public Object getItem(int position) {
        return locations.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.location_details, null);

        TextView street = (TextView) convertView.findViewById(R.id.txtStreet);
        TextView route = (TextView) convertView.findViewById(R.id.txtRoute);
        TextView neighbor = (TextView) convertView.findViewById(R.id.txtNeighbor);
        TextView locality = (TextView) convertView.findViewById(R.id.txtLocality);
        TextView country = (TextView) convertView.findViewById(R.id.txtCountry);
        TextView postal = (TextView) convertView.findViewById(R.id.txtPostal);


        LocationDetails e = locations.get(position);
        street.setText(e.getStreet_number());
        route.setText(e.getRoute());
        neighbor.setText(e.getNeighborhood());
        locality.setText(e.getLocality());
        country.setText(e.getCountry());
        postal.setText(e.getPostal_code());
        return convertView;
    }

}
