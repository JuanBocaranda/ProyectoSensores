package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.hardware.Sensor;
import android.widget.TextView;
import android.os.Bundle;

public class Proximidad extends AppCompatActivity {
    private TextView txt;

    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximidad);
        initializeViews();

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (sensor == null)
            finish();

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0]<sensor.getMaximumRange()){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                    txt.setText("MUY CERCA");
                }else{
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                    txt.setText("DISTACIA RESPETABLE");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        start();
    }

    public void initializeViews() {

        txt = (TextView) findViewById(R.id.txt);
    }

    public void start(){
        sensorManager.registerListener(sensorEventListener,sensor,2000*1000);
    }

    public void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }
}