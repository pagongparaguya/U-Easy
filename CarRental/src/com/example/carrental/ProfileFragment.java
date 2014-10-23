package com.example.carrental;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ProfileFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.my_profile, container, false);
		
		final TextView num = (TextView) rootView.findViewById(R.id.sampleNumber);
		final TextView email = (TextView) rootView.findViewById(R.id.sampleEmail);
		Button edit = (Button) rootView.findViewById(R.id.editprof);
		edit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditProf edit = new EditProf();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.frame_container, edit);
				ft.addToBackStack(null);
				ft.commit();
			}
		});
		num.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = num.getText().toString();
				Intent intent = new Intent(Intent.ACTION_CALL);
			    intent.setData(Uri.parse("tel:" +number));
			    startActivity(intent);
			}
		});
		email.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String[] mailList = {email.getText().toString()};
				Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mailList);
				emailIntent.setType("plain/text");
				
				
				startActivity(emailIntent);
			}
		});
		return rootView;
	}
}