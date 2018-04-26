package com.example.ruiz.assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    Button btnok , btncancel;
    EditText txt_ID;
    Intent dataIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txt_ID = (EditText) findViewById(R.id.txtID);

        btnok = (Button) findViewById(R.id.btnOK);
        btnok.setOnClickListener(new ButtonEvent());

        btncancel = (Button) findViewById(R.id.btnCancel);
        btncancel.setOnClickListener(new ButtonEvent());

    }
    private class ButtonEvent implements View.OnClickListener{
        public  void onClick(View v){
            if(v == btnok)
            {
               PassData();
            }else if(v == btncancel){
                setResult(2 , dataIntent);
                finish();
            }
        }
    }
    public  void PassData()
    {
        try {
            if(txt_ID.getText().toString().length() != 0) {
                dataIntent = getIntent();
                dataIntent.putExtra("aydi", txt_ID.getText().toString());
                setResult(1, dataIntent);
                finish();
            }else{
                Toast.makeText(SearchActivity.this , "Please enter number" , Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            //Toast.makeText(SecondActivity.this , "Please complete the requirements" , Toast.LENGTH_SHORT).show();
        }
    }
}
