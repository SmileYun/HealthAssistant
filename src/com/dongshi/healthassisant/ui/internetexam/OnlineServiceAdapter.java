package com.dongshi.healthassisant.ui.internetexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dongshi.healthassisant.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OnlineServiceAdapter extends BaseAdapter {

	 
	  private Context context = null;
	  List<Map<String, String>> dataList = new ArrayList();
	  private LayoutInflater layoutInflater;
	  
	  public OnlineServiceAdapter(Context paramContext, List<Map<String, String>> paramList)
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
	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		// TODO Auto-generated method stub
		
		ViewHolder holder;
		 if (paramView == null)
	      {
			 paramView = this.layoutInflater.inflate(R.layout.xj_listview_nohead_onlineservice_item, null);
			 holder = new ViewHolder();
		         
			 holder.txtuserphone = ((TextView)paramView.findViewById(R.id.txtuserphone));
			 holder.txtuserphone_msg = ((TextView)paramView.findViewById(R.id.txtuserphone_msg));
			 holder.txtquestioncontent = ((TextView)paramView.findViewById(R.id.txtquestioncontent)); 
		        paramView.setTag(holder);
	      }
		 else
		 {
			 holder=(ViewHolder)paramView.getTag();
		 }
		 holder.txtuserphone.setText((String) dataList.get(paramInt).get("phone"));
		 holder.txtuserphone_msg.setText((String) dataList.get(paramInt).get("txtuserphone_msg"));
		 holder.txtquestioncontent.setText((String) dataList.get(paramInt).get("qcontent"));
		return paramView;
	}
	class ViewHolder{
		 
		TextView txtuserphone, txtuserphone_msg,txtquestioncontent;
	}
}
