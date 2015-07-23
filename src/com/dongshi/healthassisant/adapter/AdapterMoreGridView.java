package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Yun
 */
public class AdapterMoreGridView extends AdapterBase {
	private ArrayList<HashMap<String, Object>> mList;
	Context context;
	LinearLayout mViewGvHolder = null;

	public AdapterMoreGridView(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder;
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			View view = getLayoutInflater().inflate(R.layout.gridview_item, null);
			mViewHolder.img = (ImageView) view.findViewById(R.id.item_icon_gridview_main);
			mViewHolder.txtv = (TextView) view.findViewById(R.id.item_name_gridview_main);
			view.setTag(convertView);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		mViewHolder.img.setImageResource((Integer) mList.get(position).get("itemGridImgRes"));
		mViewHolder.txtv.setText((String) mList.get(position).get("itemGridName"));
		return null;
	}

	class ViewHolder {
		ImageView img;
		TextView txtv;
	}
}
