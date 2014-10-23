package com.example.carrental;

import java.util.ArrayList;

import com.example.Adapter.CancelledRentalAdapter;
import com.example.Adapter.FinishedRentalAdapter;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HistoryFragment extends Fragment{
	
	public HistoryFragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.my_history, container, false);
		
		ArrayList<myRentalItem> listFinished = getFinishedList();
		ArrayList<myRentalItem> listCancelled = getCancelledList();
		
		ListView fl = (ListView) rootView.findViewById(R.id.listFinished);
		fl.setAdapter(new FinishedRentalAdapter(getActivity(), listFinished));
				
		ListView cl = (ListView) rootView.findViewById(R.id.listCancelled);
		cl.setAdapter(new CancelledRentalAdapter(getActivity(), listCancelled));
		
		return rootView;
	}
	
	private ArrayList<myRentalItem> getFinishedList(){
	    ArrayList<myRentalItem> rentallist = new ArrayList<myRentalItem>();

	    myRentalItem rental = new myRentalItem();

	    rental.setPud("October 1, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    rental.setPud("October 2, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    rental.setPud("October 3, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    return rentallist; 
	}
	
	private ArrayList<myRentalItem> getCancelledList(){
	    ArrayList<myRentalItem> rentallist = new ArrayList<myRentalItem>();

	    myRentalItem rental = new myRentalItem();

	    rental.setPud("October 1, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    rental.setPud("October 2, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    rental.setPud("October 3, 2014");
	    rental.setService("Chauffer");
	    rental.setModel("Mazda 3");
	    rental.setPrice("P 1,500");
	    rental.setPut("9:00 am");
	    rental.setRet("October 7, 2014 || 9:00 am");
	    rentallist.add(rental);

	    return rentallist; 
	}
}
