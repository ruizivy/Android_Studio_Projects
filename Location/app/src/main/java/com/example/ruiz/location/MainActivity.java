package com.example.ruiz.location;

import android.app.Service;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt1 , txt2;
    LocationManager manager;
    MyLocationListener listener = new MyLocationListener();

    Criteria criteria;
    String bestProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);

        criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        manager = (LocationManager)getSystemService(Service.LOCATION_SERVICE);
        try {
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER , 0, 0, listener);
        }catch (SecurityException ex){}

        bestProvider = manager.getBestProvider(criteria, true);
        Toast.makeText(getApplicationContext() , bestProvider , Toast.LENGTH_SHORT).show();
    }
    private  class  MyLocationListener implements LocationListener{
        @Override
        public void onLocationChanged(Location location) {

            txt1.setText("Latitude : " + location.getLatitude() + "\n"+
                         "Longitude : " + location.getLongitude());
        }

        @Override
        public void onProviderDisabled(String s) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }
    }
}
