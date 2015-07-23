package com.dongshi.healthassisant.ui.hospital_information;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.MyBaseActivity;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;

/**
 * 
 * @author YUN
 */
public class hospitalinformation_with extends MyBaseActivity {
	private ViewGroup mDoctorFragmentTitle;
	private ViewGroup mDoctorFragmentUnderlineTitle;
	private int mLastSelected = 0;
	private Fragment f;
	private TextView textDQ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_hospital_info_with);
		initView();
		bindListener();
	}

	private void initView() {
		setTitleName("医院信息");
		mDoctorFragmentTitle = (ViewGroup) findViewById(R.id.hospital_info_fragment_title);
		mDoctorFragmentUnderlineTitle = (ViewGroup) findViewById(R.id.hospital_info_fragment_underline_title);
		f = new HospitalFrg01();
		getFragmentManager().beginTransaction().add(R.id.hospital_info_fragment_content, f).commit();

//		textDQ = (TextView) findViewById(R.id.iv_set);
//		textDQ.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Intent i0 = new Intent(hospitalinformation_with.this, ActHospitalChoiseDetail.class);
//				i0.putExtra("type", ActHospitalChoiseDetail.FIND_DOCTOR_BY_HOPITAL);
//				Bundle b = new Bundle();
//				b.putString("TAG", "HospitalWith");
//				i0.putExtras(b);
//				startActivityForResult(i0, 5);
//			}
//		});
		ImageView imageView = (ImageView) findViewById(R.id.more_return_btn);
		imageView.setOnClickListener(this);
	}

	private void bindListener() {
		for (int i = 0; i < mDoctorFragmentTitle.getChildCount(); i++)
			mDoctorFragmentTitle.getChildAt(i).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.more_return_btn) {
			finish();
			return;
		}
		int index = getChildIndex(v);
		if (mLastSelected != index) {
			((TextView) mDoctorFragmentTitle.getChildAt(mLastSelected)).setTextColor(getResources().getColor(R.color.text_color_gray));
			mDoctorFragmentUnderlineTitle.getChildAt(mLastSelected).setVisibility(View.INVISIBLE);

			((TextView) v).setTextColor(getResources().getColor(R.color.doctor_selected_title_bg));
			mDoctorFragmentUnderlineTitle.getChildAt(index).setVisibility(View.VISIBLE);
			mLastSelected = index;

			switch (index) {
			case 0:
				f = new HospitalFrg01();
				break;
			case 1:
				f = new HospitalFrg02();
				break;
			default:
				break;
			}
			getFragmentManager().beginTransaction().replace(R.id.hospital_info_fragment_content, f).commit();
		}
	}

	private int getChildIndex(View v) {
		int j = -1;
		for (int i = 0; i < mDoctorFragmentTitle.getChildCount(); i++) {
			if (mDoctorFragmentTitle.getChildAt(i) == v) {
				return i;
			}
		}
		return j;
	}

	String city;
	String subcity;

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 5 && resultCode == 0) {

			SharedPreferences spPreferences = getSharedPreferences("hospitalwith", Activity.MODE_PRIVATE);
			textDQ.setText("医院导航");
			Fragment fragment = getFragmentManager().findFragmentById(R.id.hospital_info_fragment_content);
			if (fragment instanceof HospitalFrg02) {
				Bundle b = new Bundle();
				b.putString("hospName", spPreferences.getString("hospName", ""));
				b.putString("hospName2", spPreferences.getString("hospName", "") + "XXX27号");
				((HospitalFrg02) fragment).update(b);
			}
		}
	}

	@Override
	public void init() {
	}

	@Override
	public void refresh(Object... param) {
	}
}
