package com.example.carrental;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class carMenu extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final String model = getArguments().getString("carName");
		View v = inflater.inflate(R.layout.car_menu, container, false);
		Button cInfo = (Button) v.findViewById(R.id.carInfo);
		Button dInfo = (Button) v.findViewById(R.id.driInfo);
		Button rent = (Button) v.findViewById(R.id.rent);
		TextView name = (TextView) v.findViewById(R.id.name);
		name.setText(model);
		
		cInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
				intent.putExtra(SearchManager.QUERY, model);
				startActivity(intent);
			}
		});
		
		dInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DriverInfo d = new DriverInfo();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.frame_container, d);
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		
		rent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getActivity(),RentForm.class);
				startActivity(i);
			}
		});
		
		return v;
	}
}
