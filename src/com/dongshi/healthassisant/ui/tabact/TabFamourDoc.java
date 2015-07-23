package com.dongshi.healthassisant.ui.tabact;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.dongshi.healthassisant.ui.MyBaseActivity;
import com.dongshi.healthassisant.ui.hospitalregister.ActDoctorHome;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoise;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalRegister;

/**
 * 
 * @author YUN
 */
public class TabFamourDoc extends MyBaseActivity implements OnClickListener, OnItemClickListener {
	private TextView mTHosp, mTKeshi;
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_famous_doc);
		initView();
	}

	private void initView() {
		setTitleName("医院名医");

		mTHosp = (TextView) findViewById(R.id.cct_tab_famous_choise_hosp);
		mTHosp.setOnClickListener(this);
		mTKeshi = (TextView) findViewById(R.id.cct_tab_famous_choise_keshi);
		mTKeshi.setOnClickListener(this);
		mListView = (ListView) findViewById(R.id.ccl_tab_famous_listview_famous_doctor);
		mListView.setOnItemClickListener(this);
		mList = getData();

		mListView.setAdapter(new AdapterDocterLVItem(this, mList));
		mListView.setOnItemClickListener(this);
		mListView.setAdapter(new AdapterDocterLVItem(this, mList));
		
		SharedPreferences sp = getSharedPreferences(ActHospitalRegister.SP_CHOISE_CITY_TAG, MODE_PRIVATE);
		if (sp != null) {
			mTKeshi.setText(sp.getString("keshi", "请选择科室"));
			mTHosp.setText(sp.getString("hospital", "请选择医院"));
		}
	}

	private ArrayList<HashMap<String, Object>> getData() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < docN.length; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("name", docN[i]);
			m.put("content", docN[i] + "  医生的内容是...");
			m.put("level", "专家医生");
			m.put("goodar", i + "手术");
			m.put("count", (231 + 8 * i));
			list.add(m);
		}
		return list;
	}

	String[] docN = { "郑树深", "王伟", "张明", "沈燕", "吴健", "梁丰", "林逸", "陈玉舒", "华佗", "扁鹊" };
	String city, subcity;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cct_tab_famous_choise_hosp:
			Intent i = new Intent(this, ActHospitalChoise.class);
			Bundle b = new Bundle();
			SharedPreferences sp = getSharedPreferences(ActHospitalRegister.SP_CHOISE_CITY_TAG, MODE_WORLD_READABLE);
			if (sp != null) {
				city = sp.getString("city", "");
				subcity = sp.getString("subcity", "");
				if (!"".equals(city) && !"".equals(subcity)) {
					b.putString("city", city);
					b.putString("subcity", subcity);
				}
			}
			i.putExtras(b);
			startActivity(i);
			break;

		case R.id.cct_tab_famous_choise_keshi:
			Intent i2 = new Intent(this, ActHospitalChoiseDetail.class);
			i2.putExtra("type", ActHospitalChoiseDetail.CHOISE_KESHI);
			Bundle bundle = new Bundle();
			bundle.putString("TAG", "ActHospitalChoiseDetail");
			bundle.putString("TO", "ActDoctorList");
			bundle.putString("ID", "guahao_item02");
			bundle.putString("hospital", "选择科室");
			i2.putExtras(bundle);
			startActivity(i2);
			break;
		}
		super.onClick(v);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent i = new Intent(this, ActDoctorHome.class);
//		String keshi = getIntent().getExtras().getString("keshi");
//		i.putExtra("keshi", keshi);
		this.startActivity(i);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refresh(Object... param) {
		// TODO Auto-generated method stub
		
	}

}
