package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

/**
 * 
 * @author YUN
 *
 */
public class AdapterLVItemSimpleTVAndArrow extends AdapterBase {
	private ArrayList<HashMap<String, Object>> mList;
	private Context context;

	public AdapterLVItemSimpleTVAndArrow(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
		this.mList = mList;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder;
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_simple_tandarrow, null);

			mViewHolder.tName = (TextView) convertView.findViewById(R.id.hospdetail_tv01);

			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		mViewHolder.tName.setText((String) mList.get(position).get("name"));

		return convertView;
	}

	class ViewHolder {
		TextView tName;
	}

}
