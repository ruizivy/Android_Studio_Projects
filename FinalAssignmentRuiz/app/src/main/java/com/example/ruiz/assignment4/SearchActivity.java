package com.example.ruiz.assignment4;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends Activity {

    Button btn_register , btncancel;
    EditText txtuname , txtpword, txt_name , txt_cpass;
    Intent dataIntent;
    DBPlaces dbPlaces;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txtuname = (EditText)findViewById(R.id.txtuname);
        txtpword = (EditText)findViewById(R.id.txtpword);
        txt_name = (EditText)findViewById(R.id.txtName);
        txt_cpass = (EditText)findViewById(R.id.txtconfirm);

        btn_register = (Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new ButtonEvent());
        btncancel = (Button)findViewById(R.id.btnCancel);
        btncancel.setOnClickListener(new ButtonEvent());

        txt_name.setOnFocusChangeListener(new Focus());
        txtuname.setOnFocusChangeListener(new Focus());
        txtpword.setOnFocusChangeListener(new Focus());
        txt_cpass.setOnFocusChangeListener(new Focus());

    }
    private class ButtonEvent implements View.OnClickListener{
        public  void onClick(View v){
            if(v == btn_register)
            {
                if (txt_name.getText().toString().trim().length() != 0 &&
                        txtuname.getText().toString().trim().length() != 0 &&
                        txtpword.getText().toString().trim().length() != 0 &&
                        txt_cpass.getText().toString().trim().length() != 0) {
                    if (txtpword.getText().toString().equals(txt_cpass.getText().toString())) {
                            CreateAccount();
                    } else {
                        Toast.makeText(SearchActivity.this, "Password and Current Password did not match!",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SearchActivity.this, "Fill all the Text field to proceed!",
                            Toast.LENGTH_SHORT).show();
                    }
              setResult(1 , dataIntent);
                finish();
            }else if(v == btncancel){
                setResult(2 , dataIntent);
                finish();
            }
        }
    }
    private class Focus implements View.OnFocusChangeListener{
        @Override
        public void onFocusChange(View view, boolean b) {
            if(view == txt_name){
                if(b)
                    txt_name.setHint("");
                else
                    txt_name.setHint("Name");
            }
            if(view == txtuname)
                if(b)
                    txtuname.setHint("");
                else
                    txtuname.setHint("Username");
            if(view == txtpword)
                if(b)
                    txtpword.setHint("");
                else
                    txtpword.setHint("Password");
            if(view == txt_cpass)
                if(b)
                    txt_cpass.setHint("");
                else
                    txt_cpass.setHint("Confirm Password");
        }
    }

    private void CreateAccount() {
        cursor = dbPlaces.getUsername(txtuname.getText().toString());
        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Username already exist!", Toast.LENGTH_SHORT).show();
        } else {
            dbPlaces.insertUser(
                    txtuname.getText().toString(),
                    txtpword.getText().toString(),
                    txt_cpass.getText().toString()
            );
        }
    }
}
