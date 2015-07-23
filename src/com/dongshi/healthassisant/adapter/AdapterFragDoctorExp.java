package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterFragDoctor02.ViewHolder;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdapterFragDoctorExp extends AdapterBase {
	private Context context;
	private ArrayList<HashMap<String, Object>> mList;

	public AdapterFragDoctorExp(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mViewHolder = new ViewHolder();
		if (convertView == null) {
			mViewHolder = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.fragment_doctor_experence_listview_item, null);
			mViewHolder.rExp_01 = (RatingBar) convertView.findViewById(R.id.rExp_01);
			mViewHolder.tExp_01 = (TextView) convertView.findViewById(R.id.tExp_01);
			mViewHolder.tExp_content_02 = (TextView) convertView.findViewById(R.id.tExp_content_02);
			mViewHolder.tExp_time_02 = (TextView) convertView.findViewById(R.id.tExp_time_02);
			mViewHolder.tExp_name_02 = (TextView) convertView.findViewById(R.id.tExp_name_02);
			
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		//mViewHolder.rExp_01.setRating(2.5f);
		//mViewHolder.tExp_01.setText((String) mList.get(position).get("tExp_01"));
		//mViewHolder.tExp_content_02.setText((String) mList.get(position).get("tExp_content_02"));
		//mViewHolder.tExp_time_02.setText((String) mList.get(position).get("tExp_time_02"));
		//mViewHolder.tExp_name_02.setText((String) mList.get(position).get("tExp_name_02"));
		return convertView;
	}

	class ViewHolder {
		RatingBar rExp_01;
		TextView tExp_01, tExp_content_02, tExp_time_02, tExp_name_02;
	}
}
