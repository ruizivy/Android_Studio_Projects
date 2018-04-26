package com.example.ruiz.assignmentno1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AssignmentNo1 extends AppCompatActivity {

    Button btnSave;
    Button btnDelete;
    Spinner spncountry;
    EditText txtEdit;
    ArrayAdapter<String> adapt;
    ArrayList<String> countries = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_no1);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        spncountry = (Spinner) findViewById(R.id.spncountry);
        txtEdit = (EditText) findViewById(R.id.txtEdit);
        btnSave.setOnClickListener(new MyButtonEventHandler());
        btnDelete.setOnClickListener(new MyButtonEventHandler1());
    }

    public void BindCountries()
    {
        adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countries);
        adapt.getContext();
        spncountry.setAdapter(adapt);
    }

    private class MyButtonEventHandler implements View.OnClickListener{
        public void onClick(View v)
        {
            if(txtEdit.getText() != null){
                String addText = txtEdit.getText().toString();
                Toast.makeText(AssignmentNo1.this, addText + "Item has been added", Toast.LENGTH_LONG).show();
                countries.add(addText);
                txtEdit.setText("");
                BindCountries();
            }
            else
            {
                Toast.makeText(AssignmentNo1.this, "Please insert country to add", Toast.LENGTH_LONG).show();
            }
        }
    }
    private class MyButtonEventHandler1 implements View.OnClickListener{
        public void onClick(View v)
        {
            int position = spncountry.getSelectedItemPosition();
            countries.remove(position);
            adapt.notifyDataSetChanged();
            Toast.makeText(AssignmentNo1.this, "Successfully Deleted!", Toast.LENGTH_LONG).show();

        }
    }
}
