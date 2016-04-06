package com.chen.example.criminalintent;

import java.util.UUID;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

	@Override
	protected android.support.v4.app.Fragment createFragment() {
		UUID crimeID=(UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeID);
	}
}
