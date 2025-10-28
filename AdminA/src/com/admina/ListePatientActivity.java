package com.admina;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.admina.ListeRDVActivity.MyClass;
import com.google.gson.Gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class ListePatientActivity extends Activity {
	
	PatientAdaptateur patadapt;
	List<Patient> stgs= new ArrayList<Patient>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_patient);
		
		patadapt= new PatientAdaptateur(this, R.layout.item_patient, stgs);
		ListView listView=(ListView) findViewById(R.id.listepatient);
		listView.setAdapter(patadapt);
		new MyClass().execute("http://10.0.2.2/PhpAnalyseMe/AfficherPatient.php");
		
	}

	public StringBuffer getHttpResponse(String url) {
		StringBuffer stringBuffer = new StringBuffer();

		
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = client.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = response.getEntity();
				InputStream is = httpEntity.getContent();
				BufferedReader br = new BufferedReader(
						new InputStreamReader(is));
				String str;
				while ((str = br.readLine()) != null) {
					stringBuffer.append(str);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuffer;

	}
	class MyClass extends AsyncTask<String, Integer, StringBuffer>{

		@Override
		protected StringBuffer doInBackground(String... arg0) {
			String url=arg0[0];
			StringBuffer stringBuffer=getHttpResponse(url);
			
			return stringBuffer;
		}
		@Override
		protected void onPostExecute(StringBuffer result) {
			Log.e("",result.toString());
			Gson gson= new Gson();
			Patient[]patient =gson.fromJson(result.toString(), Patient[].class);
			for (Patient s : patient) {
				Log.e("", s.getUser());
				Log.e("",s.getNumerodetelephone());
				Log.e("",s.getAge());
				Log.e("",s.getSexe());
				stgs.add(s);
				
			}
				patadapt.notifyDataSetChanged();
				
			
			super.onPostExecute(result);
		}
	}

}
