package com.example.carrental;

import com.example.Adapter.NewsAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class NewsPage extends Activity implements AdapterView.OnItemClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_page);
		
		ActionBar ab = getActionBar();
		ab.show();
		ab.setIcon(R.color.black);
		ab.setTitle("News & Events");
		
		final ListView lv = (ListView) findViewById(R.id.newsList);
		Toast.makeText(getApplicationContext(), String.valueOf(lv.hasOnClickListeners()), Toast.LENGTH_SHORT).show();
		
		final String[] date = new String[]{"10/11/12","10/11/12","10/11/12"};
		String[] event = new String[]{"Cebu Drivers protest against stiff traffic fines.","Cebu Drivers protest against stiff traffic fines.","Cebu Drivers protest against stiff traffic fines."};
		int[] img = {R.drawable.news1,R.drawable.news2,R.drawable.news3};
		
		NewsAdapter adap = new NewsAdapter(this,img,date,event);
		lv.setAdapter(adap);
		lv.setClickable(true);
		LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.news_events_row, null, false);
		ImageView iV = (ImageView) rowView.findViewById(R.id.newsImage);
		iV.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG).show();
			}
		});
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG).show();
				Intent i = new Intent(getApplicationContext(),NewsDetail.class);
				startActivity(i);
			}
			
			
		});
	}
	
	
	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {
		MenuItem item = menu.findItem(R.id.action_news);
	    item.setEnabled(false);
	    //item.setVisible(false);
	    item.setCheckable(true);
	    item.setChecked(true);
	    
	    item.getIcon().setAlpha(100);
	    return true;
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
			logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(logout);
			finish();
			return true;
		}
		return false;
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
	}

	
//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//		// TODO Auto-generated method stub
//		switch(position){
//		case 0:
//		Toast.makeText(getApplicationContext(), "Welcome!", Toast.LENGTH_LONG).show();
////		Intent i = new Intent(getApplicationContext(),NewsDetail.class);
//		Intent i = new Intent(this,NewsDetail.class);
//		
//		startActivity(i);
//		}
//		super.onListItemClick(l, v, position, id);
//	}
//	
	
}