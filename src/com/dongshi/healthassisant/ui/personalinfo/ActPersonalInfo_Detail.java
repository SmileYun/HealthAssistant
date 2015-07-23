package com.dongshi.healthassisant.ui.personalinfo;

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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterPersonalInfo;
import com.dongshi.healthassisant.ui.MyBaseActivity;

/**
 * 
 * @author YUN
 *
 */
public class ActPersonalInfo_Detail extends Activity implements OnClickListener{
	private TextView titleName;
	private ImageView mBack;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_personal_info_detail);
		initView();
	}

	private void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("最近检测及诊断结果");
		
		getData();
		
	}

	
	
	

	private void getData() {
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}

	

}
