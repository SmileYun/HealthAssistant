package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dongshi.healthassisant.R;
/**
 * @author Yun
 */
public class AdapgetTabViewPager extends PagerAdapter {
	private ArrayList<Bitmap> mPageList;
	private LayoutInflater mLayoutInflater;
	
	public AdapgetTabViewPager(Context context, ArrayList<Bitmap> list){
		mPageList = list;
		mLayoutInflater = LayoutInflater.from(context);
	}
	
	
	
	@Override
	public int getCount() {
		return mPageList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}


	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View v = mLayoutInflater.inflate(R.layout.tab_main_viewpager_item, container, false);
		ImageView page = (ImageView) v.findViewById(R.id.vp_bg);
		page.setImageBitmap((Bitmap) mPageList.get(position)) ;
		container.addView(v);
		return v;
	}
}
