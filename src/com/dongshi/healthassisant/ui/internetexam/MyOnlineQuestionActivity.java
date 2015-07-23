package com.dongshi.healthassisant.ui.internetexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;

public class MyOnlineQuestionActivity extends BaseActivity_XJ {

	private List<Map<String, String>> questionDatas = new ArrayList();
	
	private OnlineServiceAdapter myAdapter;
	
	public void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle);
	    setContentView(R.layout.xj_listview_nohead_myonline_question);
	    initTitle("我的咨询");
//	    Intent localIntent = getIntent();
//	    this.newsId = localIntent.getStringExtra("newsId");
//	    initTitle(localIntent.getStringExtra("newsTitle"));
//	    this.tvTitle.setTextSize(16.0F);
//	    this.tvTitle.setTextSize(16.0F);
	    getData();
	    initLayout();
	  }
	
	public void getData() {
		Map<String, String> map = new HashMap<String, String>();
		for(int i=1;i<2;i++)
		{
			map = new HashMap<String, String>();
			map.put("Id", String.valueOf(i));
			map.put("phone", "138****8888");
			map.put("txtuserphone_msg", "2014-10-24");
			map.put("qcontent",getResources().getString(R.string.online_msg) );
			questionDatas.add(map);
		}
	}
	
	public void initLayout() {
		if (this.myAdapter == null) {
			ListView myquestionlist = (ListView)findViewById(R.id.myquestionlist);
			this.myAdapter = new OnlineServiceAdapter(MyOnlineQuestionActivity.this,
					this.questionDatas);
			myquestionlist.setAdapter(this.myAdapter);
			myquestionlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(
						AdapterView<?> paramAnonymousAdapterView,
						View paramAnonymousView, int paramAnonymousInt,
						long paramAnonymousLong) {
					//OnlineCustomerService.this.openNewsInfo(paramAnonymousInt);
					Intent localIntent = new Intent(MyOnlineQuestionActivity.this,
							OnlineTalkDetailActivity.class);
					//传递参数
					localIntent.putExtra("type",1);
					localIntent.putExtra("isnewq",1);
					startActivity(localIntent);
				}
			});
			return;
		}

		this.myAdapter.notifyDataSetChanged();

	}
	
}
