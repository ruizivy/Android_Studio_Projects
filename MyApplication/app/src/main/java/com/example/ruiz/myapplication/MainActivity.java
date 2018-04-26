package com.example.ruiz.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.button);

    }
    public void btnClick(View view){

        Toast.makeText(MainActivity.this, "Annyeong Haseyo !! ", Toast.LENGTH_SHORT).show();
    }
}
