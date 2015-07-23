package com.dongshi.healthassisant.ui.tabact;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TabMore_Statement extends Activity implements OnClickListener {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.more_ui_statement);
    	TextView textView=(TextView) findViewById(R.id.title_name);
    	textView.setText("ÃâÔðÉùÃ÷");
    	
    	ImageView imageView=(ImageView) findViewById(R.id.more_return_btn);
    	imageView.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}
