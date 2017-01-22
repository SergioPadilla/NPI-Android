package com.piser.apps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.piser.apps.AppFour.AppFour;
import com.piser.apps.AppOne.AppOne;
import com.piser.apps.AppThree.AppThree;
import com.piser.apps.AppTwo.AppTwo;

public class ActivitySelector extends AppCompatActivity {

    private FrameLayout app_one;
    private FrameLayout app_two;
    private FrameLayout app_three;
    private FrameLayout app_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        app_one = (FrameLayout) findViewById(R.id.app_one);
        app_two = (FrameLayout) findViewById(R.id.app_two);
        app_three = (FrameLayout) findViewById(R.id.app_three);
        app_four = (FrameLayout) findViewById(R.id.app_four);

        app_one.setOnClickListener(appOneListener(AppOne.class));
        app_two.setOnClickListener(appOneListener(AppTwo.class));
        app_three.setOnClickListener(appOneListener(AppThree.class));
        app_four.setOnClickListener(appOneListener(AppFour.class));
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
