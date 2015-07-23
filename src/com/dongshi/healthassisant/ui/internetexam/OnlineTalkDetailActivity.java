package com.dongshi.healthassisant.ui.internetexam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;

public class OnlineTalkDetailActivity extends BaseActivity_XJ {

	private List<Map<String, String>> questionDatas = new ArrayList();
	private OnlineTalkDetailAdapter myAdapter;

	private int questiontype = 0;
	private int isnewq = 0;

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.xj_online_question_talk_detail);
		Intent localIntent = getIntent();
		this.questiontype = localIntent.getExtras().getInt("type");
		this.isnewq = localIntent.getExtras().getInt("isnewq");

		// Intent localIntent = getIntent();
		// this.newsId = localIntent.getStringExtra("newsId");
		// initTitle(localIntent.getStringExtra("newsTitle"));
		// this.tvTitle.setTextSize(16.0F);
		// this.tvTitle.setTextSize(16.0F);
		if (this.questiontype == 0) {
			initTitle("咨询历史");
			View askbottom = (View) findViewById(R.id.layaskbottom);
			askbottom.setVisibility(View.GONE);
		} else {
			if(this.isnewq==0)
			{
				initTitle("我正在咨询");
			}
			else
			{
				initTitle("我的咨询详情");
			}
			View askbottom = (View) findViewById(R.id.layaskbottom);
			askbottom.setVisibility(View.VISIBLE);
		}
		initLayout();
	}

	public void getData() {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 2; i++) {
			map = new HashMap<String, String>();
			if (i % 2 == 0) {
				map.put("type", "0");
				map.put("content", "医生您好，我想问一下，五灵丸是在什么情况下服用的。");
			} else {
				map.put("type", "1");
				map.put("content", "您好，五灵丸是一种安神、补气药品，一般情况是在气喘、心烦意乱、心慌等情况下服用。");
			}
			SimpleDateFormat sDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd   hh:mm:ss");
			String date = sDateFormat.format(new java.util.Date());
			// map.put("txtaskcontent", "问一下问一下问一下问一下问一下问一下问一下问一下问一下问一下问一下问一下");
			map.put("send_time", date);
			questionDatas.add(map);
		}
	}

	private void initLayout() {
		if (this.isnewq == 1) {
			getData();
			// this.btBack.setVisibility(View.INVISIBLE);
			if (this.myAdapter == null) {
				ListView talklist = (ListView) findViewById(R.id.talklist);
				this.myAdapter = new OnlineTalkDetailAdapter(
						OnlineTalkDetailActivity.this, this.questionDatas);
				talklist.setAdapter(this.myAdapter);

				return;
			}

			this.myAdapter.notifyDataSetChanged();
		}

	}

}
