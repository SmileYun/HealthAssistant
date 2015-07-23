package com.dongshi.healthassisant.ui.tabact;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.tabact.TabMore.ItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TabMore_Problem_Items extends Activity implements OnClickListener{
	private Context mContext;
	private TextView textView;
	private ListView listView;
	private String[] aboutStrings;
   @Override
protected void onCreate(Bundle savedInstanceState) {
	   mContext=this;
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.more_ui_problem_band);
	Log.i("kyo", "more_ui_problem_band_items ");
	ImageView imageView=(ImageView) findViewById(R.id.more_return_btn_Problem);
	imageView.setOnClickListener(this);
	Log.i("kyo", "linearLayout_tabmore_listview ");
	listView = (ListView) findViewById(R.id.linearLayout_tabmore_listview);
	Log.i("kyo", "linearLayout_tabmore_listview ");
	textView=(TextView) findViewById(R.id.title_name);
	textView.setText("关于就诊卡绑定");
	aboutStrings = new String[] {this.getString(R.string.more_problem_item)};

	getData();
}

   
   private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < 5; j++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("linearLayout_text", aboutStrings[0]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem, R.layout.more_ui_problem_band_items, new String[] { "linearLayout_text" },
					new int[] { R.id.linearLayout_text_Problem });
			listView.setAdapter(listItemAdapter);
			listView.setOnItemClickListener(new ItemClickListener());
		}
	

	}
   final class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//Intent i = new Intent(mContext, clazz[position]);
				//mContext.startActivity(i);
		}
	}
   
@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	finish();
}
}
