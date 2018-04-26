package com.example.ruiz.musicplayer;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lst_music;
    ToggleButton btnPlay;
    SeekBar seekBar;
    Button  btnVolUp , btnVolDown;
    TextView txt_start , txt_stop;

    MediaPlayer mediaPlayer;
    private CustomMain adapter;
    List<Music> musicInfoList;
    Cursor cursor;

    AudioManager audioManager;
    Music musicSelected;
    android.os.Handler seekHandler = new android.os.Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_start = (TextView)findViewById(R.id.txtStart);
        txt_stop = (TextView)findViewById(R.id.txtStop);
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        seekBar.setOnTouchListener(new OnTouchListener());

        btnVolUp = (Button)findViewById(R.id.btnVolumeUp);
        btnVolUp.setOnClickListener(new ButtonEventUp());
        btnVolDown = (Button)findViewById(R.id.btnVolumeDown);
        btnVolDown.setOnClickListener(new ButtonEventUp());

        btnPlay = (ToggleButton)findViewById(R.id.btnplay);

        lst_music = (ListView) findViewById(R.id.lstMusic);
        lst_music.setOnItemClickListener(new ItemClickListener());

        adapter = new CustomMain(this , musicInfoList);
        lst_music.setAdapter(adapter);

        musicInfoList = new ArrayList<Music>();

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        LoadMusic();
        if(mediaPlayer != null){
            seekUpdate();
        }
        initPlayPause();
    }
    public class ButtonEventUp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view == btnVolUp) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
            }else if(view == btnVolDown){
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
            }
        }
    }

    private void LoadMusic() {
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String songList = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        cursor = managedQuery(songUri , new String[]{"*"} , songList , null, null);

        Music music = null;

        if(cursor !=null){
            while(cursor.moveToNext()){
                music = new Music();
                music.setMusicID(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
                music.setMusicName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)));
                music.setFullPath(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
                music.setAlbum(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)));
                music.setArtistName(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
                music.setDuration(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)));
                music.setFileSize(cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE)));

             //   adapter.add(music.getMusicName() + " by " + music.getArtistName());
                musicInfoList.add(music);

            }
            cursor.close();
        }
    }

    public class ItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            if(mediaPlayer != null && mediaPlayer.isPlaying()){

                mediaPlayer.stop();
            }
            mediaPlayer = new MediaPlayer();
            try
            {
                musicSelected = musicInfoList.get(i);
                mediaPlayer.setDataSource(musicSelected.getFullPath());
                mediaPlayer.prepare();
                seekBar.setMax(musicSelected.getDuration());
                mediaPlayer.start();
                txt_stop.setText(musicSelected.getDuration());
                btnPlay.setChecked(true);
                seekUpdate();
                Toast.makeText(getApplicationContext() , "You seleected " + musicSelected.getMusicName() , Toast.LENGTH_SHORT).show();
            }catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
    private void seekUpdate(){

        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        seekHandler.postDelayed(run , 1000);
    }
    Runnable run = new Runnable() {
        @Override
        public void run() {
            seekUpdate();
        }
    };
    public  class OnTouchListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent Event) {

            seekChange(view);
            return false;
        }
    }
    private void seekChange(View v){

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            SeekBar sb =  (SeekBar)v;
            mediaPlayer.seekTo(sb.getProgress());
            txt_start.setText(sb.getProgress());
        }

    }
    private void initPlayPause(){
        btnPlay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(mediaPlayer != null){
                    if(isChecked)
                        mediaPlayer.start();
                    else
                        mediaPlayer.pause();
                }
            }
        });
    }
}
