package com.dongshi.healthassisant.ui.healthtest;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;
import com.dongshi.healthassisant.ui.internetexam.OnlineTalkDetailActivity;

public class HealthTestResult extends BaseActivity_XJ {
	Button btnAskDoctor;

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.xj_healthtestresult);
		initTitle("��������");

		TextView promptTextView = (TextView) this.findViewById(R.id.txtlink);
		promptTextView.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private void iniLayout() {

	}

	public void onClick(View paramView) {
		super.onClick(paramView);
		if(paramView.getId()==R.id.btnAskDoctor)
		{
			Intent localIntent = new Intent(HealthTestResult.this,
					OnlineTalkDetailActivity.class);
			//���ݲ���
			localIntent.putExtra("isnewq",0);
			localIntent.putExtra("type",1);
			startActivity(localIntent);
		}
	}
}
