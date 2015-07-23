package com.dongshi.healthassisant.ui.healthtest;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TishiDialog {

	public static AlertDialog.Builder ShowTishi(Activity paramActivity, String paramString1, String paramString2)
	  {
	    LinearLayout localLinearLayout = (LinearLayout)paramActivity.getLayoutInflater().inflate(R.layout.xj_dialog_tishi, null);
	    TextView localTextView1 = (TextView)localLinearLayout.findViewById(R.id.tv_dialog_title);
	    TextView localTextView2 = (TextView)localLinearLayout.findViewById(R.id.tv_dialog_content);
	    localTextView1.setText(paramString1);
	    localTextView2.setText(paramString2);
	    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
	    localBuilder.setView(localLinearLayout);
	    return localBuilder;
	  }
	
}
