package com.dongshi.healthassisant.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class DisplayViewPager extends ViewGroup{

	public DisplayViewPager(Context context) {
		this(context,null);
	}
	
	public DisplayViewPager(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DisplayViewPager(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}



	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		
	}
	
	
}
