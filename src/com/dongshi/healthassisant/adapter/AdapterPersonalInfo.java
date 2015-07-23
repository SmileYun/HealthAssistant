package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;

/**
 * 
 * @author YUN
 *
 */
public class AdapterPersonalInfo extends AdapterBase {
	public AdapterPersonalInfo(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder;
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.listview_item_personal_info, null);

			mViewHolder.tName = (TextView) convertView.findViewById(R.id.personal_left_tv);
			mViewHolder.left = (ImageView) convertView.findViewById(R.id.personal_left_img);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		mViewHolder.tName.setText((String) mList.get(position).get("name"));
		mViewHolder.left.setBackgroundResource((Integer) mList.get(position).get("icon"));

		return convertView;
	}

	class ViewHolder {
		TextView tName;
		ImageView left;
	}
}
