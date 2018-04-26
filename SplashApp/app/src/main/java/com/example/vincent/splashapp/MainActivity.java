package com.example.vincent.splashapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.*;

import static com.example.vincent.splashapp.R.*;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView endate, ettime;
    Button btndate, btnselectTime, btnmess;
    EditText txt1;
    TextToSpeech tts;
    RatingBar rtb1;
    int Year, Month, Day, Hour, Minute;
    static final int Date_dialog_id = 0;
    static final int Time_dialog_id = 1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        txt1 = (EditText) findViewById(R.id.txtko);
        endate = (TextView) findViewById(R.id.txt_DATE);
        ettime = (TextView) findViewById(R.id.txtTime);
        btndate = (Button) findViewById(R.id.btnselect);
        btnselectTime = (Button) findViewById(R.id.btnSelectTime);
        btnmess = (Button) findViewById(R.id.btnmess);
        tts = new TextToSpeech(this, this);
        rtb1 = (RatingBar) findViewById(R.id.rb1);


        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Date_dialog_id);
                updateDisplay();
            }
        });

        btnselectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(Time_dialog_id);
                updateDisplay();
            }
        });
        updateDisplay();
        btnmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });

        rtb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "The rating is testing: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void speakOut(){
        String text = txt1.getText().toString();
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
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

        private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Hour = hourOfDay;
                Minute = minute;
                updateDisplay();
            }
        };

        private static String pad(int c){
            if(String.valueOf(c).length() > 2)
            {
                return String.valueOf(c);
            }
            else if(String.valueOf(c).length() > 1)
            {
                return "0" + String.valueOf(c);
            }
            else {
                return String.valueOf(c);
            }
        }

        private void updateDisplay(){
          endate.setText(new StringBuilder().append(Month + 1).append("-").append(Day).append("-").append(Year).append(" "));
            ettime.setText(new StringBuilder().append(pad(Hour)).append(" : ").append(pad(Minute)));
      }

      protected Dialog onCreateDialog(int id){
          switch (id){
              case Date_dialog_id:
                  return new DatePickerDialog(this, dateListener, Year, Month, Day);
              case Time_dialog_id:
                  return new TimePickerDialog(this, timeListener, Hour, Minute, false);
          }
          return null;
      }

      public void onInit(int status){
          if(status  == TextToSpeech.SUCCESS){
              int result  = tts.setLanguage(Locale.UK);
              tts.setPitch(3);

              if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                  Toast.makeText(MainActivity.this, "The language is not supported", Toast.LENGTH_SHORT).show();
              }
              else{
                  speakOut();
              }
          }
          else{
              Toast.makeText(MainActivity.this,"Initialization failed", Toast.LENGTH_SHORT).show();
          }
      }

}

