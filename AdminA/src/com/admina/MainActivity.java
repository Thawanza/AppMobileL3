package com.admina;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {
	MediaPlayer mp;
	Handler hand;
	boolean btnback = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		hand = new Handler();
		hand.postDelayed(new Runnable() {

			@Override
			public void run() {
				finish();
				if (!btnback) {
					Intent i = new Intent(MainActivity.this, AuActivity.class);
					startActivity(i);
				}
			}
		}, 2000);

	}

	

	@Override
	// clique sur btn retour arriere
	public void onBackPressed() {
		super.onBackPressed();
		btnback = true;
	}
	}
