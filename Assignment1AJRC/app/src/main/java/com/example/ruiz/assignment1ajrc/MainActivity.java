package com.example.ruiz.assignment1ajrc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtAddText;
    Spinner lstAdded;
    Button btnAdd;
    Button btnDel;
    ArrayList<String> arrList = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDel = (Button) findViewById(R.id.btnDel);
        txtAddText = (EditText) findViewById(R.id.txtTobeAdd);
        lstAdded = (Spinner) findViewById(R.id.spnAdded);

        btnAdd.setOnClickListener(new MyButtonEventHAndler());
        btnDel.setOnClickListener(new DeleteText());


        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, arrList);

    }


    private class MyButtonEventHAndler implements View.OnClickListener{

        public void onClick (View v)
        {
            String addText = txtAddText.getText().toString();
            if (!addText.isEmpty()) {

                Toast.makeText(MainActivity.this, addText + " Added Succesfully", Toast.LENGTH_LONG).show();

                adapter.add(addText);
                adapter.getContext();
                lstAdded.setAdapter(adapter);
                txtAddText.setText("");

            }
            else
            {
                Toast.makeText(MainActivity.this, "Please insert text to add", Toast.LENGTH_LONG).show();
            }
        }
    }

    private class DeleteText implements View.OnClickListener {

        public void onClick(View v) {
            int pos = lstAdded.getSelectedItemPosition();

            if (pos > -1) {
                adapter.remove(arrList.get(pos));

                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Successfully Deleted", Toast.LENGTH_LONG).show();
            }
        }

    }
}
