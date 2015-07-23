package com.dongshi.healthassisant.ui.tabact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapgetTabViewPager;
import com.dongshi.healthassisant.adapter.AdapterGridViewMain;
import com.dongshi.healthassisant.adapter.AdapterGridViewMain2;
import com.dongshi.healthassisant.ui.MyBaseActivity;
import com.dongshi.healthassisant.ui.healthinformation.healthinformation_main;
import com.dongshi.healthassisant.ui.healthtest.ActHealthTest;
import com.dongshi.healthassisant.ui.hospital_information.hospitalinformation_with;
import com.dongshi.healthassisant.ui.hospital_information.hospitalinformation_with_old;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalRegister;
import com.dongshi.healthassisant.ui.login.ActLogin;
import com.dongshi.healthassisant.ui.personalinfo.ActPersonalInfo;
import com.dongshi.healthassisant.ui.smartexam.ActSmartDiagnoise;
import com.dongshi.healthassisant.widget.LoginDialog;
import com.dongshi.healthassisant.widget.ViewPagerCustomDuration;

/**
 * @author Yun
 */
public class TabMain extends MyBaseActivity {
	private GridView mGridView;
	private ArrayList<HashMap<String, Object>> mList;
	private ViewPagerCustomDuration mViewPager;
	private ImageView pvIndex0, pvIndex1, pvIndex2, pvIndex3, pvIndex4;
	private ImageView tilteBtn;
	private Timer mVpRollTimer;
	private boolean mTimerWork = false;
	private LinearLayout main_linearLayout;
	private Context mContext;

	private int[] imageLists = { R.drawable.main_itme_1,
			R.drawable.main_itme_2, R.drawable.main_itme_3,
			R.drawable.main_itme_4, R.drawable.main_itme_5,
			R.drawable.main_itme_6 };
	private Class[] clazz = { ActHospitalRegister.class,
			ActSmartDiagnoise.class, ActLogin.class, ActHealthTest.class,
			hospitalinformation_with.class, healthinformation_main.class };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_main_layout);
		initView();
		mVpRollTimer = new Timer();
		mVpRollTimer.scheduleAtFixedRate(new DisplayVPRollTask(), 6000, 6000);
		startTimerTask();
	}

	private void initView() {
		mGridView = (GridView) findViewById(R.id.tab_main_gridview_guide);

		View title = findViewById(R.id.title_include);// title_user_icon
		tilteBtn = (ImageView) title.findViewById(R.id.title_user_icon);
		tilteBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(TabMain.this, LoginDialog.class);
				TabMain.this.startActivity(i);
			}
		});

		main_linearLayout = (LinearLayout) findViewById(R.id.main_linearlayout);

		main_linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {
					boolean isFirst = true;

					// 默认调用两次，这里只让它执行一次回调

					@Override
					public void onGlobalLayout() {
						if (isFirst) {
							isFirst = false;

							if (mList == null) {
								mList = getData();
							}
							mGridView.setAdapter(new AdapterGridViewMain(
									mContext, mList, main_linearLayout
											.getHeight()));
							mGridView
									.setOnItemClickListener(new ItemClickListener());
						}
					}
				});

		// vp 视图
		View _v = findViewById(R.id.display_viewpager);
		mViewPager = (ViewPagerCustomDuration) _v
				.findViewById(R.id.tab_main_viewpager);
		setVpIntervelTime(2000);
		pvIndex0 = (ImageView) _v.findViewById(R.id.pvindex0);
		pvIndex1 = (ImageView) _v.findViewById(R.id.pvindex1);
		pvIndex2 = (ImageView) _v.findViewById(R.id.pvindex2);
		pvIndex3 = (ImageView) _v.findViewById(R.id.pvindex3);
		pvIndex4 = (ImageView) _v.findViewById(R.id.pvindex4);
		ArrayList<Bitmap> list = new ArrayList<Bitmap>();
		list.add(BitmapFactory.decodeStream(getResources().openRawResource(
				R.drawable.w01)));
		list.add(BitmapFactory.decodeStream(getResources().openRawResource(
				R.drawable.w02)));
		list.add(BitmapFactory.decodeStream(getResources().openRawResource(
				R.drawable.w03)));
		list.add(BitmapFactory.decodeStream(getResources().openRawResource(
				R.drawable.w04)));
		list.add(BitmapFactory.decodeStream(getResources().openRawResource(
				R.drawable.w04)));
		mViewPager.setAdapter(new AdapgetTabViewPager(this, list));
		mViewPager.setOnPageChangeListener(new MyPageChangeListener());
		mViewPager.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					stopTimerTask();
					break;

				case MotionEvent.ACTION_UP:
					startTimerTask();
					break;
				}

				return false;
			}
		});
	}

	private ArrayList<HashMap<String, Object>> getData() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < clazz.length; i++) {
			// ImageView view=(ImageView) findViewById();
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("itemGridImgRes", imageLists[i]);

			list.add(m);
		}
		return list;
	}

	private int mCurrIndex;

	class MyPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			// 参数arg0为选中的View
			TextView textViewContent = (TextView) findViewById(R.id.textViewContent);
			switch (arg0) {
			case 0: // 页面一

				pvIndex0.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));// 进入第一个导航页面，小圆点为选中状态，下一个页面的小圆点是未选中状态。
				pvIndex1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				textViewContent.setText(R.string.falsh_image1);

				break;

			case 1: // 页面二

				pvIndex1.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));// 当前View
				pvIndex0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));// 上一个View
				pvIndex2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));// 下一个View
				pvIndex3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				textViewContent.setText(R.string.falsh_image2);
				break;

			case 2:
				pvIndex3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex2.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				pvIndex1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				textViewContent.setText(R.string.falsh_image3);
				// button.setVisibility(View.VISIBLE);
				break;
			case 3:
				pvIndex3.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				pvIndex2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				textViewContent.setText(R.string.falsh_image4);
				// button.setVisibility(View.VISIBLE);
				break;
			case 4:
				pvIndex4.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				pvIndex3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				pvIndex0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				textViewContent.setText(R.string.falsh_image5);
				// button.setVisibility(View.VISIBLE);
				break;
			}

			mCurrIndex = arg0;// 设置当前View
		}
	}

	private void startTimerTask() {
		mTimerWork = true;
	}

	private void stopTimerTask() {
		mTimerWork = false;
	}

	/**
	 * 反射機制設置ViewPager setCurrentItem(t)時間
	 * 
	 * @param intervel
	 *            時間
	 */
	Scroller mScroller;

	private void setVpIntervelTime(int intervel) {
		mViewPager.setScrollDurationFactor(5.0);
	}

	final class DisplayVPRollTask extends TimerTask {

		@Override
		public void run() {
			mVPRollHandler.obtainMessage(0).sendToTarget();
		}
	}

	private final Handler mVPRollHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (mTimerWork) {
				mCurrIndex += 1;
				mViewPager.setCurrentItem(mCurrIndex % 4);
			}
		};
	};

	/**
	 * GridView 按钮监听
	 * 
	 * @author YUN
	 */
	final class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = new Intent(TabMain.this, clazz[position]);
			TabMain.this.startActivity(i);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mVpRollTimer.purge();
		mVpRollTimer.cancel();
	}

	@Override
	public void init() {
	}

	@Override
	public void refresh(Object... param) {

	}
}
