package com.example.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carrental.R;

public class NewsAdapter extends ArrayAdapter<String> {
	private final int[] img;
	private final String[] date;
	private final String[] name;
	private final Context context;

	public NewsAdapter(Context context, int[] img, String[] date, String[] name){
		super(context,R.layout.news_events_row,date);
		this.img = img;
		this.date = date;
		this.name = name;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.news_events_row, parent, false);
		ImageView img1 = (ImageView) rowView.findViewById(R.id.newsImage);
		TextView date1 = (TextView) rowView.findViewById(R.id.eventDate);
		TextView name1 = (TextView) rowView.findViewById(R.id.eventName);
		img1.setImageResource(img[position]);
		date1.setText(date[position]);
		name1.setText(name[position]);
		 
		return rowView;
	}
}
