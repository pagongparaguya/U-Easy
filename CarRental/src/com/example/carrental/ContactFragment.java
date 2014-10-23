package com.example.carrental;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.about_us, container, false);
		
		final TextView tLoc = (TextView) rootView.findViewById(R.id.location);
		final TextView tNum = (TextView) rootView.findViewById(R.id.tNum);
		final TextView tEmail = (TextView) rootView.findViewById(R.id.tEmail);
		
		tNum.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = tNum.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL);
			    intent.setData(Uri.parse("tel:" +number));
			    startActivity(intent);
			}
		});
		tEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String[] mailList = {tEmail.getText().toString()};
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mailList);
				emailIntent.setType("plain/text");
				
				
				startActivity(emailIntent);
			}
		});
		tLoc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<10.354106>,<123.914477>?q=<10.354106>,<123.914477>(Turbo Car Rental Services)"));
				startActivity(intent);
			}
		});
		
		return rootView;
	}
}