package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Locale;
import java.util.UUID;

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private static final String ARG_CRIME_ID = "crime_id";

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public CrimeFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime,
                container, false);

        mTitleField = v.findViewById(R.id.edit_text_title);
        mTitleField.setText(mCrime.getmTitle());
        Button mDateButton = v.findViewById(R.id.edit_text_date);
        CheckBox mCheckBox = v.findViewById(R.id.checkbox_solved);
        mCheckBox.setChecked(mCrime.ismSolved());

        mDateButton.setText(String.format(Locale.ENGLISH,
                "%1$tY %1$tb %1$td",
                mCrime.getmDate()));
        mDateButton.setEnabled(false);

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getActivity(),
                            mTitleField.getText() + " - Solved!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(),
                            mTitleField.getText() + " - Ongoing",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}
