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
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.google.gson.Gson;

public class PVActivity extends Activity implements OnClickListener,OnItemClickListener {
	Button btn;
	 
	ListView listView ;
	
	VaccinAdaptateur vacadapt;
	List<Vaccin> stgs= new ArrayList<Vaccin>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pv);
		
	
		 listView = (ListView) findViewById(R.id.listevaccin);
		 listView.setOnItemClickListener(this);
		
		
		
		

		btn = (Button) findViewById(R.id.bajouterv);
		btn.setOnClickListener(this);
		
	}
	
	// le traitement de la liste :---------------------------------
	@Override
	public void onItemClick(AdapterView<?> parent, View arg1, int position,
			long arg3) {
		Vaccin c1 = (Vaccin) parent.getItemAtPosition(position);

		Intent i2 = new Intent(this, MAJVaccinActivity.class);
		i2.putExtra("nom", c1.getNomvaccin());
		i2.putExtra("date", c1.getDatevaccin());
		i2.putExtra("id", c1.getIdvaccin());

		startActivity(i2);
	}
	
	
	// fin de traitement de la liste -----------------

	@Override
	public void onClick(View v) {
		if (v == btn) {
			Intent i = new Intent(this, AjoutVActivity.class);
			startActivity(i);
		}
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
			Vaccin[]vaccin =gson.fromJson(result.toString(), Vaccin[].class);
			for (Vaccin s : vaccin) {
				Log.e("", s.getNomvaccin());
				Log.e("",s.getDatevaccin());
				
				stgs.add(s);
			}
				vacadapt.notifyDataSetChanged();
				
			
			super.onPostExecute(result);
		}
	}
	
	// pour l'actualisation des donné :
	@Override
	protected void onResume() {

		super.onResume();
		vacadapt= new VaccinAdaptateur(this, R.layout.item_vaccin, stgs);
		listView.setAdapter(vacadapt);
		new MyClass().execute("http://10.0.2.2/PhpAnalyseMe/AfficherVaccin.php");
	}

}
