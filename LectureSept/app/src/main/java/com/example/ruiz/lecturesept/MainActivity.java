package com.example.ruiz.lecturesept;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt_text;
    SensorManager sensorManager;
    Sensor sensor;
    List<Sensor> listOfSensors;

    float dX =0;
    float dY = 0;
    float dZ =0;
    long lastUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_text = (TextView)findViewById(R.id.txtText);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        listOfSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

//        for(Sensor s : listOfSensors){
//            txt_text.append("\n\n Sensor name: " + s.getName() +
//                            "\n Sensor Type : " + s.getType());
//        }

        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensor != null){
            sensorManager.registerListener(accelerate , sensor , sensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(getApplicationContext() , "No accelerometer found" , 1).show();
        }

    }
    private SensorEventListener accelerate = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            dX = event.values[0];
            dY = event.values[1];
            dZ = event.values[2];

            txt_text.setText("dX = " +  dX + "\n"+
                            "dY = " + dY + "\n"+
                            "dZ = " + dZ);

            long currTime = System.currentTimeMillis();
            if ((currTime - lastUpdate) > 500){
                if(((int)dX) <- 5){
                    Toast.makeText(MainActivity.this , "Right Direction" , 1).show();
                }else if(((int)dX) > 5){
                    Toast.makeText(MainActivity.this , "Left Direction" , 1).show();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.registerListener(accelerate , sensor , sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        sensorManager.registerListener(accelerate , sensor , sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(accelerate , sensor , sensorManager.SENSOR_DELAY_NORMAL);
    }
}
