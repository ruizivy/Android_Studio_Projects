package com.example.ruiz.assignment3ruiz;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

import static com.example.ruiz.assignment3ruiz.R.id.txttime;

public class MainActivity extends AppCompatActivity {

    EditText txtRest , txtServe, txt_remarks;
    Button btnReset, btn_setdate , btnsetTime, btn_save;
    TextView txt_time, txt_date , txt_settime;
    RatingBar rb_rest;
    ToggleButton toggle;

    int Year;
    int Month;
    int Day , Hour , Minute;

    private int seconds =0;
    private boolean running;
    private  boolean isRunning;

    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID =1;

    String time = "";
    String date = "";
    Float ratingval =  0.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            isRunning = savedInstanceState.getBoolean("isRunning");
            txt_settime.setText(savedInstanceState.getString("time"));
            txt_date.setText(savedInstanceState.getString("date"));
        }
        txtRest = (EditText) findViewById(R.id.txtRestu);
        txtServe =(EditText)findViewById(R.id.txtServer);
        txt_remarks = (EditText) findViewById(R.id.txtRemarks);
        btnReset = (Button) findViewById(R.id.btnreset);
        btn_setdate = (Button) findViewById(R.id.btnSetDate);
        btnsetTime =(Button) findViewById(R.id.btnSetTime);
        btn_save = (Button) findViewById(R.id.btn_save1);

        txt_time = (TextView) findViewById(txttime);
        txt_date = (TextView) findViewById(R.id.txtDate);
        txt_settime = (TextView) findViewById(R.id.txtTime);
        rb_rest = (RatingBar)findViewById(R.id.rbrestu);
        toggle = (ToggleButton) findViewById(R.id.togglebutton);
        btnReset.setOnClickListener(new ButtonEvent());

        btn_setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
                updateDisplay();
            }
        });
        runTimer();
       btnsetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
                updateDisplay();
            }
        });


        final Calendar c = Calendar.getInstance();
        Year = c.get(Calendar.YEAR);
        Month = c.get(Calendar.MONTH);
        Day = c.get(Calendar.DAY_OF_MONTH);
        updateDisplay();

        rb_rest.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Your rate to the restaurant is " + rating,Toast.LENGTH_SHORT).show();
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtRest.getText().toString().trim().length() != 0 || txtServe.getText().toString().trim().length() != 0) {
                    Toast.makeText(MainActivity.this,"Restaurant Name: "+ txtRest.getText().toString() + "\n" + "Server Name: " +txtServe.getText().toString() + "\n" +
                            "RUNNING TIME : " +txt_time.getText().toString() + "\n" +
                            "DATE: " +txt_date.getText().toString() + "\n" +
                            "TIME: "+ txt_settime.getText().toString() + "\n" +
                            "RATE: " +  rb_rest.getRating() + "\n" + Additional(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Please enter the restaurant name or server name." , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public  String Additional()
    {
        String text ="";
        String remarks = txt_remarks.getText().toString();
        if(remarks.trim().length() != 0)
        {
            text = "Additional Remarks : " + remarks;
        }
        else
            text = "";
        return  text;
    }
    public  void OnClickToggle(View v)
    {
        if(toggle.isChecked())
        {
            Start();
            Toast.makeText(MainActivity.this, "Your timer start now!" , Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Your timer reset!" , Toast.LENGTH_SHORT).show();
            Reset();
        }

    }
    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Year = year;
            Month = month;
            Day = dayOfMonth;
            updateDisplay();
        }
    };
    private void updateDisplay() {
        txt_date.setText(new StringBuilder().append(Month + 1).append("-").append(Day).append("-")
                .append(Year).append(" "));
        txt_settime.setText(new StringBuilder().append(pad(Hour)).append(":").append(pad(Minute)));

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dateListener, Year, Month, Day);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timeListener , Hour , Minute, false);
        }
        return null;
    }
    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hour = hourOfDay;
            Minute = minute;
            updateDisplay();
        }
    };
    private static String pad(int c){
        if (String.valueOf(c).length() > 2) {
            return String.valueOf(c);
        } else if (String.valueOf(c).length() == 1) {
            return "0" + String.valueOf(c);
        } else {
            return String.valueOf(c);
        }
    }
    private class ButtonEvent implements View.OnClickListener{
        public  void onClick(View v)
        {
           // if(btnStart == v) {
                //Start();
          //  }else if(btnStop == v) {
             //   Stop();
           // }else if(btnReset== v) {
            //    Reset();
           // }
            if(btnReset == v)
            {
                Reset();
                Toast.makeText(MainActivity.this, "Your timer reset!" , Toast.LENGTH_SHORT).show();
            }
        }
    }
    private  void  Start()
    {
        running = true;
    }
    private  void Stop() {running = false;}
    private  void Reset() {
        seconds =0;
        running= false;}
    private  void runTimer()
    {
        txt_time = (TextView) findViewById(txttime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600)/60;
                int sec = seconds % 60;

                String time = String.format("%d:%02d:%02d" , hours, minutes, sec );
                txt_time.setText(time);
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
        s.putString("time" , txt_settime.getText().toString());
        s.putString("date" , txt_date.getText().toString());
    }
}
