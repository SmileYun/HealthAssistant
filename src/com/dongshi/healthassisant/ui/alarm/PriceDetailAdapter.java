package com.dongshi.healthassisant.ui.alarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dongshi.healthassisant.R;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PriceDetailAdapter extends BaseAdapter {

	private Context context = null;
	  List<Map<String, String>> dataList = new ArrayList();
	  private LayoutInflater layoutInflater;
	
	  public PriceDetailAdapter(Context paramContext, List<Map<String, String>> paramList)
	  {
	    this.context = paramContext;
	    this.dataList = paramList;
	    this.layoutInflater = LayoutInflater.from(paramContext);
	  }
	  
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataList.size();
	}

	@Override
	public Object getItem(int index) {
		// TODO Auto-generated method stub
		return dataList.get(index);
	}

	@Override
	public long getItemId(int index) {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder askHolder=null;
		if (convertView == null)
	      {
			convertView = this.layoutInflater.inflate(R.layout.xj_listview_nohead_pricedetail_item, null);
			 askHolder = new Holder();
		         
			 askHolder.txtmedicename = ((TextView)convertView.findViewById(R.id.txtmedicename));
			 askHolder.txtmediceprice = ((TextView)convertView.findViewById(R.id.txtmediceprice)); 
			 convertView.setTag(askHolder);
	      }
		 else
		 {
			 askHolder=(Holder)convertView.getTag();
		 }
		askHolder.txtmedicename.setText((String) dataList.get(position).get("medicename"));
		askHolder.txtmediceprice.setText((String) dataList.get(position).get("mediceprice"));
		return convertView;
	}
	
	class Holder{
		 
		TextView txtmedicename, txtmediceprice;
	}


}
