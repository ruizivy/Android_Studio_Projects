package com.example.ruiz.lecture080417;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static  final String fileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/audioText.3gp";
    private MediaRecorder recorder;
    private MediaPlayer player;
    private AudioManager audioManager;

   ToggleButton btn_Start , btn_Playback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Start = (ToggleButton)findViewById(R.id.btnStart);
        btn_Playback = (ToggleButton)findViewById(R.id.btnPlayback);

        player = new MediaPlayer();
        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.requestAudioFocus(afChangeListener , AudioManager.STREAM_MUSIC , AudioManager.AUDIOFOCUS_GAIN);

        btn_Start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                btn_Playback.setEnabled(!isChecked);
                onRecordPressed(isChecked);
            }
        });

        btn_Playback.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                btn_Start.setEnabled(!isChecked);
                onPlayPressed(isChecked);
            }
        });

    }
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i == AudioManager.AUDIOFOCUS_LOSS){
                audioManager.abandonAudioFocus(afChangeListener);
                if(player.isPlaying()){
                    stopPlaying();
                }
            }
        }
    };
    private void onRecordPressed(boolean shouldRecord){
        if(shouldRecord){
            startRecording();
        }else{
            stopRecording();
        }
    }
    private  void onPlayPressed(boolean shouldPlay){
        if(shouldPlay){
            startPlaying();
        }else{
            stopPlaying();
        }
    }
    private void startRecording(){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);
        recorder.setOutputFile(fileName);

        try{
            recorder.prepare();
        }
        catch (IOException e){
            Toast.makeText(getApplicationContext() , "Could not start media Recorder" , Toast.LENGTH_SHORT).show();
        }
        recorder.start();
    }
    private  void stopRecording(){
        if(null != recorder){
            recorder.stop();
            recorder.release();
            recorder = null;
        }
    }
    private void startPlaying(){

        player = new MediaPlayer();
        try{
            player.setDataSource(fileName);
            player.prepare();
            player.start();
        }catch (IOException e){
            Toast.makeText(getApplicationContext() , "Could not start media Player" , Toast.LENGTH_SHORT).show();
        }
    }
    private void stopPlaying(){
        if(null != player){
            if(player.isPlaying()){
                player.stop();
            }
            player.release();
            player = null;
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        if(null != recorder){
            recorder.release();
            recorder = null;
        }
        if(null != player){
            player.release();
            player = null;
        }
    }
}
