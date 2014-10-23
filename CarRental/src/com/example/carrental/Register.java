package com.example.carrental;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class Register extends Activity{

	private static final int PICK_IMAGE = 1;
	private Uri selected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.register);
		
		ActionBar ab = getActionBar();
		ab.setTitle("Sign Up");
		ab.show();
		ab.setIcon(R.color.black);
		Button up = (Button) findViewById(R.id.uploadPhoto);
		Button login = (Button) findViewById(R.id.rtologin);
		Button subm = (Button) findViewById(R.id.submit);
		
		up.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
			}
		});
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		subm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		        Intent logout = new Intent(getApplicationContext(),NavMainMenu.class);
				logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(logout);
				finish();
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch(requestCode){
		case PICK_IMAGE:
			if(resultCode == RESULT_OK){
				selected = data.getData();
				ImageView img = (ImageView) findViewById(R.id.profpic);
				
				img.setImageURI(selected);
			}
		}
	}
}
