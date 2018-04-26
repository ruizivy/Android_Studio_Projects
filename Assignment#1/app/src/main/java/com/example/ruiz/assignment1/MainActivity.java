package com.example.ruiz.assignment1;

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

    Button btnAdd;
    Button btndelete;
    EditText txtCountry;
    Spinner cmbcountry;


    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            list = savedInstanceState.getStringArrayList("list");
        }
        txtCountry = (EditText) findViewById(R.id.txtCountry);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btndelete = (Button) findViewById(R.id.btnDelete);
        cmbcountry = (Spinner) findViewById(R.id.cmbCountries);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , list);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String country = txtCountry.getText().toString();
                if((!list.contains(country.trim().length() != 0)) || country.trim().length() != 0){
                    list.add(country);
                    adapter.notifyDataSetChanged();
                    cmbcountry.setAdapter(adapter);
                    txtCountry.setText("");
                    Toast.makeText(MainActivity.this , "Successfully added" , Toast.LENGTH_SHORT).show();
                    bindValueToList();
                }
                else if(list.contains(country.trim().length() == 0) || country.trim().length() == 0)
                {
                    Toast.makeText(MainActivity.this , "Please enter a text" ,Toast.LENGTH_SHORT).show();
                    bindValueToList();
                }
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String select = cmbcountry.getSelectedItem().toString();
                int l = list.indexOf(select);
                list.remove(l);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this , "Successfully deleted" , Toast.LENGTH_SHORT).show();
                bindValueToList();

            }
        });
        bindValueToList();
    }
    private void bindValueToList() {

        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, list);
        adapter.getContext();
        cmbcountry.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle s) {
        super.onSaveInstanceState(s);
        s.putStringArrayList("list", list);
    }
}
