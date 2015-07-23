package com.dongshi.healthassisant.ui.hospital_information;

import com.dongshi.healthassisant.R;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class hospitalinformation_usa_detail extends Activity {

	private TextView textView;
	private ImageView returnImageView;
	private Context mContext;
	private ImageView hospImageView;
	private TextView hospNameTextView;
	private TextView hospDetailTextView;
	private TextView hospCalTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.li_hospitalinformation_usa_detail);
		textView = (TextView) findViewById(R.id.title_name);
		textView.setText("国外医院");
		hospImageView = (ImageView) findViewById(R.id.heal_image);
		hospNameTextView = (TextView) findViewById(R.id.yishengjianjie_goodat);
		hospDetailTextView = (TextView) findViewById(R.id.yishengjianjie_Pone);
		hospCalTextView = (TextView) findViewById(R.id.keshi_textview);
		returnImageView = (ImageView) findViewById(R.id.more_return_btn);
		returnImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		GetDataHosp(getIntent().getExtras());
	}

	public void GetDataHosp(Bundle b) {

		String itemID = b.getString("hospitalId");
		String hospName = b.getString("hospitalName");
		int hospImage = b.getInt("hospitalImage");
		hospNameTextView.setText(hospName);
		hospImageView.setImageDrawable(getResources().getDrawable(hospImage));
		if ("0".equals(itemID)) {
			hospDetailTextView.setText(R.string.hosp_detail0);
			hospCalTextView.setText("18329347812 张医生");
		} else if ("1".equals(itemID)) {
			hospDetailTextView.setText(R.string.hosp_detail1);
			hospCalTextView.setText("15334356583 涂医生");
		} else if ("2".equals(itemID)) {
			hospDetailTextView.setText(R.string.hosp_detail2);
			hospCalTextView.setText("15334356583 涂医生");
		}

	}

}
