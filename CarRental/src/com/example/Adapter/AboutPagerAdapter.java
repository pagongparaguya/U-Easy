package com.example.Adapter;

import com.example.carrental.AboutUs;
import com.example.carrental.CompProf;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AboutPagerAdapter extends FragmentPagerAdapter {

	public AboutPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new CompProf();
		case 1:
			// Games fragment activity
			return new AboutUs();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}