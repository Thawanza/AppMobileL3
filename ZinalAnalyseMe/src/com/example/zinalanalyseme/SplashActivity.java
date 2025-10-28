package com.example.zinalanalyseme;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {

	Handler hand;
	boolean btnback = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		hand = new Handler();
		hand.postDelayed(new Runnable() {

			@Override
			public void run() {
				finish();
				if (!btnback) {
					Intent i = new Intent(SplashActivity.this,
							WelcomeActivity.class);
					startActivity(i);
				}

			}
		}, 5000);

	}

	@Override
	// clique sur btn retour arriere
	public void onBackPressed() {
		super.onBackPressed();
		btnback = true;
	}

}
