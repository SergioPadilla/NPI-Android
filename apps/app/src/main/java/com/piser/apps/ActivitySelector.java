package com.piser.apps;

import android.content.Context;
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
import android.os.Vibrator;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

public class ActivitySelector extends AppCompatActivity {

    private FrameLayout app_one, app_two, app_three;

    Vibrator vibrator;
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

        vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);

        final ImageView mv = (ImageView) findViewById(R.id.mv);
        final TextView grtv = (TextView) findViewById(R.id.grtv);
        SimpleFingerGestures sfg = new SimpleFingerGestures();
        sfg.setDebug(true);
        sfg.setConsumeTouchEvents(true);

        sfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
            @Override
            public boolean onSwipeUp(int fingers, long gestureDuration, double gestureDistance) {
                long[] pattern = {
                        0,600
                };

                vibrator.vibrate(pattern, -1); // no repite patron
                grtv.setText("Has deslizado " + fingers + " dedos  hacia arriba " + gestureDuration + " milisegundos ");
                if (fingers==1) {
                    mv.setBackgroundResource(R.drawable.board_up);
                }
                else if (fingers==2) {
                    mv.setBackgroundResource(R.drawable.board_up_2);
                }
                else if (fingers==3) {
                    mv.setBackgroundResource(R.drawable.board_up_3);
                }
                else if (fingers==4) {
                    mv.setBackgroundResource(R.drawable.board_up_4);
                }
                return false;
            }

            @Override
            public boolean onSwipeDown(int fingers, long gestureDuration, double gestureDistance) {
                long[] pattern = {
                        0,600
                };
                vibrator.vibrate(pattern, -1); // no repite patron
                grtv.setText("Has deslizado " + fingers + " dedos  hacia abajo " + gestureDuration + " milisegundos " );

                if (fingers==1) {
                    mv.setBackgroundResource(R.drawable.board_down);
                }
                else if (fingers==2) {
                    mv.setBackgroundResource(R.drawable.board_down_2);
                }
                else if (fingers==3) {
                    mv.setBackgroundResource(R.drawable.board_down_3);
                }
                else if (fingers==4) {
                    mv.setBackgroundResource(R.drawable.board_down_4);
                }

                return false;
            }

            @Override
            public boolean onSwipeLeft(int fingers, long gestureDuration, double gestureDistance) {
                long[] pattern = {
                        0,600
                };
                vibrator.vibrate(pattern, -1); // no repite patron
                grtv.setText("Has deslizado " + fingers + " dedos  hacia la izquierda " + gestureDuration + " milisegundos " );
                if (fingers==1) {
                    mv.setBackgroundResource(R.drawable.board_left);
                }
                else if (fingers==2) {
                    mv.setBackgroundResource(R.drawable.board_left_2);
                }
                else if (fingers==3) {
                    mv.setBackgroundResource(R.drawable.board_left_3);
                }
                else if (fingers==4) {
                    mv.setBackgroundResource(R.drawable.board_left_4);
                }
                return false;
            }

            @Override
            public boolean onSwipeRight(int fingers, long gestureDuration, double gestureDistance) {
                long[] pattern = {
                        0,600
                };
                vibrator.vibrate(pattern, -1); // no repite patron
                grtv.setText("Has deslizado " + fingers + " dedos  hacia la derecha " + gestureDuration + " milisegundos " );
                if (fingers==1) {
                    mv.setBackgroundResource(R.drawable.board_right);
                }
                else if (fingers==2) {
                    mv.setBackgroundResource(R.drawable.board_right_2);
                }
                else if (fingers==3) {
                    mv.setBackgroundResource(R.drawable.board_right_3);
                }
                else if (fingers==4) {
                    mv.setBackgroundResource(R.drawable.board_right_4);
                }
                return false;
            }

            @Override
            public boolean onPinch(int fingers, long gestureDuration, double gestureDistance) {
                long[] pattern = {
                        0,400,20,300,20,200,20,100
                };
                vibrator.vibrate(pattern, -1); // no repite patron
                grtv.setText("Has pellizcado con " + fingers + " dedos " + gestureDuration + " milisegundos " );
                mv.setBackgroundResource(R.drawable.pellizco);
                return false;
            }

            @Override
            public boolean onUnpinch(int fingers, long gestureDuration, double gestureDistance) {
                long[] pattern = {
                        0,100,20,200,20,300,20,400
                };
                vibrator.vibrate(pattern, -1); // no repite patron
                grtv.setText("Has  estirado " + fingers + "dedos"  + gestureDuration + " milisegundos ");
                mv.setBackgroundResource(R.drawable.estirado);
                return false;
            }

            @Override
            public boolean onDoubleTap(int fingers) {
                grtv.setText("Doble Click");

                long[] pattern = {
                        0,50,20,50
                };
                vibrator.vibrate(pattern, -1); // no repite patron
                mv.setBackgroundResource(R.drawable.doubleclick);

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
