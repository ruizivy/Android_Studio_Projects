package com.example.ruiz.splashscreen;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity  implements  TextToSpeech.OnInitListener{

    TextView etDate , etTime;
    Button btnselectDate, btnSelectTime, btnmess;
    int Year;
    int Month;
    int Day , Hour , Minute;
    EditText txt1;
    TextToSpeech tts;
    RatingBar rb1;


    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDate = (TextView) findViewById(R.id.et_Date);
        btnselectDate = (Button) findViewById(R.id.btnSelectDate);
        btnSelectTime =(Button) findViewById(R.id.btnSelectTime);
        etTime = (TextView) findViewById(R.id.txtTime);
        txt1 = (EditText)findViewById(R.id.txt1);
        btnmess = (Button) findViewById(R.id.btnmess) ;
        tts = new TextToSpeech(this , this);
        rb1 = (RatingBar)findViewById(R.id.rb1);

       // etTime = (TextView) findViewById(R.id)

        btnselectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
                updateDisplay();
            }
        });
       btnSelectTime.setOnClickListener(new View.OnClickListener() {
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

        btnmess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });
        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this, "The rating is testing " + rating,Toast.LENGTH_SHORT).show();
            }
        });

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
        etDate.setText(new StringBuilder().append(Month + 1).append("-").append(Day).append("-")
                .append(Year).append(" "));
        etTime.setText(new StringBuilder().append(pad(Hour)).append(":").append(pad(Minute)));
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
        if(String.valueOf(c).length() > 2)
        {
          return  String.valueOf(c);
        }
        else if(String.valueOf(c).length() == 1)
            return "0" + String.valueOf(c);
        else
            return  String.valueOf(c);
    }
    public void onInit(int status)
    {
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.UK);
            tts.setPitch(3);
          //  tts.setSpeechRate(2);
            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(MainActivity.this, "The language is not supported", Toast.LENGTH_SHORT).show();
            }else {

                speakOut();
            }
        }
        else{
            Toast.makeText(MainActivity.this , "Initialization failed" , Toast.LENGTH_SHORT).show();
        }

    }
    public  void speakOut(){
        String text = txt1.getText().toString();
        tts.speak(text , TextToSpeech.QUEUE_FLUSH , null);
    }
}

