package com.piser.apps.AppFive;

import android.os.Bundle;

public class AppFive extends CamActivity {

    @Override
    protected void onPostCreate( final Bundle savedInstanceState ) {
        super.onPostCreate( savedInstanceState );
        this.injectData();
    }
}
