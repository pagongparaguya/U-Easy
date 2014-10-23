package com.example.carrental;

import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class RentForm extends Activity implements OnItemSelectedListener{

	private DatePicker datePicker;
	private Calendar calendar;
	private Button dateView, endView, startTime, endTime;
	private int year, month, day, year1, month1, day1, hr, min, hr1, min1;
	static final int TIME_ID = 0;
	static final int TIME_ID1 = 1;
	
	private TimePickerDialog.OnTimeSetListener mTimeSetListener =
	        new TimePickerDialog.OnTimeSetListener() {
	            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	                hr = hourOfDay;
	                min = minute;
	                update();
	       }
	};
	private TimePickerDialog.OnTimeSetListener mTimeSetListener1 =
	        new TimePickerDialog.OnTimeSetListener() {
	            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
	                hr1 = hourOfDay;
	                min1 = minute;
	                update1();
	       }
	};
	private void update() {
        startTime.setText(
            new StringBuilder()
                    .append(pad(hr)).append(":")
                    .append(pad(min)));
    }
	private void update1() {
        startTime.setText(
            new StringBuilder()
                    .append(pad(hr)).append(":")
                    .append(pad(min)));
    }
	private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rentform);
		ActionBar ab = getActionBar();
		ab.setTitle("");
		
		startTime = (Button) findViewById(R.id.put);
		endTime = (Button) findViewById(R.id.rTime);
		dateView = (Button) findViewById(R.id.pud);
		endView = (Button) findViewById(R.id.rDate);
		Spinner serv = (Spinner) findViewById(R.id.service);
		Spinner loc = (Spinner) findViewById(R.id.location);
		Button sub = (Button) findViewById(R.id.rentSubmit);
		Button cancel = (Button) findViewById(R.id.rentCancel);
		
		calendar = Calendar.getInstance();
	    year = calendar.get(Calendar.YEAR);
	    month = calendar.get(Calendar.MONTH);
	    day = calendar.get(Calendar.DAY_OF_MONTH);
	    showDate(year, month+1, day);
	    showDate1(year, month+1, day);
	    
		serv.setOnItemSelectedListener(this);
		loc.setOnItemSelectedListener(this);
		
		sub.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Reservation Successful!", Toast.LENGTH_SHORT).show();
				Intent i = new Intent(getApplicationContext(),NavMainMenu.class);
				startActivity(i);
				finish();
			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),NavMainMenu.class);
				startActivity(i);
				finish();
			}
		});
		startTime.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_ID);
			}
		});
		endTime.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(TIME_ID1);
			}
		});
		setTime();
		setTime1();
	}
	public void setTime(){
		final Calendar cal = Calendar.getInstance();
        hr = cal.get(Calendar.HOUR_OF_DAY);
        min = cal.get(Calendar.MINUTE);
        
        update();
	}
	public void setTime1(){
		final Calendar cal = Calendar.getInstance();
        hr1 = cal.get(Calendar.HOUR_OF_DAY);
        min1 = cal.get(Calendar.MINUTE);
        
        update1();
	}
	
	@SuppressWarnings("deprecation")
	   public void setDate(View view) {
	      showDialog(999);
	}
	
	@SuppressWarnings("deprecation")
	public void setDate1(View view){
		showDialog(998);
	}
	@Override
	   protected Dialog onCreateDialog(int id) {
	   // TODO Auto-generated method stub
		switch (id){
		case 999:
		return new DatePickerDialog(this, myDateListener, year, month, day);
	       
		case 998:
	    	  return new DatePickerDialog(this, myDateListener2, year1, month1, day1);
		case TIME_ID:
			return new TimePickerDialog(this, mTimeSetListener, hr, min, false);
	   case TIME_ID1:
			return new TimePickerDialog(this, mTimeSetListener1, hr1, min1, false);
		}
	      return null;
	   }

	   private DatePickerDialog.OnDateSetListener myDateListener
	   = new DatePickerDialog.OnDateSetListener() {

	   @Override
	   public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
	      // TODO Auto-generated method stub
	      // arg1 = year
	      // arg2 = month
	      // arg3 = day
	      showDate(arg1, arg2+1, arg3);
	   }
	   };
	   
	   private DatePickerDialog.OnDateSetListener myDateListener2 = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int month,
				int day) {
			// TODO Auto-generated method stub
			showDate1(year,month,day);
		}
	};
	   private void showDate(int year, int month, int day) {
	       dateView.setText(new StringBuilder().append(day).append("/")
	       .append(month).append("/").append(year));
	   }
	   private void showDate1(int year, int month, int day) {
		   endView.setText(new StringBuilder().append(day).append("/")
		   .append(month).append("/").append(year));
	   }

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}
