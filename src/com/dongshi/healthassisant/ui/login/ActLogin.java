package com.dongshi.healthassisant.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.personalinfo.ActPersonalInfo;

/**
 * 
 * @author YUN
 */
public class ActLogin extends Activity implements OnClickListener {
	private TextView titleName, forgetMM;
	private ImageView mBack;
	private EditText user, mm;
	private CheckBox cbRM, cbAL;

	private Button btnL, btnR;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login_layout);
		initView();
		registerListener();
	}

	private void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("µÇÂ¼");

		user = (EditText) findViewById(R.id.cce_login_user);
		mm = (EditText) findViewById(R.id.cce_login_mm);
		cbRM = (CheckBox) findViewById(R.id.ccc_login_remember_mm);
		cbAL = (CheckBox) findViewById(R.id.ccc_login_atuo);
		btnL = (Button) findViewById(R.id.ccb_login);
		btnR = (Button) findViewById(R.id.ccb_login_register);
		forgetMM = (TextView) findViewById(R.id.cct_login_forget_mm);
	}

	private void registerListener() {
		btnL.setOnClickListener(this);
		btnR.setOnClickListener(this);
		forgetMM.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ccb_login:
			this.startActivityForResult(new Intent(this, ActPersonalInfo.class), 1);
			this.finish();
			break;
			
		case R.id.ccb_login_register:
			this.startActivityForResult(new Intent(this, ActLoginRegister.class), 1);
			this.finish();
			break;

		case R.id.cct_login_forget_mm:
			
			break;
			
		case R.id.more_return_btn:
			finish();
			break;
		}

	}
}
