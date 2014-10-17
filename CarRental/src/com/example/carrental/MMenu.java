package com.example.carrental;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MMenu extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.main_menu);
		
		ActionBar ab = getActionBar();
		ab.show();
		ab.setIcon(R.drawable.turbo_logo);
		ab.setTitle("");
		
		Intent i = getIntent();
		Bundle b = i.getExtras();
		TextView welc = (TextView) findViewById(R.id.welcome);
		if(b!=null){
			String s = (String) b.get("username");
			welc.setText("Welcome "+s+"!");
		}
		
		View myproView = findViewById(R.id.menuprofileimg);
		ImageButton myproImg = (ImageButton) myproView.findViewById(R.id.myprofileimg);
		View aboutUsView = findViewById(R.id.menuaboutus);
		ImageButton aboutusImg = (ImageButton) aboutUsView.findViewById(R.id.aboutusimg);
		View carRentView = findViewById(R.id.menurentacar);
		ImageButton carRentImg = (ImageButton) carRentView.findViewById(R.id.rentacarimg);
		View newsView = findViewById(R.id.menunews);
		ImageButton newsImg = (ImageButton) newsView.findViewById(R.id.newseventsimg);
		
		newsImg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent news = new Intent(getApplicationContext(),NewsPage.class);
				
				startActivity(news);
			}
		});
		myproImg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myprof = new Intent(getApplicationContext(),ProfileTab.class);
				
				startActivity(myprof);
			}
		});
		
		aboutusImg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent aboutus = new Intent(getApplicationContext(),AboutTab.class);
				
				startActivity(aboutus);
			}
		});
		
		carRentImg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent carrent = new Intent(getApplicationContext(),CarRental.class);
				
				startActivity(carrent);
			}
		});
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout, menu);
 
        return super.onCreateOptionsMenu(menu);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_profile:
			Intent prof = new Intent(getApplicationContext(),ProfileTab.class);
			startActivity(prof);
			return true;
		case R.id.action_car:
			Intent car = new Intent(getApplicationContext(),CarRental.class);
			startActivity(car);
			return true;
		case R.id.action_news:
			Intent news = new Intent(getApplicationContext(),CarRental.class);
			startActivity(news);
			return true;
		case R.id.action_about_us:
			Intent au = new Intent(getApplicationContext(),AboutTab.class);
			startActivity(au);
			return true;
		case R.id.action_logout:
			Intent logout = new Intent(getApplicationContext(), MainActivity.class);
			logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(logout);
			finish();
			return true;
		}
		return false;
	}
}
