package com.piser.apps;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.*;

public class ActivitySelector extends AppCompatActivity implements SensorEventListener {

    private TextView salida,salida0,salida1,salida2,salida3,salida4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        salida = (TextView) findViewById(R.id.salida);
        salida0 = (TextView) findViewById(R.id.salida0);
        salida1 = (TextView) findViewById(R.id.salida1);
        salida2 = (TextView) findViewById(R.id.salida2);
        salida3 = (TextView) findViewById(R.id.salida3);

        SensorManager sensorManager = (SensorManager)
                getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.
                getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : listaSensores) {
            log(sensor.getName(),4);
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);}
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_UI);}
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (!listaSensores.isEmpty()) {
            Sensor magneticSensor = listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor,
                    SensorManager.SENSOR_DELAY_UI);}
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_TEMPERATURE);
        if (!listaSensores.isEmpty()) {
            Sensor temperatureSensor = listaSensores.get(0);
            sensorManager.registerListener(this, temperatureSensor,
                    SensorManager.SENSOR_DELAY_UI);}

    }
    private void log(String string,int id) {
        switch (id){
            case 0:
                salida0.setText(string + "\n");
                break;
            case 1:
                salida1.setText(string + "\n");
                break;
            case 2:
                salida2.setText(string + "\n");
                break;
            case 3:
                salida3.setText(string + "\n");
                break;
            case  4:
                salida.append(string + "\n");

            default:
                break;
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Cada sensor puede provocar que un thread principal pase por aquí
        //así que sincronizamos el acceso
        synchronized (this) {
            switch(event.sensor.getType()) {
                case Sensor.TYPE_ORIENTATION:
                    log("Orientación 0: "+event.values[0]+
                            "\n Orientación 1: "+event.values[1]+
                            "\n Orientación 2: "+event.values[2],0);
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    log("Acelerometro 0: "+event.values[0]+
                            "\nAcelerometro 1: "+event.values[1]+
                            "\nAcelerometro 2: "+event.values[2],1);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    log("\nMagentismo 0: "+event.values[0]+
                            "\nMagnetismo 1: "+event.values[1]+
                            "\nMagnetismo 2: "+event.values[2],2);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
