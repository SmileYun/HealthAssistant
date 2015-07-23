package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;

public class Li_AdapterListViewHealthinformation extends AdapterBase {
	private ViewHolder mViewHolder;

	public Li_AdapterListViewHealthinformation(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		if (convertView == null) {

			mViewHolder = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.more_ui_problem_item, null);
			mViewHolder.iCon = (ImageView) convertView.findViewById(R.id.listview_image_icon);
			mViewHolder.tName = (TextView) convertView.findViewById(R.id.linearLayout_text_Problem);
			mViewHolder.iConimage = (ImageView) convertView.findViewById(R.id.listview_image);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		mViewHolder.iCon.setImageResource(R.drawable.hea_item0);
		mViewHolder.tName.setText((String) mList.get(position).get("name"));
		mViewHolder.iConimage.setImageResource(R.drawable.icon_arrow_right_small);
		return convertView;
	}

	class ViewHolder {

		ImageView iCon;
		TextView tName;
		ImageView iConimage;
	}

}
