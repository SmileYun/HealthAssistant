package com.dongshi.healthassisant.ui;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.MyFragmentPagerAdapter;
import com.dongshi.healthassisant.util.SettingSP;
import com.dongshi.healthassisant.widget.MyTabBarTextView;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTabTopActivity_XJ extends BaseActivity_XJ 
implements ViewPager.OnPageChangeListener
{
	private static final int GRAY = 0;
	private static final int GREEN = 1;
	public List<Fragment> mFragments = new ArrayList();
	public int mPreSelectItem;
	public String[] mTabItemIDs;
	public String[] mTabItems;
	public ViewGroup mViewGroup;
	public ViewPager mViewPager;
	public int screenWidth;
	public float density;
	public MyFragmentPagerAdapter viewpageAdapter;

	public abstract void initData();

	public void initTabbar() {
		this.mViewGroup = ((ViewGroup) findViewById(R.id.ll_tabtop));
		int i = this.mTabItems.length;

		if (0 >= this.mTabItems.length)
			return;
		

		for (int j = 0; j < this.mTabItems.length; j++) {
			MyTabBarTextView localMyTabBarTextView = new MyTabBarTextView(this);
			if (j == 0) {
				localMyTabBarTextView.setTextColor(getResources().getColor(
						R.color.green));
				localMyTabBarTextView.setLineState(1);
			}
			localMyTabBarTextView.setText(this.mTabItems[j]);
			localMyTabBarTextView.setOnClickListener(this);

			int k = (int) (localMyTabBarTextView.getPaint().measureText(
					this.mTabItems[j]) + 30.0F * this.density);
			if (k * i < this.screenWidth)
				localMyTabBarTextView
						.setLayoutParams(new LinearLayout.LayoutParams(
								this.screenWidth / i, -1));
			else {
				localMyTabBarTextView
						.setLayoutParams(new LinearLayout.LayoutParams(k, -1));
			}

			this.mViewGroup.addView(localMyTabBarTextView);
		}

	}

	public void initViewPager() {
		this.mViewPager = ((ViewPager) findViewById(R.id.vp_tabtop));
		this.viewpageAdapter = new MyFragmentPagerAdapter(
				getSupportFragmentManager(), this.mFragments);
		this.mViewPager.setAdapter(this.viewpageAdapter);
		this.mViewPager.setOnPageChangeListener(this);
	}

	public void moveTitleLabel(int paramInt)
	  {
		
		int sumwidth=this.mViewGroup.getMeasuredWidth();
		int childwidth=this.mViewGroup.getChildAt(paramInt).getMeasuredWidth();
		
		int presumwidth=0;
		int prewidth=0;
		
		
		for(int n=0;n<this.mViewGroup.getChildCount();n++)
		{
			MyTabBarTextView localMyTabBarTextView = (MyTabBarTextView)this.mViewGroup.getChildAt(n);
			int i1 = localMyTabBarTextView.getMeasuredWidth();
			if (n == paramInt)
	        {
	          localMyTabBarTextView.setTextColor(getResources().getColor(R.color.green));
	          localMyTabBarTextView.setLineState(1);
	        }
	        else
	        {
	        	if(n<paramInt)
	        	{
	        		presumwidth=presumwidth+i1;
	        	}
	          localMyTabBarTextView.setLineState(0);
	          localMyTabBarTextView.setTextColor(-7829368);
	        }
		}
		
		if(paramInt>0)
		{
			prewidth=this.mViewGroup.getChildAt(paramInt - 1).getMeasuredWidth();
		}
		
	   int	i2 = presumwidth - (this.screenWidth - childwidth) / 2;
		
		 if (this.mPreSelectItem >= paramInt)
		 {
			 if (sumwidth - presumwidth>= this.screenWidth / 2)
			        ((HorizontalScrollView)this.mViewGroup.getParent()).scrollTo(i2, 0);
		 }
		 else
		 {
			 if (prewidth + (presumwidth + childwidth) >= this.screenWidth / 2)
			        ((HorizontalScrollView)this.mViewGroup.getParent()).scrollTo(i2, 0);
		 }
		
		 this.mPreSelectItem = paramInt;
		
	     
	  }

	public void onClick(View paramView) {
		super.onClick(paramView);
		if (this.mViewGroup != null&&this.mViewGroup.getChildCount()>0) {
			for (int i = 0; i < this.mViewGroup.getChildCount(); i++) {
				 
				if (paramView == this.mViewGroup.getChildAt(i)) {
					this.mViewPager.setCurrentItem(i);
					return;
				}
			}
		}
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		//this.screenWidth = ((int) SettingSP.screenWidth(this));
		DisplayMetrics dm = new DisplayMetrics();
	      getWindowManager().getDefaultDisplay().getMetrics(dm);
		this.screenWidth=dm.widthPixels;
		this.density=dm.density;
		initData();
	}

	public void onPageScrollStateChanged(int paramInt) {
	}

	public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
	}

	public void onPageSelected(int paramInt) {
		moveTitleLabel(paramInt);
	}
}
