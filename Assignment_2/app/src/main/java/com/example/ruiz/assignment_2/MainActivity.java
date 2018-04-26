package com.example.ruiz.assignment_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.ruiz.assignment_2.R.id.chkCheese;
import static com.example.ruiz.assignment_2.R.id.chkGarlic;

public class MainActivity extends AppCompatActivity {

    Spinner listSpin;
    EditText txtName, txtAdd;
    Button btnSubmit1;
    RadioButton rgHawai , rgPep , rgHam , rgSolo1 , rgMeduim1, rgLarge1;
    CheckBox chkCheese1 , chkMushroom1 , chkGarlic1;

    RadioGroup radGrp1 , radGrp2;
    ArrayList<String> collections = new ArrayList<String>();
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PopulateID();
        if(savedInstanceState != null)
        {
            rgHawai.setChecked(savedInstanceState.getBoolean("h"));
            rgPep.setChecked(savedInstanceState.getBoolean("p"));
            rgHam.setChecked(savedInstanceState.getBoolean("hc"));
            rgSolo1.setChecked(savedInstanceState.getBoolean("s"));
            rgMeduim1.setChecked(savedInstanceState.getBoolean("m"));
            rgLarge1.setChecked(savedInstanceState.getBoolean("l"));
            collections = savedInstanceState.getStringArrayList("collect");
            count = savedInstanceState.getInt("count");
        }
        BindToList();
        btnSubmit1.setOnClickListener(new MyButtonEventHandler());
    }
    public void PopulateID()
    {
        listSpin = (Spinner) findViewById(R.id.lstSpin);
        txtName = (EditText) findViewById(R.id.txtName);
        txtAdd = (EditText) findViewById(R.id.txtAdd);
        btnSubmit1 = (Button) findViewById(R.id.btnSubmit);
        rgHawai = (RadioButton) findViewById(R.id.rbHawai);
        rgPep = (RadioButton) findViewById(R.id.rbPepp);
        rgHam = (RadioButton) findViewById(R.id.rbHam);
        rgSolo1 = (RadioButton) findViewById(R.id.rgSolo);
        rgMeduim1 = (RadioButton) findViewById(R.id.rgMeduim);
        rgLarge1 = (RadioButton) findViewById(R.id.rgLarge);
        chkCheese1 = (CheckBox) findViewById(chkCheese);
        chkMushroom1 = (CheckBox) findViewById(R.id.chkMushroom);
        chkGarlic1 = (CheckBox) findViewById(chkGarlic);
        radGrp1 = (RadioGroup)findViewById(R.id.rgPizza);
        radGrp2 = (RadioGroup)findViewById(R.id.rgSize);

        rgHawai.setChecked(true);
        rgSolo1.setChecked(true);

    }
    private void BindToList()
    {
        String[] list = new String[]{"Mr." , "Mrs." , "Ms."};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        adapter.getContext();
        listSpin.setAdapter(adapter);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton) v;
            if(rb == v)
            {
                rb.getText();
            }
        }
    };
    private class MyButtonEventHandler implements View.OnClickListener
    {
        public  void onClick(View v)
        {
            String name = txtName.getText().toString();
            if(name.trim().length() != 0) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                if(chkMushroom1.isChecked() || chkCheese1.isChecked() || chkGarlic1.isChecked()) {
                    String message = listSpin.getSelectedItem().toString() + " " +
                            txtName.getText().toString() + " ordered a " + Size() + " " + Pizza() +
                            " " + chkValue() + ". " +  add_req();
                    intent.putExtra("message", message);
                    startActivity(intent);
                }
                else {
                    String message = listSpin.getSelectedItem().toString() + " " +
                            txtName.getText().toString() + " ordered a " + Size() + " " + Pizza() +
                            " " + chkValue() + ". " + add_req();
                    intent.putExtra("message", message);
                    startActivity(intent);
                }
            }
            else
                Toast.makeText(MainActivity.this, "Please enter your name" , Toast.LENGTH_SHORT).show();
        }
    }
    public  String Pizza()
    {
        int ids = radGrp1.getCheckedRadioButtonId();
        String value = "";
        if(ids != -1) {
            if (rgHawai.isChecked())
                value = rgHawai.getText().toString();
            if (rgPep.isChecked())
                value = rgPep.getText().toString();
            if (rgHam.isChecked())
                value = rgHam.getText().toString();
        }
        return value;
    }
    public  String Size()
    {
        int ids2 = radGrp2.getCheckedRadioButtonId();
        String value = "";
        if(ids2 != -1) {
            if (rgSolo1.isChecked())
                value = rgSolo1.getText().toString();
            if (rgMeduim1.isChecked())
                value = rgMeduim1.getText().toString();
            if (rgLarge1.isChecked())
                value = rgMeduim1.getText().toString();
        }
        return value;
    }

    public  void  SelectItem(View view) {

        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId())
        {
            case R.id.chkCheese:
                if(checked) {
                    collections.add("Cheese");
                    count++;
                }
                else {
                    collections.remove("Cheese");
                    count--;
                }
                break;
            case R.id.chkMushroom:
                if(checked) {
                    collections.add("Mushroom");
                    count++;
                }
                else {
                    collections.remove("Mushroom");
                    count--;
                }
                break;
            case R.id.chkGarlic:
                if(checked) {
                    collections.add("Garlic");
                    count++;
                }
                else {
                    collections.remove("Garlic");
                    count--;
                }
        }
    }
    public String chkValue()
    {
        String text = "";
        if(chkCheese1.isChecked() || chkMushroom1.isChecked() || chkGarlic1.isChecked())
        {
            if(count == 1) {
                text = "with additional toppings " + collections.get(0);
            }
            else  if(count == 2) {
                text = "with additional toppings " + collections.get(0) + " and " + collections.get(1);
            }
            else if(count == 3) {
                text = "with additional toppings " + collections.get(0) + " , " + collections.get(1) +" and "+ collections.get(2);
            }
        }
        else {
            text = " ";
        }
        return  text;
    }
    public String add_req()
    {
        String add = "";
        String request = txtAdd.getText().toString();
        if(request.trim().length() != 0 && (count == 2)) {
            add = "Also , with additional request : " + request;
        }
        else if(request.trim().length() != 0 && (count == 1)) {
            add = "With additional request : "+ request;
        }
        else if(request.trim().length() != 0 && (count == 3)) {
            add = "Also , with additional request : " + request;
        }
        else if(request.trim().length() != 0 && (count == 0))
        {
            add = "With additional request : "+ request;
        }
        else {
            add = "";
        }
        return  add;
    }

    @Override
    public void onSaveInstanceState(Bundle s) {
        super.onSaveInstanceState(s);
        s.putBoolean("h" , rgHawai.isChecked());
        s.putBoolean("p" , rgPep.isChecked());
        s.putBoolean("hc" , rgHam.isChecked());
        s.putBoolean("s", rgSolo1.isChecked());
        s.putBoolean("m" , rgMeduim1.isChecked());
        s.putBoolean("l" , rgLarge1.isChecked());
        s.putStringArrayList("collect" , collections);
        s.putInt("count" , count);
    }
}