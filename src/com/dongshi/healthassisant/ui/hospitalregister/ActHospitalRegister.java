package com.dongshi.healthassisant.ui.hospitalregister;

import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.MyBaseActivity;

/**
 * 网上挂号
 * 
 * @author YUN
 *
 */
public class ActHospitalRegister extends MyBaseActivity implements OnClickListener {
	private ImageView btn_back;
	private View item00, item01, item02;
	private TextView titleName, tv_city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hospitalregister_layout);
		titleName = (TextView) findViewById(R.id.title_name);
		titleName.setText("网上挂号");

		btn_back = (ImageView) findViewById(R.id.more_return_btn);
		btn_back.setOnClickListener(this);
		item01 = findViewById(R.id.guahao_item01);
		item01.setOnClickListener(this);
		item02 = findViewById(R.id.guahao_item02);
		item02.setOnClickListener(this);
		item00 = findViewById(R.id.guahao_item00);
		item00.setOnClickListener(this);
		tv_city = (TextView) findViewById(R.id.tv_city);

		SharedPreferences sp = getSharedPreferences(SP_CHOISE_CITY_TAG, MODE_WORLD_READABLE);
		if (sp != null) {
			city = sp.getString("city", "");
			subcity = sp.getString("subcity", "");
			if (!"".equals(city) && !"".equals(subcity)) {
				tv_city.setText("" + city + " " + subcity);
			} else {
				tv_city.setText("请选择城市");
			}
		}
	}

	@Override
	public void init() {

	}

	@Override
	public void refresh(Object... param) {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.guahao_item00:
			Intent i0 = new Intent(this, ActHospitalChoiseDetail.class);
			i0.putExtra("type", ActHospitalChoiseDetail.FIND_DOCTOR_BY_HOPITAL);
			
			startActivityForResult(i0, 1);
			break;

		case R.id.guahao_item01:
			Intent i = new Intent(this, ActHospitalChoise.class);
			Bundle b = new Bundle();
			SharedPreferences sp = getSharedPreferences(SP_CHOISE_CITY_TAG, MODE_WORLD_READABLE);
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
			this.finish();
			break;

		case R.id.guahao_item02:
			Intent i2 = new Intent(this, ActHospitalChoiseDetail.class);
			i2.putExtra("type", ActHospitalChoiseDetail.CHOISE_KESHI);
			Bundle bundle = new Bundle();
			bundle.putString("TAG", "ActHospitalChoiseDetail");
			bundle.putString("TO", "ActDoctorList");
			bundle.putString("ID", "guahao_item02");
			bundle.putString("hospital", "选择科室");
			i2.putExtras(bundle);
			startActivity(i2);
			this.finish();
			break;

		case R.id.more_return_btn:
			this.finish();
			break;
		}
	}

	String city;
	String subcity;
	public static final String SP_CHOISE_CITY_TAG = "choisedcitysp";

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && resultCode == 1) {
			Bundle b = data.getExtras();
			city = b.getString("city");
			subcity = b.getString("subcity");
			tv_city.setText("" + city + " " + subcity);
			SharedPreferences sp = getSharedPreferences(SP_CHOISE_CITY_TAG, Context.MODE_PRIVATE);
			sp.edit().putString("city", city).putString("subcity", subcity).commit();
		}
	}
}
