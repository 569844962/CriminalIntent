package com.chen.example.criminalintent;

import java.util.UUID;

import com.chen.example.criminalintent.modle.Crime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
public class CrimeFragment extends Fragment {
	public static final String EXTRA_CRIME_ID="com.chen.example.criminalintent.crime_id";
	private final static String DIALOG_DATE="date";
	private Crime mCrime;
	private EditText mTitleFiled;
	private Button mDateButton;
	private CheckBox mSolvedCheckBox;
	
	public static CrimeFragment newInstance(UUID crimeID){
		Bundle args=new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeID);
		CrimeFragment fragment=new CrimeFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		UUID crimeID=(UUID) getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
		UUID crimeID=(UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
		mCrime=CrimeLab.get(getActivity()).getCrime(crimeID);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fragment_crime, container,false);
		mTitleFiled=(EditText) v.findViewById(R.id.crime_title);
		mTitleFiled.setText(mCrime.getTitle());
		mTitleFiled.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO 自动生成的方法存根
				
			}
		});
		mDateButton=(Button) v.findViewById(R.id.crime_date);
		mDateButton.setText(mCrime.getDate().toString());
		mDateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm=getActivity().getSupportFragmentManager();
				DatePickerFragment dialog=new DatePickerFragment();
				dialog.show(fm, DIALOG_DATE);
			}
		});
		mSolvedCheckBox=(CheckBox) v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO set the crime's solved property
				mCrime.setSolved(isChecked);
			}
		});
		return v;
	}
}
