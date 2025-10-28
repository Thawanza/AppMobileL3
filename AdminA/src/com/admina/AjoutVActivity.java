package com.admina;



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
import android.widget.Toast;

public class AjoutVActivity extends Activity implements OnClickListener {
	
	
	CustomProgressDialog progressDialog;
	String urlAdd = "http://10.0.2.2/PhpAnalyseMe/AjouterVaccin.php";
	AddDataAsyncTask AddData;
	String message;
	int success;
	
	EditText nomv , datev ;
	Button btn ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajout_v);
		
		progressDialog = new CustomProgressDialog(this,
				R.drawable.loading_throbber);
		progressDialog.setCancelable(true);
		
		// recuperer les champs :
		nomv = (EditText) findViewById(R.id.etnomvaccin);
		datev = (EditText) findViewById(R.id.etdatevaccin);
		
		btn = (Button) findViewById(R.id.bajouterv);
		btn.setOnClickListener(this);
	}
	
	// le traitement de button :
	@Override
	public void onClick(View v) {
		if(v == btn){
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

			nameValuePair.add(new BasicNameValuePair("etnomv", nomv.getText().toString()));
			nameValuePair.add(new BasicNameValuePair("etdatev", datev.getText().toString()));
			
			Log.i("Data", nameValuePair.toString());

			// Making a request to url and getting response
			String jsonStr = sh.makeServiceCall(urlAdd, ServiceHandler.POST,
					nameValuePair);

//			Log.i("Response: ", jsonStr);
//
//			if (jsonStr != null) {
//				try {
//
//					JSONObject jsonObj = new JSONObject(jsonStr);
//					success = jsonObj.getInt("success"); // message =
//					jsonObj.getString("message");
//					Log.i("suucess", String.valueOf(success)); // Log.i("message",
//																// message);
//
//				} catch (JSONException e) {
//
//					e.printStackTrace();
//				}
//			}
			

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
