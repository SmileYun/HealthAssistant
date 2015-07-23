package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterListViewHospital.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * text Îª¼ü
 * 
 * @author YUN
 */
public class AdapterText extends AdapterBase {
	public static int mCurrentSelectedItem = 0;

	public AdapterText(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder _h;
		if (convertView == null) {
			_h = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.general_listview_item, null);
			_h.text = (TextView) convertView.findViewById(R.id.generaltext);
			convertView.setTag(_h);

		} else {
			_h = (ViewHolder) convertView.getTag();
		}
		if (mCurrentSelectedItem == position) {
			convertView.setBackgroundColor(mContext.getResources().getColor(R.color.lv_green_dan));
		} else {
			convertView.setBackgroundColor(mContext.getResources().getColor(R.color.transparent));
		}

		_h.text.setText("" + (CharSequence) mList.get(position).get("text"));
		return convertView;
	}

	class ViewHolder {
		TextView text;
	}

}
