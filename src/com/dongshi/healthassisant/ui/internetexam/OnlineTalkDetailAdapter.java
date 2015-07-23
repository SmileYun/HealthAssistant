package com.dongshi.healthassisant.ui.internetexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.internetexam.OnlineServiceAdapter.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class OnlineTalkDetailAdapter extends BaseAdapter {

	 
	private Context context = null;
	  List<Map<String, String>> dataList = new ArrayList();
	  private LayoutInflater layoutInflater;
	  
	  public OnlineTalkDetailAdapter(Context paramContext, List<Map<String, String>> paramList)
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
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
 

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String msgtype=(String) dataList.get(position).get("type");
		if(msgtype=="0")
		{
			AskHolder askHolder=null;
			if (convertView == null)
		      {
				convertView = this.layoutInflater.inflate(R.layout.xj_online_question_talk_detail_ask_item, null);
				 askHolder = new AskHolder();
			         
				 askHolder.txtaskcontent = ((TextView)convertView.findViewById(R.id.txtaskcontent));
				 askHolder.send_time = ((TextView)convertView.findViewById(R.id.send_time)); 
				 convertView.setTag(askHolder);
		      }
			 else
			 {
				 askHolder=(AskHolder)convertView.getTag();
			 }
			askHolder.txtaskcontent.setText((String) dataList.get(position).get("content"));
			askHolder.send_time.setText((String) dataList.get(position).get("send_time"));
			return convertView;
		}
		else
		{
			AnswerHolder answerHolder=null;
			if (convertView == null)
		      {
				convertView = this.layoutInflater.inflate(R.layout.xj_online_question_talk_detail_answer_item, null);
				answerHolder = new AnswerHolder();
			         
				answerHolder.txtanswercontent = ((TextView)convertView.findViewById(R.id.txtanswercontent));
				answerHolder.send_time = ((TextView)convertView.findViewById(R.id.send_time)); 
				 convertView.setTag(answerHolder);
		      }
			 else
			 {
				 answerHolder=(AnswerHolder)convertView.getTag();
			 }
			answerHolder.txtanswercontent.setText((String) dataList.get(position).get("content"));
			answerHolder.send_time.setText((String) dataList.get(position).get("send_time"));
			return convertView;
		} 
	}
	
	class AskHolder{
		 
		TextView txtaskcontent, send_time;
	}
	
	class AnswerHolder{
		 
		TextView txtanswercontent, send_time;
	}

}
