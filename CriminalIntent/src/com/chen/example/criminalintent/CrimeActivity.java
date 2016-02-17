package com.chen.example.criminalintent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected android.support.v4.app.Fragment createFragment() {
		// TODO 自动生成的方法存根
		return new CrimeFragment();
	}
}
