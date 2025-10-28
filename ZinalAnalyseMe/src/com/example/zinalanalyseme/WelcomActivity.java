package com.example.zinalanalyseme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomActivity extends Activity implements OnClickListener {
	
	Button btnsui ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcom);
		
		btnsui = (Button) findViewById(R.id.suivant22);
		btnsui.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == btnsui){
			Intent i = new Intent(WelcomActivity.this,AuthentificationActivity.class);
			startActivity(i);
		}
		
	}

	

}
