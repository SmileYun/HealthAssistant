package com.dongshi.healthassisant.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> fragmentsList;

	  public MyFragmentPagerAdapter(FragmentManager paramFragmentManager, List<Fragment> paramList)
	  {
	    super(paramFragmentManager);
	    this.fragmentsList = paramList;
	  }

	  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
	  {
	    System.out.println("position Destory" + paramInt);
	    super.destroyItem(paramViewGroup, paramInt, paramObject);
	  }

	  public int getCount()
	  {
	    return this.fragmentsList.size();
	  }

	  public Fragment getItem(int paramInt)
	  {
	    return (Fragment)this.fragmentsList.get(paramInt);
	  }

	  public int getItemPosition(Object paramObject)
	  {
	    return super.getItemPosition(paramObject);
	  }

	  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
	  {
	    return (Fragment)super.instantiateItem(paramViewGroup, paramInt);
	  }

}
