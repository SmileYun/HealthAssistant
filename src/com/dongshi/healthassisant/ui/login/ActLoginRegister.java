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

public class ActLoginRegister extends Activity implements OnClickListener {
	private TextView titleName;
	private ImageView mBack;
	private EditText user, mm, repeatmm, verfied;
	private CheckBox cbRM, cbAL;

	private Button btnV, btnR;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login_register);
		initView();
		registerListener();
	}

	private void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("зЂВс");

		user = (EditText) findViewById(R.id.cce_login_reg_user);
		mm = (EditText) findViewById(R.id.cce_login_reg_mm);
		repeatmm = (EditText) findViewById(R.id.cce_login_reg_mm_repeat);
		verfied = (EditText) findViewById(R.id.cce_login_reg_verified);
		
		btnV = (Button) findViewById(R.id.ccb_login_get_verified);
		btnR = (Button) findViewById(R.id.ccb_login_reg_reg);
		
	}

	private void registerListener() {
		btnV.setOnClickListener(this);
		btnR.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ccb_login_reg_reg:
			this.startActivityForResult(new Intent(this, ActPersonalInfo.class), 1);
			this.finish();
			break;

		case R.id.ccb_login_get_verified:
			break;


		case R.id.more_return_btn:
			finish();
			break;
		}

	}
}