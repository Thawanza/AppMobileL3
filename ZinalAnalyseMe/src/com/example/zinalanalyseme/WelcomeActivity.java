package com.example.zinalanalyseme;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomeActivity extends Activity implements OnClickListener {
	
	Button btns ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		btns = (Button) findViewById(R.id.suivant11);
		btns.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == btns){
			Intent i = new Intent(WelcomeActivity.this,WelcomActivity.class);
			startActivity(i);
		}
		
	}

	

}
