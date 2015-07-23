package com.dongshi.healthassisant.ui.tabact;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.tabact.TabMain.ItemClickListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class TabMore extends Activity implements OnClickListener {
	private Context mContext;
	private int[] imageView={R.drawable.about,R.drawable.problem,R.drawable.statement,R.drawable.aboutpone};
	private String[] aboutStrings;
	private ListView listView;
	private Class[] clazz = {TabMore_About.class,TabMore_Problem.class,TabMore_Statement.class,TabMore_About.class};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_ui);
		// ImageView view=(ImageView) findViewById(R.id.imageView1);
		// view.setOnClickListener(this);
		aboutStrings = new String[] { "关于我们", "常见问题", "免责声明", "联系客服" };
		listView = (ListView) findViewById(R.id.linearLayout_tabmore_listview);
		
		 getData() ;
	}

	private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < imageView.length; j++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("listview_image", imageView[j]);
			map.put("linearLayout_text", aboutStrings[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
					R.layout.more_ui_item, new String[] { "listview_image",
							"linearLayout_text" }, new int[] { R.id.listview_image,
							R.id.linearLayout_text, });
			listView.setAdapter(listItemAdapter);
			listView.setOnItemClickListener(new ItemClickListener());
		}
	

	}

		final class ItemClickListener implements OnItemClickListener{

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					Intent i = new Intent(mContext, clazz[position]);
					mContext.startActivity(i);
			}
		}
	 
	 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		// Intent intent = new Intent(mContext, TabMore_UserManage.class);
		// startActivity(intent);

	}

}
