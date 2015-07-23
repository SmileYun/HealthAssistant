package com.dongshi.healthassisant.ui.hospitalregister;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.fragment.HospitalDetailListViewLeft;
import com.dongshi.healthassisant.fragment.HospitalDetailListViewRight;
import com.dongshi.healthassisant.fragment.HospitalDetailListViewLeft.onLeftFragmentOnSelectedListener;

/**
 * 网上挂号选择医生方式
 * <p>
 * {@link Enum <p>
 * <li>FIND_DOCTOR_BY_HOPITAL (医院)
 * <p>
 * <li>FIND_DOCTOR_BY_ILLNESS(疾病)}
 * 
 * @author YUN
 */
public class ActHospitalChoiseDetail extends Activity implements
		onLeftFragmentOnSelectedListener, OnClickListener {
	FragmentManager mFragmentManager;
	Fragment mLeftFragment, mRightFragment;
	public static final int FIND_DOCTOR_BY_HOPITAL = 1;
	public static final int FIND_DOCTOR_BY_LOCAL = 2;
	public static final int FIND_DOCTOR_BY_ILLNESS = 3;
	public static final int FIND_DOCTOR_BY_ILLNESS_DETAIL = 4;
	public static final int CHOISE_KESHI = 5;
	public static final int CHOISE_KESHI_DETAIL = 6;

	TextView mTitle;
	ImageView mBack;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_hospital_choise_detail);
		mTitle = (TextView) findViewById(R.id.title_name);
		if (getIntent().getExtras().get("TAG") == null) {
			mTitle.setText("选择地区");
		} else if ("ActHospitalChoiseDetail".equals(getIntent().getExtras()
				.get("TAG").toString())) {
			mTitle.setText(getIntent().getExtras().get("hospital") + "");
		} else {
			mTitle.setText("选择地区");
		}
		mTitle.setOnClickListener(this);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);

		mFragmentManager = getFragmentManager();

		int type = getIntent().getIntExtra("type", -1);
		switch (type) {
		case FIND_DOCTOR_BY_HOPITAL:
			mLeftFragment = new HospitalDetailListViewLeft(
					createDate(FIND_DOCTOR_BY_HOPITAL));
			mRightFragment = new HospitalDetailListViewRight(
					createDate(FIND_DOCTOR_BY_HOPITAL));
			break;

		case FIND_DOCTOR_BY_ILLNESS:
			mLeftFragment = new HospitalDetailListViewLeft(
					createDate(FIND_DOCTOR_BY_ILLNESS));
			mRightFragment = new HospitalDetailListViewRight(
					createDate(FIND_DOCTOR_BY_ILLNESS));
			break;

		case CHOISE_KESHI:
			mLeftFragment = new HospitalDetailListViewLeft(
					createDate(CHOISE_KESHI_DETAIL));
			mRightFragment = new HospitalDetailListViewRight(
					createDate(CHOISE_KESHI_DETAIL));
			break;
		}

		mFragmentManager.beginTransaction()
				.add(R.id.act_hospital_detail_fragment_left, mLeftFragment)
				.commit();
		mFragmentManager.beginTransaction()
				.add(R.id.act_hospital_detail_fragment_right, mRightFragment)
				.commit();

		((HospitalDetailListViewLeft) mLeftFragment)
				.setOnSelectedListener(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public void onItemClicked(Object item) {
		((HospitalDetailListViewRight) mRightFragment).notifyData(item);
	}

	private ArrayList<HashMap<String, Object>> createDate(int type) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		switch (type) {
		case FIND_DOCTOR_BY_HOPITAL:
			String[] local = { "重庆", "上海", "四川"/*
												 * "厦门", "贵州", "湖南", "河北", "西藏",
												 * "甘肃", "河南", "湖北", "黑龙江",
												 * "天津", "山东", "山西", "陕北"
												 */};
			for (int i = 0; i < local.length; i++) {
				HashMap<String, Object> m = new HashMap<String, Object>();
				m.put("text", local[i]);
				list.add(m);
			}
			break;

		case FIND_DOCTOR_BY_ILLNESS:
			String[] ill = { "糖原累积症", "低下血症 ", "生长激素瘤", "皮质醇增多症", "慢性胃炎",
					"急性胃炎", "慢性胃炎", "慢性胃炎", "应激性溃疡" };
			for (int i = 0; i < ill.length; i++) {
				HashMap<String, Object> m = new HashMap<String, Object>();
				m.put("text", ill[i]);
				list.add(m);
			}
			break;

		case CHOISE_KESHI_DETAIL:
			String[] keshi = { "内科", "中医院", "骨科", "其他" };
			for (int i = 0; i < keshi.length; i++) {
				HashMap<String, Object> m = new HashMap<String, Object>();
				m.put("text", keshi[i]);
				list.add(m);
			}
			break;
		}
		return list;
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
