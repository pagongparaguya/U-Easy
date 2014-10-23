package com.example.carrental;

import com.example.Adapter.CarRentalAdapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class RentFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.car_rent, container, false);
		
		ListView lv = (ListView) v.findViewById(R.id.carList);
		final String[] model = new String[]{"Mazda 3","Nissan Urvan Escapade","Toyota Avanza"};
		String[] cap = new String[]{"4 seats","8 seats","6 seats"};
		int[] img = {R.drawable.mazda3,R.drawable.urvan,R.drawable.toyota_avanza};
		
		final CarRentalAdapter adap = new CarRentalAdapter(getActivity(),img,model,cap);
		lv.setAdapter(adap);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Bundle b = new Bundle();
				b.putString("carName", model[position].toString());
				carMenu menu = new carMenu();
				menu.setArguments(b);
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.frame_container, menu);
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		return v;
	}

}
