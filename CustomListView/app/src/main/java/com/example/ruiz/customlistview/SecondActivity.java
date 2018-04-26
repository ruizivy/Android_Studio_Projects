package com.example.ruiz.customlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.ruiz.customlistview.R.id.btnsave;

public class SecondActivity extends AppCompatActivity {

    private List<Employee> employees = new ArrayList<Employee>();
    Intent dataIntent;
    EditText i_d , pangalan , add_ress , posi_tion , mob_ile, e_mail;
    Button  btn_save;
    DialogInterface.OnClickListener dialoglistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        i_d = (EditText)findViewById(R.id.lblID);
        pangalan = (EditText)findViewById(R.id.lblfullname);
        add_ress = (EditText)findViewById(R.id.lbladdress);
        posi_tion = (EditText)findViewById(R.id.lblposition);
        mob_ile = (EditText) findViewById(R.id.lblmobile);
        e_mail = (EditText) findViewById(R.id.lblemail);
        btn_save = (Button) findViewById(btnsave);


      dialoglistener = new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which) {
              switch (which){
                  case DialogInterface.BUTTON_POSITIVE :
                      SaveData();
                      Toast.makeText(SecondActivity.this, "Item was successfully added", Toast.LENGTH_SHORT).show();
                      break;
                  case DialogInterface.BUTTON_NEGATIVE:
                      Toast.makeText(SecondActivity.this, "Item was not added", Toast.LENGTH_SHORT).show();
                      break;
              }
          }
      };
      btn_save.setOnClickListener(new ButtonEvent());
    }
    private class ButtonEvent implements View.OnClickListener{
        public  void onClick(View v){
            String ids = i_d.getText().toString();
            String name1 = pangalan.getText().toString();
            String pos = posi_tion.getText().toString();
            String addr = add_ress.getText().toString();
            if(ids.trim().length() != 0 && name1.trim().length() != 0 && pos.trim().length() != 0 && addr.trim().length() != 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
                builder.setMessage("Do you want to save?").setPositiveButton("Yes", dialoglistener).setNegativeButton("No", dialoglistener).show();
            }else{
                Toast.makeText(SecondActivity.this , "Please fill up the whole form" , Toast.LENGTH_SHORT).show();
            }
        }
    }
    public  void SaveData()
    {
            try {
                dataIntent = getIntent();
                dataIntent.putExtra("id", i_d.getText().toString());
                dataIntent.putExtra("full_name", pangalan.getText().toString());
                dataIntent.putExtra("position", posi_tion.getText().toString());
                dataIntent.putExtra("address", add_ress.getText().toString());
                dataIntent.putExtra("mobile", mob_ile.getText().toString());
                dataIntent.putExtra("email", e_mail.getText().toString());
                setResult(1, dataIntent);
                finish();

            } catch (Exception ex) {
                //Toast.makeText(SecondActivity.this , "Please fill up the whole form" , Toast.LENGTH_SHORT).show();
            }
    }
}
