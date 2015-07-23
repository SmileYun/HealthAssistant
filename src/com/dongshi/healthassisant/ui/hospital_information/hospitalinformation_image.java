package com.dongshi.healthassisant.ui.hospital_information;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class hospitalinformation_image extends Activity {

	private TextView textView;
   private ImageView returnImageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.li_hospitalinformation_image);
		textView = (TextView) findViewById(R.id.title_name);
		textView.setText("Â¥²ãµ¼º½");
		
		returnImageView=(ImageView) findViewById(R.id.more_return_btn);
		returnImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
