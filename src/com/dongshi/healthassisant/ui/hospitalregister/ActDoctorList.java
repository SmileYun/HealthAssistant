package com.dongshi.healthassisant.ui.hospitalregister;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterDocterLVItem;

/**
 * 
 * @author YUN
 */
public class ActDoctorList extends Activity implements OnItemClickListener, OnClickListener {
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList;
	private TextView titleName;
	private ImageView mBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_doctor_detail_listview);
		initView();
	}

	private void initView() {
		mListView = (ListView) findViewById(R.id.listview_doctor_listview);
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		
		titleName.setText("医生列表");
		mList = getData();

		mListView.setAdapter(new AdapterDocterLVItem(this, mList));
		mListView.setOnItemClickListener(this);
	}

	private ArrayList<HashMap<String, Object>> getData() {
		String keshi = getIntent().getExtras().getString("keshi");
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 4; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("name", "张" + (i + 1) + "号");
			m.put("content", "张" + (i + 1) + "号 医生的内容是...");
			m.put("level", "主任医生");
			m.put("goodar", i + "手术");
			m.put("count", 231 + i);
			list.add(m);
		}
		return list;
	}

	/**
	 * 数据接口
	 * 
	 * @param obj
	 * @return ArrayList
	 */
	@SuppressWarnings("unused")
	private ArrayList<HashMap<String, Object>> getData(Object obj) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		return list;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent i = new Intent(this, ActDoctorHome.class);
		String keshi = getIntent().getExtras().getString("keshi");
		i.putExtra("keshi", keshi);
		this.startActivity(i);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_name:
			
			break;

		case R.id.more_return_btn:
			finish();
			break;
		}
	}
}
