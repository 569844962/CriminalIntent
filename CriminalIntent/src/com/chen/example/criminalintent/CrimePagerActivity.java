package com.chen.example.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import com.chen.example.criminalintent.modle.Crime;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class CrimePagerActivity extends FragmentActivity {
	private ViewPager mViewPager;
	private ArrayList<Crime> mCrimes;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle saveInstanceState) {
		super.onCreate(saveInstanceState);
		mViewPager=new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		
		mCrimes=CrimeLab.get(this).getCrimes();
		
		android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			
			@Override
			public int getCount() {
				return mCrimes.size();
			}
			
			@Override
			public Fragment getItem(int post) {
				Crime crime=mCrimes.get(post);
				return CrimeFragment.newInstance(crime.getId());
			}
		});
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int post) {
				Crime crime=mCrimes.get(post);
				if(crime.getTitle()!=null){
					setTitle(crime.getTitle());
				}
			}
			
			@Override
			public void onPageScrolled(int post, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {}
		});
		
		UUID crimeID=(UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		for(int i=0;i<mCrimes.size();i++){
			if(mCrimes.get(i).getId().equals(crimeID)){
				mViewPager.setCurrentItem(i);
				break;
			}
		}
	}

}
