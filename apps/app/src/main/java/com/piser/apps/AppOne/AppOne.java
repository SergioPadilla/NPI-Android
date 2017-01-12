package com.piser.apps.AppOne;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.piser.apps.R;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AppOne extends AppCompatActivity {

    Button updateButton;
    TextView latitude;
    TextView longitude;
    TextView city;
    TextView country;
    TextView street;
    TextView postal_code;

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
        street = (TextView) findViewById(R.id.streetValue);
        city = (TextView) findViewById(R.id.cityValue);
        country = (TextView) findViewById(R.id.countryValue);
        postal_code = (TextView) findViewById(R.id.postalCodeValue);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // check if GPS enabled
                if(gps.canGetLocation()){
                    double vlatitude = gps.getLatitude();
                    double vlongitude = gps.getLongitude();
                    latitude.setText(Double.toString(vlatitude));
                    longitude.setText(Double.toString(vlongitude));
                    Geocoder geocoder = new Geocoder(AppOne.this, Locale.getDefault());
                    String cityName = "";
                    String countryName = "";
                    String code = "";
                    String thoroughtfare = "";
                    try {
                        List<Address> addresses = geocoder.getFromLocation(vlatitude, vlongitude, 1);
                        if(addresses != null) {
                            cityName = addresses.get(0).getLocality();
                            countryName = addresses.get(0).getCountryName();
                            code = addresses.get(0).getPostalCode();
                            thoroughtfare = addresses.get(0).getThoroughfare();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e("GPS VOLLEY", "CATCH");
                    }
                    street.setText(thoroughtfare);
                    city.setText(cityName);
                    postal_code.setText(code);
                    country.setText(countryName);
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
