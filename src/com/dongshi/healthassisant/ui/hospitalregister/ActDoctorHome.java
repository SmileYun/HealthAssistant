package com.dongshi.healthassisant.ui.hospitalregister;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.fragment.FragmentDoctor01;
import com.dongshi.healthassisant.fragment.FragmentDoctor02;
import com.dongshi.healthassisant.fragment.FragmentDoctor03;
import com.dongshi.healthassisant.fragment.FragmentDoctor04;

/**
 * @author 	YUN
 */
public class ActDoctorHome extends Activity implements OnClickListener {

	private ViewGroup mDoctorFragmentTitle;
	private ViewGroup mDoctorFragmentUnderlineTitle;
	private int mLastSelected = 1;
	private Fragment f;
	private ImageView btnBack;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_doctor_home);
		initView();
		bindListener();
	}

	private void initView() {
		mDoctorFragmentTitle = (ViewGroup) findViewById(R.id.doctor_fragment_title);
		mDoctorFragmentUnderlineTitle = (ViewGroup) findViewById(R.id.doctor_fragment_underline_title);
		f = new FragmentDoctor02();
		getFragmentManager().beginTransaction().add(R.id.doctor_container, f).commit();
		btnBack = (ImageView) findViewById(R.id.actionbar_home_btn);
	}

	private void bindListener() {
		for (int i = 0; i < mDoctorFragmentTitle.getChildCount(); i++)
			mDoctorFragmentTitle.getChildAt(i).setOnClickListener(this);
		btnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.actionbar_home_btn) {
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
				f = new FragmentDoctor01();
				break;
			case 1:
				f = new FragmentDoctor02();
				break;
			case 2:
				f = new FragmentDoctor03();
				break;
			case 3:
				f = new FragmentDoctor04();
				break;
			default:
				break;
			}
			getFragmentManager().beginTransaction().replace(R.id.doctor_container, f).commit();
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
}
