package com.dongshi.healthassisant.ui.healthinformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;

import com.dongshi.healthassisant.adapter.Li_AdapterListViewHealthinformation;

public class healthinformation_item01 extends Activity implements
		OnClickListener, OnItemClickListener {
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList;
	private TextView titleName;
	private ImageView mBack;
	private String[] itemString ;
	private ImageView imageIcon;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.li_healthinformation_encyclopedias_item);
		mList = new ArrayList<HashMap<String, Object>>();
		initView();
	}

	private void initView() {
	
		titleName = (TextView) findViewById(R.id.title_name);
		titleName.setText(getIntent().getStringExtra("titleName"));
		
		itemString=getIntent().getStringArrayExtra("arraylistItemName");

		mListView = (ListView) findViewById(R.id.listview_li_healthinformation);
		
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);

		mList = getData();
		mListView.setAdapter(new Li_AdapterListViewHealthinformation(this,
				mList));
	

		mListView.setOnItemClickListener(this);
	}

	private ArrayList<HashMap<String, Object>> getData() {
	
		for (int i = 0; i < itemString.length; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("name", itemString[i]);
			mList.add(m);
		}
		return mList;

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
       Log.i("kyo", position+"  position");
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}

}
