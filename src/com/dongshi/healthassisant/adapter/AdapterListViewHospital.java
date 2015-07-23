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
 * 医院选择适配器
 * 
 * @author YUN
 */
public class AdapterListViewHospital extends AdapterBase {

	public AdapterListViewHospital(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder _h;
		if (convertView == null) {
			_h = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.listview_item_hospital_register, null);
			_h.imgHospDetail = (ImageView) convertView.findViewById(R.id.hospital_img);
			_h.tvHospDetail01 = (TextView) convertView.findViewById(R.id.hospdetail_tv01);
			_h.tvHospDetail02 = (TextView) convertView.findViewById(R.id.hospdetail_tv02);
			_h.tvHospDetail03 = (TextView) convertView.findViewById(R.id.hospdetail_tv03);
			convertView.setTag(_h);
		} else {
			_h = (ViewHolder) convertView.getTag();
		}

		_h.imgHospDetail.setImageResource(R.drawable.hospital_home_default);
//		_h.tvHospDetail01.setText("常州市中医医院" + position);
		
		_h.tvHospDetail01.setText(mList.get(position).get("hospital")+"");
		_h.tvHospDetail02.setText("二级医院");
		_h.tvHospDetail03.setText("患者数 ：" + (388+position * 9) + " 人 ");
		return convertView;
	}

	class ViewHolder {
		ImageView imgHospDetail;// hospital_img
		TextView tvHospDetail01, tvHospDetail02, tvHospDetail03;
	}
}
