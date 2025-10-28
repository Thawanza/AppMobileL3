package com.admina;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AcceuilleActivity extends Activity implements OnClickListener {
	Button btn1, btn2, btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acceuille);

		btn1 = (Button) findViewById(R.id.bajouterv);
		btn1.setOnClickListener(this);

		btn2 = (Button) findViewById(R.id.btngestionresultat);
		btn2.setOnClickListener(this);

		btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btn1) {
			Intent i = new Intent(this, ListeRDVActivity.class);
			startActivity(i);
		}
		if (v == btn2) {
			Intent i2 = new Intent(AcceuilleActivity.this,ListePatientActivity.class);
			startActivity(i2);
		}
		if (v == btn3) {
			Intent i = new Intent(this, PVActivity.class);
			startActivity(i);
		}
	}

}

