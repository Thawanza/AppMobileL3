package com.example.zinalanalyseme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AuthentificationActivity extends Activity implements
		OnClickListener {

	EditText num, mdp;
	Button btnc, btnsin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_authentification);

		num = (EditText) findViewById(R.id.etnumero);
		mdp = (EditText) findViewById(R.id.etuser);

		btnc = (Button) findViewById(R.id.btnconnecter);
		btnc.setOnClickListener(this);
		btnsin = (Button) findViewById(R.id.btninscrire);
		btnsin.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if (v == btnsin) {
			Intent i = new Intent(AuthentificationActivity.this,
					InscriptionActivity.class);
			startActivity(i);
		}

		// le bouton de l'authentification :
		if (v == btnc) {
			String username = num.getText().toString();
			String password = mdp.getText().toString();
			String type = "login";
			BackgroundWorker backgroundWorker = new BackgroundWorker(this);
			backgroundWorker.execute(type, username, password);
		}

	}

	public void lanceintent() {
		Intent i = new Intent(this, AceuilleActivity.class);
		startActivity(i);

	}

	Intent i;

	public class BackgroundWorker extends AsyncTask<String, Void, String> {
		Context context;
		AlertDialog alertDialog;

		public BackgroundWorker(Context ctx) {
			this.context = ctx;
		}

		@Override
		protected String doInBackground(String... params) {

			String type = params[0];
			String login_url = "http://10.0.2.2/PhpStagiaire/Login.php";

			if (type.equals("login")) {
				try {
					String username = params[1];
					String password = params[2];
					URL url = new URL(login_url);
					HttpURLConnection httpURLConnection = (HttpURLConnection) url
							.openConnection();
					httpURLConnection.setRequestMethod("POST");
					httpURLConnection.setDoInput(true);
					httpURLConnection.setDoOutput(true);
					OutputStream outputStream = httpURLConnection
							.getOutputStream();
					BufferedWriter bufferedWriter = new BufferedWriter(
							new OutputStreamWriter(outputStream, "UTF-8"));
					String post_data = URLEncoder.encode("username", "UTF-8")
							+ "=" + URLEncoder.encode(username, "UTF-8") + "&"
							+ URLEncoder.encode("password", "UTF-8") + "="
							+ URLEncoder.encode(password, "UTF-8");
					bufferedWriter.write(post_data);
					bufferedWriter.flush();
					bufferedWriter.close();
					outputStream.close();

					InputStream inputStream = httpURLConnection
							.getInputStream();
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(inputStream));

					String result = "";
					String line = "";
					while ((line = bufferedReader.readLine()) != null) {
						result += line;
					}
					bufferedReader.close();
					inputStream.close();
					httpURLConnection.disconnect();
					return result;
				} catch (MalformedURLException e) {
					// // TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		protected void onPreExecute() {

			alertDialog = new AlertDialog.Builder(context).create();
			alertDialog.setTitle("Login status");

		}

		@Override
		protected void onPostExecute(String result) {

			alertDialog.setMessage(result);
			if (result.equals("Login success")) {
				i = new Intent(AuthentificationActivity.this,
						AceuilleActivity.class);
				startActivity(i);
			}
			alertDialog.show();

		}

		@Override
		protected void onProgressUpdate(Void... values) {

			super.onProgressUpdate(values);
		}

	}



}
