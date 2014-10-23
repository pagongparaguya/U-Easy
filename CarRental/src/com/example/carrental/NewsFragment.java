package com.example.carrental;

import java.util.ArrayList;

import com.example.Adapter.NewsAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewsFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.news_page, container, false);
		
		ArrayList<NewsItem> newsList = getNewsList();
		ListView nl = (ListView) v.findViewById(R.id.newsList);
		nl.setAdapter(new NewsAdapter(getActivity(),newsList));
		
		nl.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				NewsDetail news = new NewsDetail();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.frame_container, news);
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		return v;
	}

	private ArrayList<NewsItem> getNewsList(){
	    ArrayList<NewsItem> newsList = new ArrayList<NewsItem>();

	    NewsItem news = new NewsItem();

	    news.setDate("10/14/14");
	    news.setEvent("CEBU DRIVERS PROTEST STIFF TRAFFIC FINES");
	    newsList.add(news);
	    
	    news.setDate("10/14/14");
	    news.setEvent("CEBU DRIVERS PROTEST STIFF TRAFFIC FINES");
	    newsList.add(news);
	    
	    news.setDate("10/14/14");
	    news.setEvent("CEBU DRIVERS PROTEST STIFF TRAFFIC FINES");
	    newsList.add(news);
	    
	    return newsList; 
	}
	
}