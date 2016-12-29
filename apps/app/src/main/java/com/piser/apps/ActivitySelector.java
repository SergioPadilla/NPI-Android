package com.piser.apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.piser.apps.AppOne.AppOne;
import com.piser.apps.AppTwo.AppTwo;

public class ActivitySelector extends AppCompatActivity {

    private FrameLayout app_one, app_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        app_one = (FrameLayout) findViewById(R.id.app_one);
        app_two = (FrameLayout) findViewById(R.id.app_two);

        app_one.setOnClickListener(appOneListener(AppOne.class));
        app_two.setOnClickListener(appOneListener(AppTwo.class));
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
