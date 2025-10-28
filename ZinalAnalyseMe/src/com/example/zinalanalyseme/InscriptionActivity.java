package com.example.zinalanalyseme;

import java.util.ArrayList;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InscriptionActivity extends Activity implements OnClickListener {

	CustomProgressDialog progressDialog;
	String urlAdd = "http://10.0.2.2/PhpAnalyseMe/inscription.php";
	AddDataAsyncTask AddData;
	String message;
	int success;
//	String sexe=null;

	EditText num, user, age, psw, cpsw;
	Spinner genre;
	Button valider;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inscription);

		progressDialog = new CustomProgressDialog(this,
				R.drawable.loading_throbber);
		progressDialog.setCancelable(true);

		// recuperer les element :
		num = (EditText) findViewById(R.id.etnumero);
		user = (EditText) findViewById(R.id.etuser);
		age = (EditText) findViewById(R.id.etage);
		psw = (EditText) findViewById(R.id.etmdp);
		cpsw = (EditText) findViewById(R.id.etcmdp);
		genre = (Spinner) findViewById(R.id.spsexe);
		
		
		valider = (Button) findViewById(R.id.btninscription);
		valider.setOnClickListener(this);

		// recuperer la valeur de spinner :
//		 sexe = genre.getSelectedItem().toString();

	}

	@Override
	public void onClick(View v) {
		if (v == valider) {
			AddData = new AddDataAsyncTask();
			AddData.execute();
		}

	}

	private class AddDataAsyncTask extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			Log.i("add", "onPreExecute");
			super.onPreExecute();
			progressDialog.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			Log.i("add", " start doInBackground");
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();

			ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);

			nameValuePair.add(new BasicNameValuePair("etnum", num.getText()
					.toString()));
			nameValuePair.add(new BasicNameValuePair("etuser", user.getText()
					.toString()));
			nameValuePair.add(new BasicNameValuePair("etmdp", psw.getText()
					.toString()));
			nameValuePair.add(new BasicNameValuePair("etage", age.getText()
					.toString()));
			nameValuePair.add(new BasicNameValuePair("spsexe", genre.getSelectedItem().toString()));

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(urlAdd, ServiceHandler.POST,
					nameValuePair);

//			Log.i("Response: ", jsonStr);
			
//			  if (jsonStr != null) { try {
//			  
//			  JSONObject jsonObj = new JSONObject(jsonStr); success =
//			  jsonObj.getInt("success"); //message =
//			  jsonObj.getString("message"); Log.i("suucess",
//			  String.valueOf(success)); //Log.i("message", message);
//			  
//			  } catch (JSONException e) {
//			  
//			  e.printStackTrace(); } }
			 

			Log.i("add", " end doInBackground");
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			Log.i("add", "onPostExecute");
			super.onPostExecute(result);
			if (progressDialog.isShowing()) {
				progressDialog.dismiss();
			}
			Toast.makeText(getApplicationContext(), "Succés :",
					Toast.LENGTH_LONG).show();

		}
	}

}
