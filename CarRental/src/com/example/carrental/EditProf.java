package com.example.carrental;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class EditProf extends Fragment{

	private static final int PICK_IMAGE = 1;
	private Uri selected;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.edit_profile, container, false);
		
		Button save = (Button) v.findViewById(R.id.savechanges);
		Button discard = (Button) v.findViewById(R.id.discardchanges);
		Button ups = (Button) v.findViewById(R.id.uploadPhoto);
		
		ups.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
			}
		});
		save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Changes saved.", Toast.LENGTH_SHORT).show();
				getFragmentManager().popBackStack();
			}
		});
		discard.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getFragmentManager().popBackStack();
			}
		});
		return v;
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch(requestCode){
		case PICK_IMAGE:
			if(resultCode == Activity.RESULT_OK){
				selected = data.getData();
				ImageView img = (ImageView) getView().findViewById(R.id.profpic);
				img.setImageURI(selected);
			}
		}
	}
}
