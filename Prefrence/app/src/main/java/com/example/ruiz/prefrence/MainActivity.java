package com.example.ruiz.prefrence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_open , btn_load;
    TextView txt1 , txt2 , txt3;
    SharedPreferences sp;
    boolean isPlaying;
    String message;
    String songName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_open = (Button)findViewById(R.id.btnOpen);
        btn_open.setOnClickListener(new MyButtonEventHandler());
        btn_load = (Button)findViewById(R.id.btnLoad);
        btn_load.setOnClickListener(new MyButtonEventHandler());

        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
    }
    private class MyButtonEventHandler implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(view == btn_open){
                Intent intent = new Intent(MainActivity.this , MyPreference.class);
                startActivity(intent);

            }else if(view == btn_load){
                sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                isPlaying = sp.getBoolean("myMusic", false);
                message = sp.getString("myMessage" , "");
                songName = sp.getString("songs", "");

                txt1.setText((isPlaying? "true" : "false"));
                txt2.setText(message);
                txt3.setText(songName);
            }
        }
    }
}
