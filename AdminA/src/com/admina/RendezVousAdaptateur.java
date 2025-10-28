package com.admina;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RendezVousAdaptateur extends ArrayAdapter<RendezVous> {
	
	private List<RendezVous> rendezvous;

	public RendezVousAdaptateur(Context context, int textViewResourceId,
			List<RendezVous> stgs) {
		super(context, textViewResourceId, stgs);
		this.rendezvous = stgs;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowview = inflater.inflate(R.layout.item_rdv, null);

		TextView textView1 = (TextView) rowview.findViewById(R.id.tvnompat);
		TextView textView2 = (TextView) rowview.findViewById(R.id.tvdaterdv);
		TextView textView3 = (TextView) rowview.findViewById(R.id.tvtypepre);

		textView1.setText(rendezvous.get(position).getNomuser());
		textView2.setText(rendezvous.get(position).getDaterdv());
		textView3.setText(rendezvous.get(position).getTypeprelevement());

		return rowview;
	}
	
	

}