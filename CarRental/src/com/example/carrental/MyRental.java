package com.example.carrental;

import java.util.ArrayList;

import com.example.Adapter.MyRentalAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MyRental extends Fragment{
	
	public MyRental(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.my_rental, container, false);
		
		ArrayList<myRentalItem> listRental = getRentalList();
		ListView lv = (ListView) rootView.findViewById(R.id.listView1);
		lv.setAdapter(new MyRentalAdapter(getActivity(), listRental));
		return rootView;
	}
	
	private ArrayList<myRentalItem> getRentalList(){
	    ArrayList<myRentalItem> rentallist = new ArrayList<myRentalItem>();

	    myRentalItem rental = new myRentalItem();

	    rental.setPud("October 1, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    rental.setPud("October 1, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    rental.setPud("October 1, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    return rentallist; 
	}   
}
