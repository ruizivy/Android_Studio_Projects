package com.example.ruiz.androidsqldb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    Button btn_ok , btn_cancel;
    EditText txtsearching;
    Intent dataIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txtsearching = (EditText)findViewById(R.id.txtSearch);
        btn_ok = (Button)findViewById(R.id.btnOK);
        btn_cancel = (Button)findViewById(R.id.btnCancel);
        btn_ok.setOnClickListener(new ButtonEvent());

    }
    private class ButtonEvent implements View.OnClickListener{
        public  void onClick(View v){
            if(v == btn_ok)
            {
                SaveData();
            }else if(v == btn_cancel){
                Toast.makeText(SearchActivity.this , "Cancel" , Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void SaveData()
    {
        try {
            dataIntent = getIntent();
            dataIntent.putExtra("id" , txtsearching.getText().toString());
            setResult(1, dataIntent);
            finish();
        } catch (Exception ex) {
            //Toast.makeText(SecondActivity.this , "Please fill up the whole form" , Toast.LENGTH_SHORT).show();
        }
    }
}
