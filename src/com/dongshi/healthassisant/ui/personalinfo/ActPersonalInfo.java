package com.dongshi.healthassisant.ui.personalinfo;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterPersonalInfo;
import com.dongshi.healthassisant.ui.MyBaseActivity;
import com.dongshi.healthassisant.ui.healthtest.ActHealthTest;
import com.dongshi.healthassisant.ui.hospital_information.hospitalinformation_usa_detail;

/**
 * 
 * @author YUN
 * 
 */
public class ActPersonalInfo extends MyBaseActivity implements OnClickListener,
		OnItemClickListener {
	private TextView titleName, mUserID;
	private Context mContext;
	private ImageView mBack;
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList = new ArrayList<HashMap<String, Object>>();
	private AdapterPersonalInfo mAdapter;
	private View mPersonInfoAccount;
	private LinearLayout person_info_lvll, person_info_detail;
	private int[] imageico = new int[] { R.drawable.loginitem1,
			R.drawable.loginitem2, R.drawable.loginitem3,
			R.drawable.loginitem5, R.drawable.loginitem4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_personal_info_main);
		initView();
	}

	private void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("信息查询");
		mUserID = (TextView) findViewById(R.id.tv_personal_info_id);
		mListView = (ListView) findViewById(R.id.listview_personal_info);
		mListView.setOnItemClickListener(this);
		getData();
		mAdapter = new AdapterPersonalInfo(this, mList);
		mListView.setAdapter(mAdapter);
		mPersonInfoAccount = findViewById(R.id.person_info_account);
		mPersonInfoAccount.setOnClickListener(this);
		person_info_lvll = (LinearLayout) findViewById(R.id.person_info_lvll);
		person_info_detail = (LinearLayout) findViewById(R.id.person_info_detail);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		person_info_lvll.scrollBy(0,
				person_info_detail.getLayoutParams().height);

	}

	@Override
	public void init() {
	}

	private void getData() {
		mList.clear();
		for (int i = 0; i < res.length; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("name", res[i]);
			m.put("icon", imageico[i]);
			mList.add(m);
		}
		if (mAdapter != null)
			mAdapter.notifyDataSetChanged();
	}

	String[] res = { "最近检测及诊断结果", "历史病历", "用药情况", "健康自测", "费用记录" };

	@Override
	public void refresh(Object... param) {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.more_return_btn:
			finish();
			break;

		case R.id.person_info_account:
			Intent i = new Intent();

			this.startActivity(i);
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		if (position == 3) {
			Intent intent = new Intent(mContext, ActHealthTest.class);
			startActivity(intent);
		} else if(position == 0) {
			Intent intent = new Intent(mContext, ActPersonResfult.class);
			startActivity(intent);
		}else {
			HashMap<String, Object> map = (HashMap<String, Object>) parent
					.getAdapter().getItem(position);
			Intent intent = new Intent(mContext, ActPersonalInfo_Detail.class);
			startActivity(intent);
		}

	}

}
