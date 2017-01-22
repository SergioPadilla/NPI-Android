package com.piser.apps.AppFour;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.piser.apps.R;

import in.championswimmer.sfg.lib.SimpleFingerGestures;

public class AppFour extends AppCompatActivity implements SimpleFingerGestures.OnFingerGestureListener {
    
    private ImageView board;
    private TextView grtv;

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_four);

        board = (ImageView) findViewById(R.id.board);
        grtv = (TextView) findViewById(R.id.grtv);
        
        SimpleFingerGestures sfg = new SimpleFingerGestures();
        sfg.setDebug(true);
        sfg.setConsumeTouchEvents(true);
        sfg.setOnFingerGestureListener(this);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        board.setOnTouchListener(sfg);
    }

    @Override
    public boolean onSwipeUp(int fingers, long gestureDuration, double gestureDistance) {
        long[] pattern = {
                0,600
        };

        vibrator.vibrate(pattern, -1); // no repite patron
        grtv.setText("Has deslizado " + fingers + " dedos  hacia arriba " + gestureDuration + " milisegundos ");
        if (fingers==1) {
            board.setBackgroundResource(R.drawable.board_up);
        }
        else if (fingers==2) {
            board.setBackgroundResource(R.drawable.board_up_2);
        }
        else if (fingers==3) {
            board.setBackgroundResource(R.drawable.board_up_3);
        }
        else if (fingers==4) {
            board.setBackgroundResource(R.drawable.board_up_4);
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
            board.setBackgroundResource(R.drawable.board_down);
        }
        else if (fingers==2) {
            board.setBackgroundResource(R.drawable.board_down_2);
        }
        else if (fingers==3) {
            board.setBackgroundResource(R.drawable.board_down_3);
        }
        else if (fingers==4) {
            board.setBackgroundResource(R.drawable.board_down_4);
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
            board.setBackgroundResource(R.drawable.board_left);
        }
        else if (fingers==2) {
            board.setBackgroundResource(R.drawable.board_left_2);
        }
        else if (fingers==3) {
            board.setBackgroundResource(R.drawable.board_left_3);
        }
        else if (fingers==4) {
            board.setBackgroundResource(R.drawable.board_left_4);
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
            board.setBackgroundResource(R.drawable.board_right);
        }
        else if (fingers==2) {
            board.setBackgroundResource(R.drawable.board_right_2);
        }
        else if (fingers==3) {
            board.setBackgroundResource(R.drawable.board_right_3);
        }
        else if (fingers==4) {
            board.setBackgroundResource(R.drawable.board_right_4);
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
        board.setBackgroundResource(R.drawable.pellizco);
        return false;
    }

    @Override
    public boolean onUnpinch(int fingers, long gestureDuration, double gestureDistance) {
        long[] pattern = {
                0,100,20,200,20,300,20,400
        };
        vibrator.vibrate(pattern, -1); // no repite patron
        grtv.setText("Has  estirado " + fingers + "dedos"  + gestureDuration + " milisegundos ");
        board.setBackgroundResource(R.drawable.estirado);
        return false;
    }

    @Override
    public boolean onDoubleTap(int fingers) {
        grtv.setText("Doble Click");

        long[] pattern = {
                0,50,20,50
        };
        vibrator.vibrate(pattern, -1); // no repite patron
        board.setBackgroundResource(R.drawable.doubleclick);

        return false;
    }
}
