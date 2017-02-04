package com.piser.apps.AppTwo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.piser.apps.R;

public class AppTwo extends FragmentActivity implements
        OnMapReadyCallback, ConnectionCallbacks, OnConnectionFailedListener {

    private GoogleMap mMap;
    private GoogleApiClient googleApiClient;
    private Location lastLocation;

    private EditText latInput;
    private EditText lonInput;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_two);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        latInput = (EditText) findViewById(R.id.input_lat);
        lonInput = (EditText) findViewById(R.id.input_lon);
        go = (Button) findViewById(R.id.go_btn);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lat_string = latInput.getText().toString();
                String lon_string = lonInput.getText().toString();
                if(lat_string.isEmpty() || lon_string.isEmpty())
                    Toast.makeText(getApplicationContext(), "Los campos tienen que estar completos", Toast.LENGTH_LONG).show();
                else {
                    Double lat = Double.parseDouble(lat_string);
                    Double lon = Double.parseDouble(lon_string);
                    LatLng position = new LatLng(lat,lon);
                    if(mMap != null && lastLocation != null) {
                        double latitude = lastLocation.getLatitude();
                        double longitude = lastLocation.getLongitude();
                        LatLng myposition = new LatLng(latitude,longitude);
                        mMap.addPolyline(new PolylineOptions().geodesic(true)
                                .add(myposition)  // Mylocation
                                .add(position)    // new position
                        );
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No se puede acceder al mapa", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings settings = mMap.getUiSettings();
        settings.setCompassEnabled(true);
        settings.setAllGesturesEnabled(true);
        settings.setMyLocationButtonEnabled(true);
        settings.setZoomControlsEnabled(true);
    }

    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e("MAPS", "NO PERMISSIONS");
            return;
        }
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (lastLocation != null) {
            double latitude = lastLocation.getLatitude();
            double longitude = lastLocation.getLongitude();
            LatLng position = new LatLng(latitude,longitude);
            Toast.makeText(getApplicationContext(),
                    "Latitude: "+latitude+"\nLongitude: "+longitude, Toast.LENGTH_LONG).show();
            if(mMap != null) {
                mMap.addMarker(new MarkerOptions().position(position).title("My position"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 14));
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Error Location", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.e("MAPS", "CONNECTION SUSPENDED");
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e("MAPS", "CONNECTION FAILED");
    }
}
