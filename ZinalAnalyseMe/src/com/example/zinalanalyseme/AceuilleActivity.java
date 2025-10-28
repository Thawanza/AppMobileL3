package com.example.zinalanalyseme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AceuilleActivity extends Activity implements OnClickListener {
	
	Button btnred , btnres , btnvac , btncon ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aceuille);
		
		btncon = (Button) findViewById(R.id.btncons);
		btncon.setOnClickListener(this);
		
		btnred = (Button) findViewById(R.id.btnrdv);
		btnred.setOnClickListener(this);
		
		btnres = (Button) findViewById(R.id.btnres);
		btnres.setOnClickListener(this);
		
		btnvac = (Button) findViewById(R.id.btnvacc);
		btnvac.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		if(v == btncon){
			Intent i = new Intent(AceuilleActivity.this,ConseilsActivity.class);
			startActivity(i);
		}
		
		if(v == btnred){
			Intent i2 = new Intent(AceuilleActivity.this,RendezvousActivity.class);
			startActivity(i2);
		}
		
	}

	

}
