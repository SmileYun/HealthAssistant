package com.dongshi.healthassisant.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class Li_AdapgetHealthinformation extends PagerAdapter {
	private List<View> viewlist;
	private List<String> titleList;

	public Li_AdapgetHealthinformation(List<View> viewlist, List<String> titleList) {
		this.viewlist = viewlist;
		this.titleList=titleList;
	}

	// ҳ����
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return viewlist.size();
	}

	// view�Ƿ���֮�ڶ���
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	// ʵ����ҳ��
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		
		Log.i("kyo", "TAB"+position);
		container.addView(viewlist.get(position));
		return viewlist.get(position);
	}

	// ����ҳ��
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(viewlist.get(position));

	}
	
	//����ҳ������
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return titleList.get(position);
	}
}
