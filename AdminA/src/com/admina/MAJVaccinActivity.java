package com.admina;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MAJVaccinActivity extends Activity  {
	
	CustomProgressDialog progressDialog;

	String urlSupp="http://10.0.2.2/PhpAnalyseMe/SupprimerVaccin.php";
	String urlUpd="http://10.0.2.2/PhpAnalyseMe/ModifierDateVaccin.php";

	String message;
	int success;
	String nom , date , valnom , valdate ;
	EditText newn, newd;
	Button btnmod, btnsupp , enregistrer;
	Intent i3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_majvaccin);
		progressDialog = new CustomProgressDialog(this, R.drawable.loading_throbber);
		progressDialog.setCancelable(true);

		// recuperer les champs :
		newn = (EditText) findViewById(R.id.etnewnomv);
		newd = (EditText) findViewById(R.id.etnewdatev);


		// recuperer le intent :
		i3 = getIntent();
		valnom = i3.getStringExtra("nom");
		valdate = i3.getStringExtra("date");
		
		 Log.i("verification", valnom+"*"+valdate);
		 
		 newn=(EditText)findViewById(R.id.etnewnomv);
		 newd=(EditText)findViewById(R.id.etnewdatev);
		 
		 
		 btnmod = (Button) findViewById(R.id.btnmodifier);
		 btnsupp = (Button) findViewById(R.id.btngestionresultat);
		 enregistrer = (Button) findViewById(R.id.save);
		
		 
		// btnmod.setEnabled(false);
	
	//   faire lacces au modification des edit text :
	//	 newn.setEnabled(false);
	//	 newd.setEnabled(false);	
		 
		 newn.setText(valnom);
		 newd.setText(valdate);
		 
		 
		 // traitemetn des button :
		 btnmod.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					enregistrer.setEnabled(true);
					btnsupp.setEnabled(false);
					newn.setEnabled(true);
					newd.setEnabled(true);
					 
					
				}
			});
			 enregistrer.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					new UpdateDataAsyncTask().execute();
				}
			});
			 btnsupp.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					new SuppDataAsyncTask().execute();
				}
			});
		 
		 
		
		
	}
	
	private class UpdateDataAsyncTask extends  AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			Log.i("apdate", "onPreExecute");
			super.onPreExecute();
			progressDialog.show();
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			Log.i("update", " start doInBackground");
			// Creating service handler class instance
			ServiceHandler sh = new ServiceHandler();
			
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
			nameValuePair.add(new BasicNameValuePair("nom",newn.getText().toString()));
			nameValuePair.add(new BasicNameValuePair("date",newd.getText().toString()));
			
		
			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(urlUpd, ServiceHandler.POST,nameValuePair);
			
			Log.d("Response: ",jsonStr);
			if (jsonStr != null) {
				try {
					
					JSONObject jsonObj = new JSONObject(jsonStr);
					success = jsonObj.getInt("success");
					message = jsonObj.getString("message");
					Log.i("suucess", String.valueOf(success));
					Log.i("message", message);
					
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
			}

			Log.i("update", " end doInBackground");
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			Log.i("update", "onPostExecute");
			super.onPostExecute(result);
			if (progressDialog.isShowing())
			{
				progressDialog.dismiss();
			}
			if(success==1)
			{
				Toast.makeText(getApplicationContext(), "Mise à jour avec succée  "+message, Toast.LENGTH_LONG).show();
			}
			else 
			{
				Toast.makeText(getApplicationContext(), "Erreur" +message, Toast.LENGTH_LONG).show();
			}
			Intent intent = new Intent(MAJVaccinActivity.this, PVActivity.class);
			startActivityForResult(intent, 100);
			finish();
      
		}
		
	}
	private class SuppDataAsyncTask extends  AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			Log.i("supp", "onPreExecute");
			super.onPreExecute();
			progressDialog.show();
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			Log.i("supp", " start doInBackground");
			ServiceHandler sh = new ServiceHandler();
			List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
			nameValuePair.add(new BasicNameValuePair("nom",newn.getText().toString()));
			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(urlSupp, ServiceHandler.POST,nameValuePair);		
			
		Log.d("Response: ",jsonStr);
		if (jsonStr != null) {
		try {
					
			JSONObject jsonObj = new JSONObject(jsonStr);
			// return value of success
			success=jsonObj.getInt("success");
			message = jsonObj.getString("message");
			Log.i("suucess", String.valueOf(success));
			Log.i("message", message);
				      
		} catch (JSONException e) {
			e.printStackTrace();
		}
		} else {
			Log.e("ServiceHandler", "Couldn't get any data from the url");
		}

		Log.i("supp", " end doInBackground");
		return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			Log.i("supp", "onPostExecute");
			super.onPostExecute(result);
			if (progressDialog.isShowing())
			{
				progressDialog.dismiss();
			}
			if(success==1)
			{
				Toast.makeText(getApplicationContext(), "Supprimé ", Toast.LENGTH_LONG).show();
			}
			else 
			{
				Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_LONG).show();
			}
			Intent intent = new Intent(MAJVaccinActivity.this, PVActivity.class);
			startActivityForResult(intent, 100);
			finish();
		}
	}

	

}
