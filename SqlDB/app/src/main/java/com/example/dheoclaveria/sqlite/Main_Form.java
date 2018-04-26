package com.example.dheoclaveria.sqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main_Form extends AppCompatActivity {


    Button btnsave, btnsearch;
    EditText txtusername , txtpassword;
    ListView lstuser;

    Cursor cursor;
    DBTools dbTools;

    ArrayAdapter<String> adapter;
    ArrayList list;

    public int update_id = 1;

    DialogInterface.OnClickListener dialoglistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__form);

        btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new ButtonEvent());

        btnsearch = (Button) findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new ButtonEvent());

        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);

        lstuser = (ListView) findViewById(R.id.lstuser);
        lstuser.setOnItemLongClickListener(new ListViewItemLongClick());


        dbTools = new DBTools(getApplicationContext());
        list = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lstuser.setAdapter(adapter);

        LoadData();

    }

    private void LoadData() {
        list.clear();
        cursor = dbTools.getAlluser();

        if(cursor.moveToFirst()){

            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String password= cursor.getString(2);
                adapter.add( id + "," + name + "," + password );
            }
            while(cursor.moveToNext());
            lstuser.setAdapter(adapter);

        }
        else {
            Toast.makeText(getApplicationContext(),"No Record",Toast.LENGTH_LONG).show();;

        }
    }
    public void DeleteData(){
        dbTools.deleteDate(update_id);
        LoadData();
        txtusername.setText("");
        txtpassword.setText("");
        Toast.makeText(getApplicationContext(),"Delete Success",Toast.LENGTH_SHORT).show();

    }

    public void forinsertuser(){

        String username1 = txtusername.getText().toString();
        String password1 = txtpassword.getText().toString();
        if(username1.toString().trim().length() != 0 && password1.toString().trim().length() != 0 ) {

            dbTools.insertData(username1, password1);
            LoadData();
            txtusername.setText("");
            txtpassword.setText("");

        }
        else{
            Toast.makeText(getApplicationContext(),"Please complete the requirements!",Toast.LENGTH_SHORT).show();

        }
    }

    public void forupdateuser(){

        if(dbTools.updateData(update_id,txtusername.getText().toString(),txtpassword.getText().toString()) > 0 ){
            Toast.makeText(getApplicationContext(),"Update Succese",Toast.LENGTH_SHORT).show();
            LoadData();
            txtusername.setText("");
            txtpassword.setText("");
        }


    }
    public void forsearch(){
        Intent intent = new Intent(Main_Form.this,Search_Form.class);
        startActivityForResult(intent,1);

    }

    public class ListViewItemLongClick implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


            String row = adapter.getItem(i).toString();
            String details[] = row.split(",");
            update_id = Integer.valueOf(details[0]);
            txtusername.setText(details[1]);
            txtpassword.setText(details[2]);

            btnsave.setText("UPDATE");
            return false;
        }
    }

    private class ButtonEvent implements View.OnClickListener {

        public void onClick(View v) {
            if (btnsave == v) {
                if(btnsave.getText().toString().equals("SAVE")) {
                    forinsertuser();
                }
                else {

                    forupdateuser();
                }

            } else if (btnsearch == v) {
                forsearch();
            }
        }
    }
}
