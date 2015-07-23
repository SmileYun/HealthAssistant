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

public class TabMore_Problem extends Activity implements OnClickListener {
	private Context mContext;
	private TextView textView;
	private ListView listView;
	private String[] aboutStrings;
	private Class[] clazz = { TabMore_Problem_Items.class,
			TabMore_Problem_Items.class, TabMore_Problem_Items.class,
			TabMore_Problem_Items.class, TabMore_Problem_Items.class };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_ui_problem);
		ImageView imageView = (ImageView) findViewById(R.id.more_return_btn);
		imageView.setOnClickListener(this);
		listView = (ListView) findViewById(R.id.linearLayout_tabmore_listview);

		textView = (TextView) findViewById(R.id.title_name);
		textView.setText("常见问题");
		aboutStrings = new String[] { "关于就诊卡绑定", "关于就诊后的付费&退费", "关于预约挂号",
				"关于账户的取现", "其他" };
		getData();
	}

	private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < aboutStrings.length; j++) {
			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("linearLayout_text", aboutStrings[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
					R.layout.more_ui_problem_item,
					new String[] { "linearLayout_text" },
					new int[] { R.id.linearLayout_text_Problem });
			listView.setAdapter(listItemAdapter);
			listView.setOnItemClickListener(new ItemClickListener());
		}

	}

	final class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Log.i("kyo", "position " + position);
			Intent i = new Intent(mContext, clazz[position]);
			Log.i("kyo", "position1 " + position);
			mContext.startActivity(i);
			Log.i("kyo", "position2 " + position);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}
}
