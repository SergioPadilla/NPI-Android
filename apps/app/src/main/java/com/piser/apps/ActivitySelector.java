package com.piser.apps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.piser.apps.AppOne.AppOne;

public class ActivitySelector extends AppCompatActivity {

    private FrameLayout app_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        app_one = (FrameLayout) findViewById(R.id.app_one);


    }

    private void initActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }

    private View.OnClickListener appOneListener() {
        /**
         * Get the action for first button
         */
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initActivity(AppOne.class);
            }
        };
    }
}
