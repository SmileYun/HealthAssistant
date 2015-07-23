package com.dongshi.healthassisant.ui;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainLoad extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadmainui);
		Start();
	}

	public void Start() {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Intent intent = new Intent();
				intent.setClass(MainLoad.this, MainActivity.class);
				startActivity(intent);
			
				finish();
			}
		}.start();
	}

}