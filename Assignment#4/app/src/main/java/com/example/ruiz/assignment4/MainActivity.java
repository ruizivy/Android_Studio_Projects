package com.example.ruiz.assignment4;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnsave, btnsearch;
    EditText txtusername , txtpassword;
    ListView lstuser;

    Cursor cursor;
    DBTools dbTools;

    ArrayAdapter<String> adapter;
    ArrayList list;

    public int ids = 1;

    DialogInterface.OnClickListener dialoglistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new ButtonEvent());

        btnsearch = (Button) findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new ButtonEvent());

        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);

        lstuser = (ListView) findViewById(R.id.lstuser);
        lstuser.setOnItemLongClickListener(new ListViewItemLongClick());
        lstuser.setOnItemClickListener(new MyItemClickListener());

        dbTools = new DBTools(getApplicationContext());
        list = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        lstuser.setAdapter(adapter);

        dialoglistener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE :
                        deleteUser();
                        Toast.makeText(MainActivity.this, "Item successfully deleted", Toast.LENGTH_SHORT).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //Toast.makeText(MainActivity.this, "Item was not added", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
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
    public void deleteUser(){
        dbTools.delete(ids);
        LoadData();
        txtpassword.setText("");
        txtusername.setText("");
        btnsave.setText("SAVE");
        Toast.makeText(MainActivity.this , "Item successfully deleted" , Toast.LENGTH_SHORT).show();
    }

    public void InsertUser(){

        String username1 = txtusername.getText().toString();
        String password1 = txtpassword.getText().toString();
        if(username1.toString().trim().length() != 0 && password1.toString().trim().length() != 0 ) {

            dbTools.insertUser(username1, password1);
            LoadData();
            txtusername.setText("");
            txtpassword.setText("");

        }
        else{
            Toast.makeText(getApplicationContext(),"Please complete the requirements!",Toast.LENGTH_SHORT).show();
        }
    }

    public void UpdateUser(){

        if(dbTools.updateUser(ids,txtusername.getText().toString(),txtpassword.getText().toString()) > 0 ){
            Toast.makeText(getApplicationContext(),"Update Success",Toast.LENGTH_SHORT).show();
            LoadData();
            txtusername.setText("");
            txtpassword.setText("");
            btnsave.setText("SAVE");
        }

    }
    public void forsearch(){
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivityForResult(intent,1);
    }

    public class ListViewItemLongClick implements AdapterView.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            String row = adapter.getItem(i).toString();
            String details[] = row.split(",");
            ids = Integer.valueOf(details[0]);
            txtusername.setText(details[1]);
            txtpassword.setText(details[2]);

            btnsave.setText("UPDATE");
            return true;
        }
    }

    private class ButtonEvent implements View.OnClickListener {

        public void onClick(View v) {
            if (btnsave == v) {
                if(btnsave.getText().toString().equals("SAVE")) {
                    InsertUser();
                }
                else {
                   UpdateUser();

                }

            } else if (btnsearch == v) {
                forsearch();
            }
        }
    }
    private class MyItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            String row = adapter.getItem(position).toString();
            String details[] = row.split(",");
            ids = Integer.valueOf(details[0]);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you want to delete?").setPositiveButton("Yes", dialoglistener).setNegativeButton("No", dialoglistener).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==1) {
            if(resultCode ==1){
                String id = data.getStringExtra("aydi");
                int num = Integer.parseInt(id);
               cursor =  dbTools.getUser(num);
                if(cursor.moveToFirst()){
                    do{
                        txtusername.setText(cursor.getString(1));
                        txtpassword.setText(cursor.getString(2));
                        btnsave.setText("UPDATE");
                    }while (cursor.moveToNext());
                }else {
                    Toast.makeText(getApplicationContext() , "No Record" , Toast.LENGTH_SHORT).show();
                    btnsave.setText("SAVE");
                }
            }
        }else if(requestCode ==2){
            if(resultCode ==2){
                txtusername.setText("");
                txtpassword.setText("");
                btnsave.setText("SAVE");
            }
        }
    }
}
