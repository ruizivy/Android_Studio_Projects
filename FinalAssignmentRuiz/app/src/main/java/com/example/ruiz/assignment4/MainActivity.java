package com.example.ruiz.assignment4;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.ruiz.assignment4.R.id.btnregister;
import static com.example.ruiz.assignment4.R.id.txtpassword;
import static com.example.ruiz.assignment4.R.id.txtusername;

public class MainActivity extends AppCompatActivity {

    DBPlaces dbPlaces;

    Button btnlogin, btn_register, btn_add;
    EditText eUname, ePword;
    ListView lstuser;
    Cursor cursor;

    ArrayAdapter<String> adapter;
    ArrayList list;

    DialogInterface.OnClickListener dialoglistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eUname = (EditText) findViewById(txtusername);
        ePword = (EditText) findViewById(txtpassword);

        dbPlaces = new DBPlaces(getApplicationContext());

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new ButtonEvent());

        btn_register = (Button) findViewById(btnregister);
        btn_register.setOnClickListener(new ButtonEvent());

        btn_add = (Button) findViewById(R.id.btnadd);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public class ButtonEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view == btnlogin) {
                Intent intent = new Intent(MainActivity.this, ViewAllActivity.class);
                startActivity(intent);
                finish();
            }
            if (view == btn_add) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}
