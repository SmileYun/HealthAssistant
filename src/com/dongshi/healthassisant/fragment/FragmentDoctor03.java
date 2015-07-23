package com.dongshi.healthassisant.fragment;

import com.dongshi.healthassisant.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * @author 	YUN
 */
public class FragmentDoctor03 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return getActivity().getLayoutInflater().inflate(R.layout.fragment_doctor03, null);
	}
}
