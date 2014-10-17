package com.example.carrental;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.login);
        
        ActionBar test = getActionBar();
        test.hide();
        
        Button login = (Button) findViewById(R.id.login);
        TextView reg = (TextView) findViewById(R.id.signup);
        TextView fgpw = (TextView) findViewById(R.id.fgetpword);
        RelativeLayout fb = (RelativeLayout) findViewById(R.id.fbmenu);
        login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText user = (EditText) findViewById(R.id.username);
		        Intent login = new Intent(getApplicationContext(),MMenu.class);
				login.putExtra("username", user.getText().toString());
				startActivity(login);
			}
		});
        
        reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent reg = new Intent(getApplicationContext(),Register.class);
				
				startActivity(reg);
			}
		});
        
        fgpw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent fpw = new Intent(getApplicationContext(),ForgotPass.class);
				
				startActivity(fpw);
			}
		});
        
        fb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "I am clicked.", Toast.LENGTH_SHORT).show();
			}
		});
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.aboutus) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
