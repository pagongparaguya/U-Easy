package com.example.Adapter;

import com.example.carrental.MyProfile;
import com.example.carrental.MyRental;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProfilePagerAdapter extends FragmentPagerAdapter {

	public ProfilePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new MyProfile();
		case 1:
			// Games fragment activity
			return new MyRental();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 2;
	}

}