package com.piser.apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.piser.apps.AppOne.AppOne;
import com.piser.apps.AppTwo.AppTwo;
import com.piser.apps.AppThree.AppThree;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

public class ActivitySelector extends AppCompatActivity {

    private FrameLayout app_one, app_two, app_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        app_one = (FrameLayout) findViewById(R.id.app_one);
        app_two = (FrameLayout) findViewById(R.id.app_two);
        app_three = (FrameLayout) findViewById(R.id.app_three);

        app_one.setOnClickListener(appOneListener(AppOne.class));
        app_two.setOnClickListener(appOneListener(AppTwo.class));
        app_three.setOnClickListener(appOneListener(AppThree.class));

        ImageView mv = (ImageView) findViewById(R.id.mv);
        final TextView grtv = (TextView) findViewById(R.id.grtv);
        SimpleFingerGestures sfg = new SimpleFingerGestures();
        sfg.setDebug(true);
        sfg.setConsumeTouchEvents(true);

        sfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
            @Override
            public boolean onSwipeUp(int fingers, long gestureDuration, double gestureDistance) {
                grtv.setText("Has deslizado " + fingers + " dedos  hacia arriba " + gestureDuration + " milisegundos ");
                return false;
            }

            @Override
            public boolean onSwipeDown(int fingers, long gestureDuration, double gestureDistance) {
                grtv.setText("Has deslizado " + fingers + " dedos  hacia abajo " + gestureDuration + " milisegundos " );
                return false;
            }

            @Override
            public boolean onSwipeLeft(int fingers, long gestureDuration, double gestureDistance) {
                grtv.setText("Has deslizado " + fingers + " dedos  hacia la izquierda " + gestureDuration + " milisegundos " );
                return false;
            }

            @Override
            public boolean onSwipeRight(int fingers, long gestureDuration, double gestureDistance) {
                grtv.setText("Has deslizado " + fingers + " dedos  hacia la derecha " + gestureDuration + " milisegundos " );
                return false;
            }

            @Override
            public boolean onPinch(int fingers, long gestureDuration, double gestureDistance) {
                grtv.setText("Has pellizcado con " + fingers + " dedos " + gestureDuration + " milisegundos " );
                return false;
            }

            @Override
            public boolean onUnpinch(int fingers, long gestureDuration, double gestureDistance) {
                grtv.setText("Has  estirado " + fingers + "dedos"  + gestureDuration + " milisegundos ");
                return false;
            }

            @Override
            public boolean onDoubleTap(int fingers) {
                grtv.setText("Doble Click");
                return false;
            }
        });


        mv.setOnTouchListener(sfg);


    }

    private void initActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }

    private View.OnClickListener appOneListener(final Class activity) {
        /**
         * Get the action for first button
         */
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initActivity(activity);
            }
        };
    }
}
