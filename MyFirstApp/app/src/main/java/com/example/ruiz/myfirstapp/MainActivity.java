package com.example.ruiz.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnButton;
    EditText txtName;
    Button btnLogin;
    EditText txtUserName , txtPassword;
    Spinner lstCountries;
    String[] countries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            countries = savedInstanceState.getStringArray("countries");
        }
        btnButton = (Button) findViewById(R.id.btnGreet);
        txtName = (EditText) findViewById(R.id.txtName);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtUserName = (EditText) findViewById(R.id.txtUserName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        lstCountries = (Spinner) findViewById(R.id.lstCountries);

        bindValueToList();

        lstCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = lstCountries.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, selected, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnLogin.setOnClickListener(new MyButtonEventHandler());
        btnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();

                Toast.makeText(MainActivity.this ,"Hello " + name, Toast.LENGTH_LONG).show();
            }
        });
    }
    private void bindValueToList() {

        countries = new String[]{"Philippines" , "South Korea" , "China" , "USA" , "JAPAN", "MALAYSIA" , "HONGKONG"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, countries);

        adapter.getContext();
        lstCountries.setAdapter(adapter);

    }
    private class MyButtonEventHandler implements View.OnClickListener{

        public  void onClick(View v)
        {
            final  String DEFAULT_USERNAME = "user";
            final String DEFAULT_PASSWORD = "password";

            String username = txtUserName.getText().toString();
            String password = txtPassword.getText().toString();

            if(username.equals(DEFAULT_USERNAME) && password.equals(DEFAULT_PASSWORD))
            {
                Toast.makeText(MainActivity.this , "Login Succesfully", Toast.LENGTH_LONG).show();
            } else
            {
                Toast.makeText(MainActivity.this, "Incorrect username/password", Toast.LENGTH_SHORT).show();
                txtUserName.setText("");
                txtPassword.setText("");
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle s) {
        super.onSaveInstanceState(s);

        s.putStringArray("countries", countries);

    }
}
