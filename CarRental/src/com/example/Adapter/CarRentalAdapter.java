package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carrental.R;

public class CarRentalAdapter extends ArrayAdapter<String> {
	private final int[] img;
	private final String[] mod;
	private final String[] cap;
	private final Context context;

	public CarRentalAdapter(Context context, int[] img, String[] mod, String[] cap){
		super(context,R.layout.car_rent_layout,mod);
		this.img = img;
		this.mod = mod;
		this.cap = cap;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.car_rent_layout, parent, false);
		ImageView img1 = (ImageView) rowView.findViewById(R.id.carImg);
		TextView mod1 = (TextView) rowView.findViewById(R.id.carModel);
		TextView cap1 = (TextView) rowView.findViewById(R.id.carCap);
		img1.setImageResource(img[position]);
		mod1.setText(mod[position]);
		cap1.setText(cap[position]);
		 
		return rowView;
	}
}
