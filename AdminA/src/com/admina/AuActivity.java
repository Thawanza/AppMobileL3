package com.admina;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuActivity extends Activity implements OnClickListener {
	EditText username, password;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_au);

		username = (EditText) findViewById(R.id.etusernam);
		password = (EditText) findViewById(R.id.etpasswordd);

		btn = (Button) findViewById(R.id.btnss);
		btn.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		String nomu = username.getText().toString();
		String mdp = password.getText().toString();
		if (v == btn) {
			if (nomu.equals("xxxx") && mdp.equals("xxxx")) {
				Intent i = new Intent(this, AcceuilleActivity.class);
				startActivity(i);
			} else {
				Toast.makeText(this, "User name ou password incorrecte",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

}

