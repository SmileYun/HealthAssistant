package com.dongshi.healthassisant.ui.healthinformation;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class healthinformation_context extends Activity implements OnClickListener{
	
	private TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.li_healthinformation_view1_lsitem_context);
		textView = (TextView) findViewById(R.id.title_name);
		textView.setText("½¡¿µ×ÊÑ¶");
		
		ImageView imageView=(ImageView) findViewById(R.id.more_return_btn);
		imageView.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}
