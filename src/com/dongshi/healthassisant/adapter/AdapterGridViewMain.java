package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * @author Yun
 */
public class AdapterGridViewMain extends AdapterBase{
    int LinearLayoutheight=0;
	LinearLayout mViewGvHolder = null;

	public AdapterGridViewMain(Context context, ArrayList<HashMap<String, Object>> mList,int i) {
		super(context, mList);
		LinearLayoutheight=i;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder;
	
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView  = getLayoutInflater().inflate(R.layout.main_gridview_item, null);	
			mViewHolder.img = (ImageView) convertView.findViewById(R.id.item_icon_gridview_main);
		
			mViewHolder.img.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LinearLayoutheight/2));
			
			convertView.setTag(mViewHolder);
			
		
		}else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		mViewHolder.img.setImageResource((Integer) mList.get(position).get("itemGridImgRes"));
		
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView img;
	
	}
}
