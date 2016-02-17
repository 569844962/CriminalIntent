package com.chen.example.criminalintent;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public abstract class SingleFragmentActivity extends FragmentActivity {
	protected abstract Fragment createFragment();
	
	@Override
	protected void onCreate(Bundle saveIntentState) {
		super.onCreate(saveIntentState);
		setContentView(R.layout.activity_fragment);
		android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
		Fragment fragment=fm.findFragmentById(R.id.fragmentContainer);
		if(fragment==null){
			fragment=createFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
}
