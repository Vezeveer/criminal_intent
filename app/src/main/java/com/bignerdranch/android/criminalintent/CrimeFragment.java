package com.bignerdranch.android.criminalintent;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment; //try change to android.support.v4.app

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime,
                container, false);

        mTitleField = v.findViewById(R.id.edit_text_title);
        mDateButton = v.findViewById(R.id.edit_text_date);
        mDateButton.setText(mCrime.getmDate()+"");
        mDateButton.setEnabled(false);

        return v;
    }


}
