package com.example.ruiz.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {

    TextView txtView;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        txtView = (TextView) findViewById(R.id.txtViewOrder);
        send  = (Button) findViewById(R.id.btnSend);
        Intent intent = getIntent();
        String message = intent.getExtras().getString("message");
        txtView.setText(message);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Second_Activity.this, txtView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
