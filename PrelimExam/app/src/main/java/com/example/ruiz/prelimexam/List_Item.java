package com.example.ruiz.prelimexam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class List_Item extends AppCompatActivity {

    TextView txttitle , txtdetails, txtfromdate , txttodate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__item);
        txttitle = (TextView)findViewById(R.id.lbltitle);
        txtdetails = (TextView)findViewById(R.id.lbldetails);
        txtfromdate = (TextView)findViewById(R.id.lblfrmdate);
        txttodate = (TextView)findViewById(R.id.lbltodate);
    }
}
