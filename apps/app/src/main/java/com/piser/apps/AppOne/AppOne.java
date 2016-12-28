package com.piser.apps.AppOne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.piser.apps.R;

public class AppOne extends AppCompatActivity {

    Button updateButton;
    TextView latitude;
    TextView longitude;

    // GPSTracker class
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_one);

        gps = new GPSTracker(AppOne.this);

        updateButton = (Button) findViewById(R.id.updateButton);
        longitude = (TextView) findViewById(R.id.longitudeValue);
        latitude = (TextView) findViewById(R.id.latitudeValue);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // check if GPS enabled
                if(gps.canGetLocation()){
                    latitude.setText(Double.toString(gps.getLatitude()));
                    longitude.setText(Double.toString(gps.getLongitude()));
                }else{
                    // can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
                    gps.showSettingsAlert();
                }
            }
        });
    }
}
