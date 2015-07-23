package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterGridViewMain.ViewHolder;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author 	YUN
 */
public class AdapterDocterLVItem extends AdapterBase{

	
	
	public AdapterDocterLVItem(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder;
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView  = getLayoutInflater().inflate(R.layout.act_doctor_detail_listview_item, null);
			mViewHolder.iCount = (ImageView) convertView.findViewById(R.id.doctor_detail_paint_img_count);
			mViewHolder.tName = (TextView) convertView.findViewById(R.id.doctor_detail_name);
			mViewHolder.tContent = (TextView) convertView.findViewById(R.id.doctor_detail_content);
			mViewHolder.tGoodAt = (TextView) convertView.findViewById(R.id.doctor_detail_good_at);
			mViewHolder.tLevel = (TextView) convertView.findViewById(R.id.doctor_detail_level);
			mViewHolder.tCount = (TextView) convertView.findViewById(R.id.doctor_detail_paint_count);
			
			convertView.setTag(mViewHolder);
		}else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		
		
		mViewHolder.tName.setText((String) mList.get(position).get("name"));
		mViewHolder.tContent.setText((String) mList.get(position).get("content"));
		mViewHolder.tGoodAt.setText((String) mList.get(position).get("goodar"));
		mViewHolder.tCount.setText(""+Integer.valueOf((Integer) mList.get(position).get("count")));
		mViewHolder.tLevel.setText((String) mList.get(position).get("level"));
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView iCount;
		TextView tName, tGoodAt, tContent, tLevel, tCount;
	}

}
