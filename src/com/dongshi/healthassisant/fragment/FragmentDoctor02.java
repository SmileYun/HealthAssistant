package com.dongshi.healthassisant.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterFragDoctor02;
import com.dongshi.healthassisant.widget.RefreshListView;

/**
 * 预约挂号
 * 
 * @author YUN
 */
public class FragmentDoctor02 extends Fragment implements OnItemClickListener {
	private RefreshListView mListView;
	private ArrayList<HashMap<String, Object>> mList;
	View view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mList = new ArrayList<HashMap<String, Object>>();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = getActivity().getLayoutInflater().inflate(R.layout.fragment_doctor02, null);
		mListView = (RefreshListView) view.findViewById(R.id.listview_doctor_fragment02);

		mList = getData();
		if (mListView != null) {
			mListView.setAdapter(new AdapterFragDoctor02(getActivity(), mList));
			mListView.setOnItemClickListener(this);
		}
		return view;
	}

	private ArrayList<HashMap<String, Object>> getData() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 7; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("time", "2014-10-" + (10 + i * 2) + " 周五上午");
			m.put("price", "专家门诊" + (2.5 * i + 1) + "元");
			list.add(m);
		}
		return list;
	}

	private ArrayList<HashMap<String, Object>> getData(Object obj) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		return list;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}
}
