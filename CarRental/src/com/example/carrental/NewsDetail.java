package com.example.carrental;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class NewsDetail extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_event_detail);
		
		ActionBar ab = getActionBar();
		ab.show();
		ab.setIcon(R.color.black);
		ab.setTitle("News & Events");
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
 
        return super.onCreateOptionsMenu(menu);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_profile:
			Intent prof = new Intent(getApplicationContext(),ProfileTab.class);
			startActivity(prof);
			finish();
			return true;
		case R.id.action_car:
			Intent car = new Intent(getApplicationContext(),CarRental.class);
			startActivity(car);
			finish();
			return true;
		case R.id.action_news:
			Intent news = new Intent(getApplicationContext(),NewsPage.class);
			startActivity(news);
			finish();
			return true;
		case R.id.action_about_us:
			Intent au = new Intent(getApplicationContext(),AboutTab.class);
			startActivity(au);
			finish();
			return true;
		case R.id.action_logout:
			Intent logout = new Intent(getApplicationContext(),MainActivity.class);
			startActivity(logout);
			finish();
			return true;
		}
		return false;
	}
}
