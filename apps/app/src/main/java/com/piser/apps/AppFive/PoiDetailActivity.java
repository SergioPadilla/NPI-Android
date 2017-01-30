package com.piser.apps.AppFive;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.piser.apps.R;

public class PoiDetailActivity extends Activity {

	public static final String EXTRAS_KEY_POI_ID = "id";
	public static final String EXTRAS_KEY_POI_TITILE = "title";
	public static final String EXTRAS_KEY_POI_DESCR = "description";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.poidetail);
		
		((TextView)findViewById(R.id.poi_id)).setText(  getIntent().getExtras().getString(EXTRAS_KEY_POI_ID) );
		((TextView)findViewById(R.id.poi_title)).setText( getIntent().getExtras().getString(EXTRAS_KEY_POI_TITILE) );
		((TextView)findViewById(R.id.poi_description)).setText(  getIntent().getExtras().getString(EXTRAS_KEY_POI_DESCR) );
	}
}
