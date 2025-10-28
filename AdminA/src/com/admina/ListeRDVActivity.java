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

import com.admina.PVActivity.MyClass;
import com.google.gson.Gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class ListeRDVActivity extends Activity {
//	private String nom[] = { "XXXX YYYY", "Boumoula Yasmine" };
//	private String date[] = { "08/08/2023", "02/12/2023" };
//	private String num[] = { "0552236776", "0552236225" };
//	private String type[] = { "A domicile", " A laboratoire" };
	
	RendezVousAdaptateur rdvadapt;
	List<RendezVous> stgs= new ArrayList<RendezVous>();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_liste_rdv);
		
		rdvadapt= new RendezVousAdaptateur(this, R.layout.item_rdv, stgs);
		ListView listView=(ListView) findViewById(R.id.listeRDV);
		listView.setAdapter(rdvadapt);
		new MyClass().execute("http://10.0.2.2/PhpAnalyseMe/AfficherRendezVous.php");

		
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
			RendezVous[]rendezvous =gson.fromJson(result.toString(), RendezVous[].class);
			for (RendezVous s : rendezvous) {
				Log.e("", s.getNomuser());
				Log.e("",s.getDaterdv());
				Log.e("",s.getTypeprelevement());
				
				stgs.add(s);
			}
				rdvadapt.notifyDataSetChanged();
				
			
			super.onPostExecute(result);
		}
	}

}
