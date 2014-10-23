package com.example.Adapter;

import java.util.ArrayList;

import com.example.carrental.R;
import com.example.carrental.myRentalItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CancelledRentalAdapter extends BaseAdapter{
	private static ArrayList<myRentalItem> rentallist;
	private LayoutInflater inflater;
	
	public CancelledRentalAdapter(Context context, ArrayList<myRentalItem> rentals){
		rentallist = rentals;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int i, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView == null){
			convertView = inflater.inflate(R.layout.myrentals_cancelled, null);
			holder = new ViewHolder();
			holder.pud = (TextView) convertView.findViewById(R.id.pud);
			holder.service = (TextView) convertView.findViewById(R.id.service);
			holder.model = (TextView) convertView.findViewById(R.id.model);
			holder.price = (TextView) convertView.findViewById(R.id.price);
			holder.put = (TextView) convertView.findViewById(R.id.put);
			holder.ret = (TextView) convertView.findViewById(R.id.ret);
			
			convertView.setTag(holder);
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.pud.setText(rentallist.get(i).getPud());
		holder.service.setText(rentallist.get(i).getService());
		holder.model.setText(rentallist.get(i).getModel());
		holder.price.setText(rentallist.get(i).getPrice());
		holder.put.setText(rentallist.get(i).getPut());
		holder.ret.setText(rentallist.get(i).getRet());
		
		return convertView;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return rentallist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return rentallist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	static class ViewHolder{
		TextView pud,service,model,price,put,ret;
	}
}
