package com.dongshi.healthassisant.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterFragDoctorExp;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * @author YUN
 */
public class FragmentDoctor04 extends Fragment {
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_doctor04, null);
		mListView = (ListView) v.findViewById(R.id.listview_doctor_fragment04);

		mList = getData();
		mListView.setAdapter(new AdapterFragDoctorExp(getActivity(), mList));
		return v;
	}

	private ArrayList<HashMap<String, Object>> getData() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 3; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("tExp_01", "结膜炎" + i);
			m.put("tExp_content_02", "结膜炎" + i);
			m.put("tExp_time_02", "2014-09-24 就诊后" + (1 + i * 3) + "天");
			m.put("tExp_name_02", "王**" + i);
			list.add(m);
		}
		return list;
	}
}
