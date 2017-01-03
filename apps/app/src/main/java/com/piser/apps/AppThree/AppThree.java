package com.piser.apps.AppThree;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;

import com.piser.apps.R;


public class AppThree extends ActionBarActivity {

    private static final String TAG = "CompassActivity";

    private Compass compass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_three);

        compass = new Compass(this);
        compass.arrowView = (ImageView) findViewById(R.id.main_image_hands);
        compass.tOrientacion = (TextView) findViewById(R.id.tOrientacion);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "start compass");
        compass.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "stop compass");
        compass.stop();
    }
    @Override
    protected void onPause() {
        super.onPause();
        compass.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        compass.start();
    }



}