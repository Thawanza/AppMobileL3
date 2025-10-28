package com.admina;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PatientAdaptateur extends ArrayAdapter<Patient> {
	
	private List<Patient> patient;

	public PatientAdaptateur(Context context, int textViewResourceId,
			List<Patient> stgs) {
		super(context, textViewResourceId, stgs);
		this.patient = stgs;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowview = inflater.inflate(R.layout.item_patient, null);

		TextView textView1 = (TextView) rowview.findViewById(R.id.etnompatient);
		TextView textView2 = (TextView) rowview.findViewById(R.id.etnumpatient);
		TextView textView3 = (TextView) rowview.findViewById(R.id.etagepatient);
		TextView textView4 = (TextView) rowview.findViewById(R.id.etsexepatient);
		

		textView1.setText(patient.get(position).getUser());
		textView2.setText(patient.get(position).getNumerodetelephone());
		textView3.setText(patient.get(position).getAge());
		textView4.setText(patient.get(position).getSexe());

		return rowview;
	}

}
