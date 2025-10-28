package com.admina;

import java.util.List;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VaccinAdaptateur extends ArrayAdapter<Vaccin> {

	private List<Vaccin> vaccin;

	public VaccinAdaptateur(Context context, int textViewResourceId,
			List<Vaccin> stgs) {
		super(context, textViewResourceId, stgs);
		this.vaccin = stgs;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowview = inflater.inflate(R.layout.item_vaccin, null);

		TextView textView1 = (TextView) rowview.findViewById(R.id.idnomV);
		TextView textView2 = (TextView) rowview.findViewById(R.id.iddateV);

		textView1.setText(vaccin.get(position).getNomvaccin());
		textView2.setText(vaccin.get(position).getDatevaccin());

		return rowview;
	}

}