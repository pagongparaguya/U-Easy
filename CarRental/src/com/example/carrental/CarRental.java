package com.example.carrental;

import com.example.Adapter.CarRentalAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CarRental extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.car_rent);
		
		ActionBar ab = getActionBar();
		ab.show();
		ab.setIcon(R.color.black);
		ab.setTitle("Choose car");
		
		final ListView lv = (ListView) findViewById(R.id.carList);
		final String[] model = new String[]{"Mazda 3","Nissan Urvan Escapade","Toyota Avanza"};
		String[] cap = new String[]{"4 seats","8 seats","6 seats"};
		int[] img = {R.drawable.mazda3,R.drawable.urvan,R.drawable.toyota_avanza};
		
		final CarRentalAdapter adap = new CarRentalAdapter(this,img,model,cap);
		lv.setAdapter(adap);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), model[position].toString(), Toast.LENGTH_LONG).show();
				Intent i = new Intent(getApplicationContext(),RentForm.class);
				startActivity(i);
			}
		});
	}
	
	@Override
	public boolean onPrepareOptionsMenu (Menu menu) {
		MenuItem item = menu.findItem(R.id.action_car);
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
			startActivity(logout);
			logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			finish();
			return true;
		}
		return false;
	}

}
