package com.example.ruiz.androidsqldb;

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

import static com.example.ruiz.androidsqldb.R.id.btnsave;

public class MainActivity extends AppCompatActivity {

    EditText txt_user , txt_pass;
    Button btn_save , btn_Search;
    ListView lst_Users;
    Cursor cursor;
    DbTools dbTools;
    public int ids;
    ArrayAdapter<String> adapter;
    ArrayList<String> list;
    Intent intent;
    DialogInterface.OnClickListener dialoglistener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbTools = new DbTools(getApplicationContext());

        txt_user = (EditText)findViewById(R.id.txtuser);
        txt_pass = (EditText) findViewById(R.id.txtpass);
        btn_save = (Button)findViewById(btnsave);
        btn_Search = (Button)findViewById(R.id.btnSearch);
        lst_Users= (ListView)findViewById(R.id.lstUsers);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , list);
        lst_Users.setAdapter(adapter);

        LoadData();
        btn_save.setOnClickListener(new MyButtonEventHandler());
        btn_Search.setOnClickListener(new MyButtonEventHandler());
        lst_Users.setOnItemLongClickListener(new MyItemLongClickListener());

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
        lst_Users.setOnItemClickListener(new MyItemClickListener());
    }
    public  void LoadData(){
        list.clear();
        cursor = dbTools.getAllUsers();
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String password = cursor.getString(2);

                adapter.add(id + "," +  name + "," + password);
            }while (cursor.moveToNext());
        }else {
            Toast.makeText(getApplicationContext() , "No Record" , Toast.LENGTH_SHORT).show();
        }
    }
    private class MyButtonEventHandler implements View.OnClickListener{
        public void onClick(View v){
            if (btn_save == v) {
                if(btn_save.getText().toString().equals("SAVE")) {
                    InsertUser();
                }
                else {
                   UpdateUser();
                }
            } else if (btn_Search == v) {
                forsearch();
            }
        }
    }
    public void forsearch(){
        Toast.makeText(MainActivity.this , "Click" , Toast.LENGTH_SHORT).show();
        intent = new Intent(MainActivity.this , SearchActivity.class);
        startActivityForResult(intent , 1);
    }
    public  void InsertUser(){

        String u_name = txt_user.getText().toString();
        String pwd = txt_pass.getText().toString();

        if(!u_name.equals("") && !pwd.equals("")){
            dbTools.insertUser(u_name , pwd);
            txt_user.setText("");
            txt_pass.setText("");
            LoadData();
        }
        else
            Toast.makeText(getApplicationContext() , "Please enter username and password" , Toast.LENGTH_SHORT).show();
    }
    public  void UpdateUser(){
        if(dbTools.updateUser(ids , txt_user.getText().toString() , txt_pass.getText().toString()) > 0){
            LoadData();
            dbTools.delete(ids);
            Toast.makeText(getApplicationContext(), "Item successfully update" , Toast.LENGTH_SHORT).show();
            btn_save.setText("SAVE");
            txt_user.setText("");
            txt_pass.setText("");
        }
    }
    public void deleteUser(){
        dbTools.delete(ids);
        LoadData();
    }

    private class MyItemLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

            String row = adapter.getItem(position).toString();
            String details[] = row.split(",");
            ids = Integer.valueOf(details[0]);

            txt_user.setText(details[1]);
            txt_pass.setText(details[2]);

            btn_save.setText("UPDATE");
            return false;
        }
    }
    private class MyItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String row = adapter.getItem(position).toString();
            String details[] = row.split(",");
            ids = Integer.valueOf(details[0]);
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you want to delete?").setPositiveButton("Yes", dialoglistener).setNegativeButton("No", dialoglistener).show();
        }
    }

   // @Override
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode ==1)
            {
                if(resultCode == 1)
                {
                    /*int id1 = data.getIntExtra("id" , 1);
                    String name1 = data.getStringExtra("name");
                    String pass = data.getStringExtra("pass");
                    txt_user.setText(name1);
                    txt_pass.setText(pass);
                    btn_save.setText("UPDATE");
                    dbTools.getUser(id1);
                }
            }
    }*/
}
