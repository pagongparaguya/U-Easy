package com.example.carrental;

import com.example.Adapter.ProfilePagerAdapter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;

public class ProfileTab extends FragmentActivity implements ActionBar.TabListener{

	private ActionBar actionBar;
	private ViewPager vp;
	private ProfilePagerAdapter tpa;
	private String[] tabs = { "My Profile", "My Rentals" };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_header);
		
		vp = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		actionBar.setIcon(R.drawable.turbo_logo);
		actionBar.setTitle("");
		tpa = new ProfilePagerAdapter(getSupportFragmentManager());
		
		vp.setAdapter(tpa);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		
		
		// Adding Tabs
				for (String tab_name : tabs) {
					actionBar.addTab(actionBar.newTab().setText(tab_name)
							.setTabListener(this));
				}

				/**
				 * on swiping the viewpager make respective tab selected
				 * */
				vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int position) {
						// on changing the page
						// make respected tab selected
						actionBar.setSelectedNavigationItem(position);
					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {
					}

					@Override
					public void onPageScrollStateChanged(int arg0) {
					}
				});
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		vp.setCurrentItem(tab.getPosition());
		
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {
		MenuItem item = menu.findItem(R.id.action_profile);
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
        inflater.inflate(R.menu.menu_profile, menu);
 
        return super.onCreateOptionsMenu(menu);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_edit_prof:
			Intent edit = new Intent(getApplicationContext(),EditProf.class);
			startActivity(edit);
			finish();
			return true;
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
}
