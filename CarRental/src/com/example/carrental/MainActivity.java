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
        login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText user = (EditText) findViewById(R.id.username);
		        Intent login = new Intent(getApplicationContext(),NavMainMenu.class);
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
    }
}
