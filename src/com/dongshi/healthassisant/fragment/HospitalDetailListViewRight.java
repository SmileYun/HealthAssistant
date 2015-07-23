package com.dongshi.healthassisant.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterText;
import com.dongshi.healthassisant.ui.hospitalregister.ActDoctorHome;
import com.dongshi.healthassisant.ui.hospitalregister.ActDoctorList;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoise;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * @author YUN
 */
@SuppressLint("ValidFragment")
public class HospitalDetailListViewRight extends Fragment {
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList;

	private AdapterText mAdapter;
	private String city;
	private String subcity;

	public HospitalDetailListViewRight(ArrayList<HashMap<String, Object>> mList) {
		super();
		this.mList = mList;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_hospital_detail_listviewright, null);

		mListView = (ListView) view
				.findViewById(R.id.listview_hospital_fragment_right);
		mListView.setOnScrollListener(scrollerLinstener);

		mAdapter = new AdapterText(getActivity(), mList);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(itemClickListener);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
	}
	
	OnItemClickListener itemClickListener = new OnItemClickListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// getActivity().startActivity(new Intent(getActivity(),
			// ActHospitalChoise.class));
			if ("guahao_item02".equals(getActivity().getIntent().getExtras()
					.get("ID"))) {
				Intent i = new Intent(getActivity(), ActHospitalChoise.class);
				Bundle b = new Bundle();
				b.putString("keshi", ((HashMap<String, Object>) parent
						.getAdapter().getItem(position)).get("text").toString());
				b.putString("ID", "guahao_item02");
				i.putExtras(b);
				getActivity().startActivity(i);
				getActivity().finish();
			} else {

				if ("ActDoctorList".equals(getActivity().getIntent()
						.getExtras().get("TO"))) {
				
					Intent i = new Intent(getActivity(), ActDoctorList.class);
					Bundle b = new Bundle();
					b.putString("keshi", ((HashMap<String, Object>) parent
							.getAdapter().getItem(position)).get("text")
							.toString());
					i.putExtras(b);
					getActivity().startActivity(i);
					getActivity().finish();
				} else {

					if ("HospitalWith".equals(getActivity().getIntent()
							.getExtras().get("TAG"))) {

						Intent i = new Intent(getActivity(),
								ActHospitalChoise.class);
						Bundle b = new Bundle();
						b.putString("city", city);
						b.putString("subcity",
								((HashMap<String, Object>) parent.getAdapter()
										.getItem(position)).get("text")
										.toString());
						b.putString("TAG", getActivity().getIntent()
								.getExtras().get("TAG").toString());
						i.putExtras(b);
						getActivity().startActivityForResult(i, 5);
						getActivity().finish();
						
					} else {

						Intent i = new Intent();
						Bundle b = new Bundle();
						b.putString("city", city);
						b.putString("subcity",
								((HashMap<String, Object>) parent.getAdapter()
										.getItem(position)).get("text")
										.toString());
						i.putExtras(b);
						getActivity().setResult(1, i);
						getActivity().finish();
					}

				}
			}
		}
	};

	OnScrollListener scrollerLinstener = new OnScrollListener() {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {

		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
		}
	};

	/**
	 * 通知更新接口
	 * 
	 * @param obj
	 */
	public void notifyData(Object obj) {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> m = (HashMap<String, Object>) obj;
		String res = (String) m.get("text");
		getData(res);
		city = res;
		mAdapter.notifyDataSetChanged();
	}

	public void setmList(ArrayList<HashMap<String, Object>> list) {
		this.mList = list;
	}

	String[] cq = { "南岸区", "渝北区", "江北区", "北培区" };
	String[] sc = { "不限", "成都", "广安" };
	String[] sh = { "黄埔区", "普陀区", "金山区", "常宁区", "虹口区", "浦东新区" };

	String[] nk = { "呼吸科", "抗生素", "心内科", "呼吸科" };
	String[] zyy = { "中医科", "中医外科" };
	String[] gk = { "骨科", "手外科" };
	String[] qt = { "运动医学", "心理咨询", "康复科" };

	private void getData(String str) {
		mList.removeAll(mList);
		if ("重庆".equals(str)) {
			for (String s : cq) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else if ("四川".equals(str)) {
			for (String s : sc) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else if ("上海".equals(str)) {
			for (String s : sh) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else if ("内科".equals(str)) {
			for (String s : nk) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else if ("中医院".equals(str)) {
			for (String s : zyy) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else if ("骨科".equals(str)) {
			for (String s : gk) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else if ("其他".equals(str)) {
			for (String s : qt) {
				HashMap<String, Object> hm = new HashMap<String, Object>();
				hm.put("text", s);
				mList.add(hm);
			}
		} else {
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("text", "不限");
			mList.add(hm);
		}
	}
}
