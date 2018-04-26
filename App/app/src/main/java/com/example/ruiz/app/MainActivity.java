package com.example.ruiz.app;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds =0;
    private boolean running;
    private  boolean isRunning;

    Button btnStart , btnStop, btnReset;
    TextView txtTimeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            isRunning = savedInstanceState.getBoolean("isRunning");
        }
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnReset = (Button) findViewById(R.id.btnReset);

        btnStart.setOnClickListener(new ButtonEvent());
        btnReset.setOnClickListener(new ButtonEvent());
        btnStop.setOnClickListener(new ButtonEvent());

        runTimer();
    }

    private class ButtonEvent implements View.OnClickListener{
        public  void onClick(View v)
        {
            if(btnStart == v) {
                Start();
            }else if(btnStop == v) {
                Stop();
            }else if(btnReset== v) {
                Reset();
            }
        }
    }
    private  void  Start()
    {
        running = true;
    }
    private  void Stop()
    {
        running = false;
    }
    private  void Reset()
    {
        seconds =0;
        running= false;
    }
    private  void runTimer()
    {
        txtTimeView = (TextView) findViewById(R.id.txtTimeView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600)/60;
                int sec = seconds % 60;
                String time = String.format("%d:%02d:%02d" , hours, minutes, sec );
                txtTimeView.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        isRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isRunning){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle s) {
        super.onSaveInstanceState(s);
        s.putInt("seconds", seconds);
        s.putBoolean("running", running);
        s.putBoolean("isRunning", isRunning);
    }

}
