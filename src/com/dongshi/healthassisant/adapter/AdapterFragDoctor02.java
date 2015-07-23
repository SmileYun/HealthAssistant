package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterGridViewMain.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Yun
 */
public class AdapterFragDoctor02 extends AdapterBase {

	private ViewHolder mViewHolder;

	public AdapterFragDoctor02(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.listview_item_yuyueguahao, null);
			mViewHolder.tTime = (TextView) convertView.findViewById(R.id.yuyueguahao_time);
			mViewHolder.tPrice = (TextView) convertView.findViewById(R.id.yuyueguahao_price);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		mViewHolder.tTime.setText((String) mList.get(position).get("time"));
		mViewHolder.tPrice.setText((String) mList.get(position).get("price"));

		return convertView;
	}

	class ViewHolder {
		ImageView iYuyue;
		TextView tTime, tPrice;
	}
}
