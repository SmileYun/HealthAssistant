package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
 * @author Yun
 */
public abstract class AdapterBase extends BaseAdapter{
	protected ArrayList<HashMap<String, Object>> mList;
	protected Context mContext;
	
	public AdapterBase(Context context, ArrayList<HashMap<String, Object>> mList){
		this.mList = mList;
		this.mContext = context;
	}

	protected LayoutInflater getLayoutInflater(){
		return LayoutInflater.from(mContext);
	}
	
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

}
