package com.dongshi.healthassisant.ui.healthtest;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentStatePagerAdapter extends FragmentPagerAdapter {

	private List<BaseTestFragment> fragments;

	  public MyFragmentStatePagerAdapter(FragmentManager paramFragmentManager, List<BaseTestFragment> paramList)
	  {
	    super(paramFragmentManager);
	    this.fragments = paramList;
	  }

	  public int getCount()
	  {
	    return this.fragments.size();
	  }

	  public Fragment getItem(int paramInt)
	  {
	    return (Fragment)this.fragments.get(paramInt);
	  }

	  public int getItemPosition(Object paramObject)
	  {
	    return -2;
	  }

}
