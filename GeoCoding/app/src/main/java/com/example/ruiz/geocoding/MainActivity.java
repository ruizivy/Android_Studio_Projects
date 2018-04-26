package com.example.ruiz.geocoding;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etvalue;
    TextView etresult;
    Button btngeo , btnrevgeo;
    Geocoder geocoder;
    List<Address> address = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
              etvalue = (EditText)findViewById(R.id.etValue);
        etresult = (TextView) findViewById(R.id.etResult);

        btngeo = (Button)findViewById(R.id.btnGeo);
        btnrevgeo = (Button)findViewById(R.id.btnRevGeo);

        geocoder = new Geocoder(getApplicationContext());

        btngeo.setOnClickListener(new MyButtonEvent());
        btnrevgeo.setOnClickListener(new MyButtonEvent());
    }

    private class MyButtonEvent implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view == btngeo){
                try {
                    address.clear();
                    String[] val = etvalue.getText().toString().split(",");
                    address = geocoder.getFromLocation(Double.valueOf(val[0]), Double.valueOf(val[1]), 5);
                }catch (IOException ex){}
                if(address.size() > 0) {
                    for (int i = 0; i < address.get(0).getMaxAddressLineIndex(); i++) {
                        etresult.append(address.get(0).getAddressLine(i) + "\n");
                    }
                }
            }else if(view == btnrevgeo){
                int numAddress =0;
                Geocoder geo = new Geocoder(getApplicationContext(), Locale.getDefault());
                String loc = etvalue.getText().toString();
                try{
                    address = geo.getFromLocationName(loc ,5);
                   if(address.size() > 0){
                       etresult.setText("Lat : " + address.get(0).getLatitude() +
                       "Long : " + address.get(0).getLongitude());
                   }
                }catch(Exception ex){

                }
            }
        }
    }
}
