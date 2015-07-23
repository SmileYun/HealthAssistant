package com.dongshi.healthassisant.ui;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoise;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalRegister;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Yun
 */
public abstract class MyBaseActivity extends Activity implements OnClickListener {
	private static String Tag = "MyBaseActivity";
	private TextView mTitleName;
	private ImageView mBtnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i(Tag, "启动create");
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// MainService.addActivity(this);
	}
	
	public void setTitleName(String titleStr) {
		initView(titleStr);
	}
	
	private void initView(String titleStr) {
		mTitleName = (TextView) findViewById(R.id.title_name);
		mTitleName.setText(titleStr);
		//mBtnBack = (ImageView) findViewById(R.id.more_return_btn);
		//mBtnBack.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.more_return_btn:
			this.finish();
			break;
		}
	}
	
	
	/**
	 * call in onStart(), after call onCreate();
	 */
	public abstract void init();

	public abstract void refresh(Object... param);

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(Tag, "启动destroy");
		// MainService.removeActivity(this);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.i(Tag, "启动start");
		init();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.i(Tag, "启动ReStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i(Tag, "启动resume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.i(Tag, "启动pause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(Tag, "启动stop");
	}
}
