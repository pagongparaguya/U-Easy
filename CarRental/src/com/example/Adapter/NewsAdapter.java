package com.example.Adapter;

import java.util.ArrayList;

import com.example.carrental.NewsItem;
import com.example.carrental.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter{
	private static ArrayList<NewsItem> newsList;
	private LayoutInflater inflater;
	
	public NewsAdapter(Context context, ArrayList<NewsItem> news){
		newsList = news;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.news_events_row, null);
			holder = new ViewHolder();
			holder.date = (TextView) convertView.findViewById(R.id.eventDate);
			holder.event = (TextView) convertView.findViewById(R.id.eventName);
			
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.date.setText(newsList.get(i).getDate());
		holder.event.setText(newsList.get(i).getEvent());
		
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return newsList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return newsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	static class ViewHolder{
		TextView date,event;
	}
}
