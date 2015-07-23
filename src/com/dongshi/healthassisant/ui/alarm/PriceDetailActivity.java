package com.dongshi.healthassisant.ui.alarm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ; 
 
public class PriceDetailActivity extends BaseActivity_XJ {

	private List<Map<String, String>> datas = new ArrayList();
	private PriceDetailAdapter myAdapter;
	ListView hjlist=null;
	public void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle);
	    setContentView(R.layout.xj_listview_nohead_pricedetail);
	    initTitle("划价详情");
	    //this.hjlist=(ListView) findViewById(R.id.hjlist);
	    getData();
	    initLayout();
	  }
	
	public void getData() {
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<3;i++)
		{
			map = new HashMap<String, String>();
			 if(i==0)
			 {
			map.put("medicename", "材料费");
			map.put("mediceprice", "￥1.5");
			 }
			 else if(i==1)
			 {
			map.put("medicename", "化验费");
			map.put("mediceprice", "￥33.5");
			 }
			 else if(i==2)
			 {
			map.put("medicename", "报告单费");
			map.put("mediceprice", "￥4.5");
			 }
			datas.add(map);
		}
	}
	
	public void initLayout() {
		if (this.myAdapter == null) {
			ListView hjlist = (ListView)findViewById(R.id.hjlist);
			this.myAdapter = new PriceDetailAdapter(PriceDetailActivity.this,
					this.datas);
			hjlist.setAdapter(this.myAdapter);
			 
			return;
		}

		this.myAdapter.notifyDataSetChanged();

	}
}
