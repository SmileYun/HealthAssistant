package com.dongshi.healthassisant.ui.smartexam;

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
import com.dongshi.healthassisant.adapter.AdapterLVItemSimpleTVAndArrow;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoise;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;

/**
 * 
 * @author YUN
 *
 */
public class ActSmartDEXamResult extends Activity implements OnClickListener, OnItemClickListener {
	private TextView titleName, mQContent;
	private ImageView mBack;
	private ListView mListView;
	private AdapterLVItemSimpleTVAndArrow mAdapter;
	private ArrayList<HashMap<String, Object>> mList = new ArrayList<HashMap<String,Object>>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_smart_selfexam_result);
		getIntent().getStringExtra("result");//结果
		initView();
	}

	private void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("自测结果");
		getListViewData();
		mListView = (ListView) findViewById(R.id.listview_smart_selfexam_res);
		
		mQContent = (TextView) findViewById(R.id.smart_result_content);
		mQContent.setText("可能病症是 " + getIntent().getStringExtra("result"));
		
		mAdapter = new AdapterLVItemSimpleTVAndArrow(this, mList);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.more_return_btn:
			finish();
			break;
		}
	}

	void getListViewData(){
		mList.clear();
		for (int i = 0; i < 3; i++) {
			HashMap<String,Object> m = new HashMap<String,Object>();
			m.put("name", SS[i]);
			mList.add(m);
		}
		
	}
	
	String[] SS = {"耳鼻咽喉科", "小二咽喉科", "治愈科"};
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent i2 = new Intent(this, ActHospitalChoise.class);
		i2.putExtra("type", ActHospitalChoiseDetail.CHOISE_KESHI);
		Bundle bundle = new Bundle();
		bundle.putString("TAG", "ActHospitalChoiseDetail");
		bundle.putString("TO", "ActDoctorList");
		bundle.putString("ID", "guahao_item02");
		bundle.putString("hospital", "选择科室");
		i2.putExtras(bundle);
		startActivity(i2);
		this.finish();
	}
}
