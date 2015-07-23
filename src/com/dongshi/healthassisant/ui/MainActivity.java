package com.dongshi.healthassisant.ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.app.AppContext;
import com.dongshi.healthassisant.app.AppManager;
import com.dongshi.healthassisant.ui.tabact.TabAlarm;
import com.dongshi.healthassisant.ui.tabact.TabFamourDoc;
import com.dongshi.healthassisant.ui.tabact.TabInternetExam;
import com.dongshi.healthassisant.ui.tabact.TabMain;
import com.dongshi.healthassisant.ui.tabact.TabMore;
import com.dongshi.healthassisant.util.UIHelper;


public class MainActivity extends TabActivity {
	
	private Class[] clazz = {TabMain.class, TabAlarm.class, TabFamourDoc.class,
			TabInternetExam.class, TabMore.class};
	private TabHost mTabHost;
	private RadioGroup radioGroup;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		AppManager.getAppManager().addActivity(this);
		mTabHost = getTabHost();
		initView();
	}


	private void initView() {
		mTabHost.addTab(mTabHost.newTabSpec("main").setIndicator("main").setContent(new Intent(this, clazz[0])));
		mTabHost.addTab(mTabHost.newTabSpec("alarm").setIndicator("main").setContent(new Intent(this, clazz[1])));
		mTabHost.addTab(mTabHost.newTabSpec("userinfo").setIndicator("main").setContent(new Intent(this, clazz[2])));
		mTabHost.addTab(mTabHost.newTabSpec("internetexam").setIndicator("main").setContent(new Intent(this, clazz[3])));
		mTabHost.addTab(mTabHost.newTabSpec("more").setIndicator("main").setContent(new Intent(this, clazz[4])));
		
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
		radioGroup.setOnCheckedChangeListener(checkedChangeListener);
	}
	
	private OnCheckedChangeListener checkedChangeListener = new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.radio_main:
				mTabHost.setCurrentTabByTag("main");
				break;

			case R.id.radio_alarm:
				mTabHost.setCurrentTabByTag("alarm");
				Log.i("alarm", "122");
				break;
				
			case R.id.radio_user:
				mTabHost.setCurrentTabByTag("userinfo");
				break;
				
			case R.id.radio_internet:
				mTabHost.setCurrentTabByTag("internetexam");
				break;
				
			case R.id.radio_more:
				mTabHost.setCurrentTabByTag("more");
				break;
	
			}
		}
	};
	
	@Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        AppContext.bottomHeight = radioGroup.getHeight();
    };
	
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {
            // 是否退出应用
            UIHelper.Exit(this);
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
