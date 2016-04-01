package com.altaf.multiitemlist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TotalPrice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_total_price);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.total_price, menu);
		return true;
	}

}
