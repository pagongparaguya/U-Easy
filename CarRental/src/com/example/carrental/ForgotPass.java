package com.example.carrental;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class ForgotPass extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		setContentView(R.layout.forgot_password);
		
		ActionBar ab = getActionBar();
		ab.setTitle("Forgot Password");
		ab.setIcon(R.color.black);
		ab.show();
		
		Button login = (Button) findViewById(R.id.rtologin);
		Button submit = (Button) findViewById(R.id.submit);
		
		login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Your password has been sent to your email.", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

}
