package com.example.ruiz.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ruiz on 8/21/2017.
 */

public class CustomMain extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Music> musicList;

    public CustomMain(Activity a , List<Music> m){
        this.activity = a;
        this.musicList = m;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return musicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.music_list , null);
        }

        TextView songtitle = (TextView)view.findViewById(R.id.lblsongtitle);
        TextView artist = (TextView)view.findViewById(R.id.lblartist);
        TextView album = (TextView)view.findViewById(R.id.lblalbum);
        TextView duration = (TextView)view.findViewById(R.id.lblduration);

        Music m = musicList.get(i);
        songtitle.setText(m.getMusicName());
        artist.setText(m.getArtistName());
        album.setText(m.getAlbum());
        duration.setText("" + m.getDuration());

        return view;
    }
}
