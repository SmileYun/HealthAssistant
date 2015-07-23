package com.dongshi.healthassisant.ui.tabact;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TabMore_About extends Activity implements OnClickListener {
	private Context mContext;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_about);
		ImageView imageView = (ImageView) findViewById(R.id.more_return_btn);
		imageView.setOnClickListener(this);
		textView = (TextView) findViewById(R.id.more_title_text);
		textView.setText("关于我们");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}
