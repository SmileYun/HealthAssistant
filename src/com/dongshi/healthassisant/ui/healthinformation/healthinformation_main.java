package com.dongshi.healthassisant.ui.healthinformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.Li_AdapgetHealthinformation;

public class healthinformation_main extends Activity implements OnClickListener {
	private Context mContext;
	private List<View> viewlist;
	private ViewPager viewPager;
	private List<String> titlelist;
	private TextView textView;
	private GridView gridView;
	private ListView listView;
	private ListView listViewTab2;
	private String[] gvnewsTitleStrings;
	private int[] gvimageView = { R.drawable.healthinformathion_image1,
			R.drawable.healthinformathion_image2 };
	private int[] lvimageView = { R.drawable.healthinformathion_image3,
			R.drawable.healthinformathion_image4,
			R.drawable.healthinformathion_image5 };

	private int[] lvtab2imageView;
	private String[] lvnewsTitleStrings;
	private String[] lvnewsTitleStringsTime;
	private String[] lvtba2Strings;
	private Class[] clazzpager1 = new Class[] {
			healthinformation_context.class, healthinformation_context.class,
			healthinformation_context.class, };

	private Class[] clazzPager2 = new Class[] { healthinformation_item01.class,
			healthinformation_item01.class, healthinformation_item01.class,
			healthinformation_item01.class, healthinformation_item01.class };

	private int falg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.li_healthinformation);
		gvnewsTitleStrings = new String[] { "流感疫苗=感冒卫士？", "如何让宝宝科学'秋冻'" };
		lvnewsTitleStrings = new String[] { "中医交你做好月子", "金秋十月养生经",
				"天冷了 简单9招预防流行感冒" };
		lvnewsTitleStringsTime = new String[] { "2010-09-23", "2010-10-21",
				"2010-10-24" };
		textView = (TextView) findViewById(R.id.title_name);
		textView.setText("健康资讯");

		viewlist = new ArrayList<View>();
		View view1 = View.inflate(this, R.layout.li_healthinformation_view1,
				null);
		final View view2 = View.inflate(this,
				R.layout.li_healthinformation_view2, null);
		gridView = (GridView) view1.findViewById(R.id.gridView1);
		listView = (ListView) view1.findViewById(R.id.listView1);
		listViewTab2 = (ListView) view2
				.findViewById(R.id.linearLayout_heal_listview);

		viewlist.add(view1);
		viewlist.add(view2);
		titlelist = new ArrayList<String>();
		titlelist.add("最新热点");
		titlelist.add("健康百科");

		viewPager = (ViewPager) findViewById(R.id.pager_view_li);
		// 传入view集合
		Li_AdapgetHealthinformation li_adapter = new Li_AdapgetHealthinformation(
				viewlist, titlelist);
		viewPager.setAdapter(li_adapter);
		//
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				Log.i("kyo", "select  " + arg0 + "");
				falg = arg0;
				if (arg0 == 1) {

					lvtba2Strings = new String[] { "疾病库", "药物库", "急救库",
							"检验单解读", "疫苗接种提醒" };
					lvtab2imageView = new int[] { R.drawable.hea_item0,
							R.drawable.hea_item1, R.drawable.hea_item2,
							R.drawable.hea_item3, R.drawable.hea_item4 };
					getDatalist();

				} else if (arg0 == 0) {

				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		getData();
		getDatalistview();

		ImageView imageViewReturn = (ImageView) findViewById(R.id.more_return_btn);
		imageViewReturn.setOnClickListener(this);
	}

	private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < gvnewsTitleStrings.length; j++) {
			Log.i("kyo", gvnewsTitleStrings[j]);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_text", gvnewsTitleStrings[j]);
			map.put("hospitalinformation_image", gvimageView[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
					R.layout.li_healthinformation_view1_gvitem, new String[] {
							"hospitalinformation_text",
							"hospitalinformation_image" }, new int[] {
							R.id.healthinformathion_text,
							R.id.healthinformathion_image, });
			gridView.setAdapter(listItemAdapter);

		}

	}

	private void getDatalistview() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < lvnewsTitleStrings.length; j++) {
			Log.i("kyo", lvnewsTitleStrings[j]);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_text", lvnewsTitleStrings[j]);
			map.put("hospitalinformation_image", lvimageView[j]);
			map.put("hospitalinformation_text_time", lvnewsTitleStringsTime[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
					R.layout.li_healthinformation_view1_lsitem, new String[] {
							"hospitalinformation_text",
							"hospitalinformation_image",
							"hospitalinformation_text_time" }, new int[] {
							R.id.healthinformathion_text,
							R.id.healthinformathion_image,
							R.id.healthinformathion_text_time });
			listView.setAdapter(listItemAdapter);
			listView.setOnItemClickListener(new ItemClickListener());
		}

	}

	// 第二页数据加载
	private void getDatalist() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		Log.i("kyo", "getDatalist");
		for (int j = 0; j < lvtba2Strings.length; j++) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_text", lvtba2Strings[j]);
			map.put("hospitalinformation_image", lvtab2imageView[j]);

			listItem.add(map);

			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
					R.layout.more_ui_problem_item, new String[] {
							"hospitalinformation_text",
							"hospitalinformation_image" }, new int[] {
							R.id.linearLayout_text_Problem,
							R.id.listview_image_icon });

			listViewTab2.setAdapter(listItemAdapter);
			listViewTab2.setOnItemClickListener(new ItemClickListener());
		}

	}

	final class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = null;
			if (falg == 0) {
				i = new Intent(mContext, clazzpager1[position]);
			} else if (falg == 1) {
				i = new Intent(mContext, clazzPager2[position]);
				// 获得选择 item的项
				HashMap<String, Object> map = (HashMap<String, Object>) listViewTab2
						.getItemAtPosition(position);
			
				
				String[] itemString = null;
				
				// 得到该项里 对应id的控件的值
				String title = (String) map.get("hospitalinformation_text");
				//ImageView imageView=(ImageView) map.get("hospitalinformation_image");
				if (position == 0) {
					itemString = new String[] { "常见疾病", "按部位查询", "按字母查询",
							"按科室查询" };
				} else if (position == 1) {
					itemString = new String[] { "常用药物", "药物分类", "用药须知", "抢救药物" };

				} else if (position == 2) {
					itemString = new String[] { "疾病救急", "运动救急", "日常救急", "中毒救急",
							"野外救急", "灾难救急", "外伤止血" };
				} else {
					itemString = new String[] { "疾病救急", "运动救急", "日常救急", "中毒救急",
							"野外救急", "灾难救急", "外伤止血" };
				}
				
				i.putExtra("titleName", title);
				i.putExtra("arraylistItemName", itemString);
			
			}
			startActivity(i);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}

}
